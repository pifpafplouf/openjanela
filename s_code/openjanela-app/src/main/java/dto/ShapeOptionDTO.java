package dto;

import Model.DesignOption;
import Model.ShapeOption;
import Presentation.ItemFrame;
import openjanela.model.entities.design.ConstructionMap;
import openjanela.model.entities.design.DesignOptionEntityObject;
import openjanela.model.entities.design.ShapeOptionEntityObject;
import openjanela.model.entities.partner.OptionAnswers;
import openjanela.model.entities.partner.OptionAnswersPK;
import openjanela.model.entities.partner.OptionDefinitions;
import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 12-16-12
 *          Time: 12:50 AM
 */
public class ShapeOptionDTO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(DesignOptionDTO.class);

    /**
     * Return ShapeOption entity class
     *
     * @param shapeOption, ShapeOption model object
     * @return ShapeOptionEntityObject
     * @throws DTOTransformationError, Error
     */
    public static ShapeOptionEntityObject getShapeOptionEntity(ShapeOption shapeOption) throws DTOTransformationError {

        if (shapeOption == null) {
            throw new DTOTransformationError();
        }

        //**************************************************************************
        //Creating and applying transformation
        //**************************************************************************
        ShapeOptionEntityObject shapeOptionEntity = new ShapeOptionEntityObject();

        ConstructionMap constructionMap = new ConstructionMap();
        constructionMap.set_a_assemblyLevel(shapeOption.a_assemblyLevel);
        constructionMap.set_a_1Level(shapeOption.a_1Level);
        constructionMap.set_a_2Level(shapeOption.a_2Level);
        constructionMap.set_a_3Level(shapeOption.a_3Level);
        constructionMap.set_a_4Level(shapeOption.a_4Level);
        constructionMap.set_a_5Level(shapeOption.a_5Level);
        constructionMap.set_a_6Level(shapeOption.a_6Level);
        constructionMap.set_a_7Level(shapeOption.a_7Level);
        constructionMap.set_a_8Level(shapeOption.a_8Level);
        constructionMap.set_a_9Level(shapeOption.a_9Level);
        constructionMap.set_a_10Level(shapeOption.a_10Level);
        constructionMap.set_a_11Level(shapeOption.a_11Level);
        constructionMap.set_a_12Level(shapeOption.a_12Level);
        constructionMap.set_a_13Level(shapeOption.a_13Level);
        constructionMap.set_a_14Level(shapeOption.a_14Level);
        constructionMap.set_a_15Level(shapeOption.a_15Level);
        constructionMap.set_a_16Level(shapeOption.a_16Level);
        constructionMap.set_a_17Level(shapeOption.a_17Level);
        constructionMap.set_a_18Level(shapeOption.a_18Level);
        constructionMap.set_a_19Level(shapeOption.a_19Level);
        constructionMap.set_a_20Level(shapeOption.a_20Level);
        constructionMap.set_a_21Level(shapeOption.a_21Level);
        constructionMap.set_a_22Level(shapeOption.a_22Level);
        constructionMap.set_a_1Sequence(shapeOption.a_1Sequence);
        constructionMap.set_a_2Sequence(shapeOption.a_2Sequence);
        constructionMap.set_a_3Sequence(shapeOption.a_3Sequence);
        constructionMap.set_a_4Sequence(shapeOption.a_4Sequence);
        constructionMap.set_a_5Sequence(shapeOption.a_5Sequence);
        constructionMap.set_a_6Sequence(shapeOption.a_6Sequence);
        constructionMap.set_a_7Sequence(shapeOption.a_7Sequence);
        constructionMap.set_a_8Sequence(shapeOption.a_8Sequence);
        constructionMap.set_a_9Sequence(shapeOption.a_9Sequence);
        constructionMap.set_a_10Sequence(shapeOption.a_10Sequence);
        constructionMap.set_a_11Sequence(shapeOption.a_11Sequence);
        constructionMap.set_a_12Sequence(shapeOption.a_12Sequence);
        constructionMap.set_a_13Sequence(shapeOption.a_13Sequence);
        constructionMap.set_a_14Sequence(shapeOption.a_14Sequence);
        constructionMap.set_a_15Sequence(shapeOption.a_15Sequence);
        constructionMap.set_a_16Sequence(shapeOption.a_16Sequence);
        constructionMap.set_a_17Sequence(shapeOption.a_17Sequence);
        constructionMap.set_a_18Sequence(shapeOption.a_18Sequence);
        constructionMap.set_a_19Sequence(shapeOption.a_19Sequence);
        constructionMap.set_a_20Sequence(shapeOption.a_20Sequence);
        constructionMap.set_a_21Sequence(shapeOption.a_21Sequence);
        constructionMap.set_a_22Sequence(shapeOption.a_22Sequence);

        //Setting construction map
        shapeOptionEntity.setConstructionMap(constructionMap);

        shapeOptionEntity.setRuleno(shapeOption.ruleno);
        shapeOptionEntity.setLevelId(shapeOption.a_levelID);
        shapeOptionEntity.setSequenceId(shapeOption.a_sequenceID);
        shapeOptionEntity.setAssemblyLevelId(shapeOption.a_assemblyLevel);
        shapeOptionEntity.setOptionId(shapeOption.optionid);
        shapeOptionEntity.setAnswerId(shapeOption.answerid);
        shapeOptionEntity.setAuto(shapeOption.isAuto);
        shapeOptionEntity.setQtyAnswer(shapeOption.qtyanswer);
        shapeOptionEntity.setSizeAnswer(shapeOption.sizeanswer);
        shapeOptionEntity.setSizeAnswerI(shapeOption.sizeansweri);
        shapeOptionEntity.setDepthAnswer(shapeOption.depthanswer);
        shapeOptionEntity.setDepthAnswerI(shapeOption.depthansweri);
        shapeOptionEntity.setAdjust(shapeOption.adjust);
        shapeOptionEntity.setAdjustI(shapeOption.adjusti);
        shapeOptionEntity.setTextAnswer(shapeOption.textAnswer);
        shapeOptionEntity.setPrice(shapeOption.price);
        shapeOptionEntity.setPriceUser(shapeOption.priceUser);
        shapeOptionEntity.setPriceTotal(shapeOption.priceTotal);
        shapeOptionEntity.setPriceTotalUser(shapeOption.priceTotalUser);
        shapeOptionEntity.setCost(shapeOption.cost);
        shapeOptionEntity.setCostTotal(shapeOption.costTotal);
        shapeOptionEntity.setDiscountP(shapeOption.discountP);
        shapeOptionEntity.setW(shapeOption.w);
        shapeOptionEntity.setH(shapeOption.h);
        shapeOptionEntity.setWi(shapeOption.wi);
        shapeOptionEntity.setHi(shapeOption.hi);
        shapeOptionEntity.setD(shapeOption.d);
        shapeOptionEntity.setDi(shapeOption.di);
        shapeOptionEntity.setL(shapeOption.l);
        shapeOptionEntity.setLi(shapeOption.li);
        shapeOptionEntity.setPriceUOMId(shapeOption.priceuom);
        shapeOptionEntity.setCostUOMId(shapeOption.costuom);
        shapeOptionEntity.setPriceMeasureId(shapeOption.pricemeasure);
        shapeOptionEntity.setSeriesId(shapeOption.seriesid);
        shapeOptionEntity.setRemove(shapeOption.remove);
        shapeOptionEntity.setGlobal(shapeOption.global);

        shapeOptionEntity.setOptionDefinitionsTypeId(shapeOption.myoption.getOptiontypeid());

        shapeOptionEntity.setOptionDefinitionsId(shapeOption.myoption.getId());
        shapeOptionEntity.setOptionDefinitionDesc(shapeOption.myoption.getOptions());

        shapeOptionEntity.setOptionAnswersId(shapeOption.myanswer.getId().getId());
        shapeOptionEntity.setOptionAnswersDesc(shapeOption.myanswer.getDescription());
        shapeOptionEntity.setOptionAnswersStockCode(shapeOption.myanswer.getStockcode());
        shapeOptionEntity.setOptionAnswersAbbrev(shapeOption.myanswer.getAbbreviation());

        shapeOptionEntity.setSupplierId(shapeOption.supplierId);
        shapeOptionEntity.setSupplierSeriesId(shapeOption.supplierSeriesId);
        shapeOptionEntity.setRemote(shapeOption.remote);

        return shapeOptionEntity;
    }

    /**
     * Return ShapeOption model object
     *
     * @param itemFrame,         ItemFrame Main Panel
     * @param shapeOptionEntity, ShapeOptionEntityObject
     * @return ShapeOption
     * @throws DTOTransformationError, Error
     */
    public static ShapeOption getShapeOptionModel(ItemFrame itemFrame, ShapeOptionEntityObject shapeOptionEntity) throws DTOTransformationError {

        if (shapeOptionEntity == null) {
            throw new DTOTransformationError();
        }

        ShapeOption shapeOption = new ShapeOption();
        shapeOption.a_assemblyLevel = shapeOptionEntity.getAssemblyLevelId();
        shapeOption.a_1Level = shapeOptionEntity.getConstructionMap().get_a_1Level();
        shapeOption.a_2Level = shapeOptionEntity.getConstructionMap().get_a_2Level();
        shapeOption.a_3Level = shapeOptionEntity.getConstructionMap().get_a_3Level();
        shapeOption.a_4Level = shapeOptionEntity.getConstructionMap().get_a_4Level();
        shapeOption.a_5Level = shapeOptionEntity.getConstructionMap().get_a_5Level();
        shapeOption.a_6Level = shapeOptionEntity.getConstructionMap().get_a_6Level();
        shapeOption.a_7Level = shapeOptionEntity.getConstructionMap().get_a_7Level();
        shapeOption.a_8Level = shapeOptionEntity.getConstructionMap().get_a_8Level();
        shapeOption.a_9Level = shapeOptionEntity.getConstructionMap().get_a_9Level();
        shapeOption.a_10Level = shapeOptionEntity.getConstructionMap().get_a_10Level();
        shapeOption.a_11Level = shapeOptionEntity.getConstructionMap().get_a_11Level();
        shapeOption.a_12Level = shapeOptionEntity.getConstructionMap().get_a_12Level();
        shapeOption.a_13Level = shapeOptionEntity.getConstructionMap().get_a_13Level();
        shapeOption.a_14Level = shapeOptionEntity.getConstructionMap().get_a_14Level();
        shapeOption.a_15Level = shapeOptionEntity.getConstructionMap().get_a_15Level();
        shapeOption.a_16Level = shapeOptionEntity.getConstructionMap().get_a_16Level();
        shapeOption.a_17Level = shapeOptionEntity.getConstructionMap().get_a_17Level();
        shapeOption.a_18Level = shapeOptionEntity.getConstructionMap().get_a_18Level();
        shapeOption.a_19Level = shapeOptionEntity.getConstructionMap().get_a_19Level();
        shapeOption.a_20Level = shapeOptionEntity.getConstructionMap().get_a_20Level();
        shapeOption.a_21Level = shapeOptionEntity.getConstructionMap().get_a_21Level();
        shapeOption.a_22Level = shapeOptionEntity.getConstructionMap().get_a_22Level();
        shapeOption.a_1Sequence = shapeOptionEntity.getConstructionMap().get_a_1Sequence();
        shapeOption.a_2Sequence = shapeOptionEntity.getConstructionMap().get_a_2Sequence();
        shapeOption.a_3Sequence = shapeOptionEntity.getConstructionMap().get_a_3Sequence();
        shapeOption.a_4Sequence = shapeOptionEntity.getConstructionMap().get_a_4Sequence();
        shapeOption.a_5Sequence = shapeOptionEntity.getConstructionMap().get_a_5Sequence();
        shapeOption.a_6Sequence = shapeOptionEntity.getConstructionMap().get_a_6Sequence();
        shapeOption.a_7Sequence = shapeOptionEntity.getConstructionMap().get_a_7Sequence();
        shapeOption.a_8Sequence = shapeOptionEntity.getConstructionMap().get_a_8Sequence();
        shapeOption.a_9Sequence = shapeOptionEntity.getConstructionMap().get_a_9Sequence();
        shapeOption.a_10Sequence = shapeOptionEntity.getConstructionMap().get_a_10Sequence();
        shapeOption.a_11Sequence = shapeOptionEntity.getConstructionMap().get_a_11Sequence();
        shapeOption.a_12Sequence = shapeOptionEntity.getConstructionMap().get_a_12Sequence();
        shapeOption.a_13Sequence = shapeOptionEntity.getConstructionMap().get_a_13Sequence();
        shapeOption.a_14Sequence = shapeOptionEntity.getConstructionMap().get_a_14Sequence();
        shapeOption.a_15Sequence = shapeOptionEntity.getConstructionMap().get_a_15Sequence();
        shapeOption.a_16Sequence = shapeOptionEntity.getConstructionMap().get_a_16Sequence();
        shapeOption.a_17Sequence = shapeOptionEntity.getConstructionMap().get_a_17Sequence();
        shapeOption.a_18Sequence = shapeOptionEntity.getConstructionMap().get_a_18Sequence();
        shapeOption.a_19Sequence = shapeOptionEntity.getConstructionMap().get_a_19Sequence();
        shapeOption.a_20Sequence = shapeOptionEntity.getConstructionMap().get_a_20Sequence();
        shapeOption.a_21Sequence = shapeOptionEntity.getConstructionMap().get_a_21Sequence();
        shapeOption.a_22Sequence = shapeOptionEntity.getConstructionMap().get_a_22Sequence();

        shapeOption.ruleno = shapeOptionEntity.getRuleno();
        shapeOption.a_levelID = shapeOptionEntity.getLevelId();
        shapeOption.a_sequenceID = shapeOptionEntity.getSequenceId();
        shapeOption.a_assemblyLevel = shapeOptionEntity.getAssemblyLevelId();
        shapeOption.optionid = shapeOptionEntity.getOptionId();
        shapeOption.answerid = shapeOptionEntity.getAnswerId();
        shapeOption.isAuto = shapeOptionEntity.isAuto();
        shapeOption.qtyanswer = shapeOptionEntity.getQtyAnswer();
        shapeOption.sizeanswer = shapeOptionEntity.getSizeAnswer();
        shapeOption.sizeansweri = shapeOptionEntity.getSizeAnswerI();
        shapeOption.depthanswer = shapeOptionEntity.getDepthAnswer();
        shapeOption.depthansweri = shapeOptionEntity.getDepthAnswerI();
        shapeOption.adjust = shapeOptionEntity.getAdjust();
        shapeOption.adjusti = shapeOptionEntity.getAdjustI();
        shapeOption.textAnswer = shapeOptionEntity.getTextAnswer();
        shapeOption.price = shapeOptionEntity.getPrice();
        shapeOption.priceUser = shapeOptionEntity.getPriceUser();
        shapeOption.priceTotal = shapeOptionEntity.getPriceTotal();
        shapeOption.priceTotalUser = shapeOptionEntity.getPriceTotalUser();
        shapeOption.cost = shapeOptionEntity.getCost();
        shapeOption.costTotal = shapeOptionEntity.getCostTotal();
        shapeOption.discountP = shapeOptionEntity.getDiscountP();
        shapeOption.w = shapeOptionEntity.getW();
        shapeOption.h = shapeOptionEntity.getH();
        shapeOption.wi = shapeOptionEntity.getWi();
        shapeOption.hi = shapeOptionEntity.getHi();
        shapeOption.d = shapeOptionEntity.getD();
        shapeOption.di = shapeOptionEntity.getDi();
        shapeOption.l = shapeOptionEntity.getL();
        shapeOption.li = shapeOptionEntity.getLi();
        shapeOption.priceuom = shapeOptionEntity.getPriceUOMId();
        shapeOption.costuom = shapeOptionEntity.getCostUOMId();
        shapeOption.pricemeasure = shapeOptionEntity.getPriceMeasureId();
        shapeOption.seriesid = shapeOptionEntity.getSeriesId();
        shapeOption.remove = shapeOptionEntity.isRemove();
        shapeOption.global = shapeOptionEntity.isGlobal();

        if (!itemFrame.isSupplier) {
            shapeOption.supplierId = shapeOptionEntity.getSupplierId();
            shapeOption.supplierSeriesId = shapeOptionEntity.getSupplierSeriesId();
            shapeOption.remote = shapeOptionEntity.isRemote();
        }

        OptionDefinitions optionDefinitions = new OptionDefinitions();
        optionDefinitions.setId(shapeOptionEntity.getOptionDefinitionsId());
        optionDefinitions.setOptiontypeid(shapeOptionEntity.getOptionDefinitionsTypeId());
        optionDefinitions.setOptions(shapeOptionEntity.getOptionDefinitionDesc());
        shapeOption.myoption = optionDefinitions;

        OptionAnswersPK optionAnswersPK = new OptionAnswersPK(shapeOptionEntity.getOptionAnswersId(), shapeOptionEntity.getOptionId());
        OptionAnswers optionAnswers = new OptionAnswers();
        optionAnswers.setId(optionAnswersPK);
        optionAnswers.setDescription(shapeOptionEntity.getOptionAnswersDesc());
        optionAnswers.setAbbreviation(shapeOptionEntity.getOptionAnswersAbbrev());
        optionAnswers.setStockcode(shapeOptionEntity.getOptionAnswersStockCode());

        shapeOption.myanswer = optionAnswers;

        return shapeOption;
    }

    /**
     * Return a DesignOption model object from ShapeOptionEntity to use into JobItem model design
     *
     * @param itemFrame,         ItemFrame Main Object
     * @param shapeOptionEntity, ShapeOptionEntityObject
     * @return DesignOption
     * @throws DTOTransformationError, Error
     */
    public static DesignOption getDesignOptionModel(ItemFrame itemFrame, ShapeOptionEntityObject shapeOptionEntity)
            throws DTOTransformationError {

        if (shapeOptionEntity == null) {
            throw new DTOTransformationError();
        }

        DesignOption designOption = new DesignOption();

        designOption.a_1Level = shapeOptionEntity.getConstructionMap().get_a_1Level();
        designOption.a_2Level = shapeOptionEntity.getConstructionMap().get_a_2Level();
        designOption.a_3Level = shapeOptionEntity.getConstructionMap().get_a_3Level();
        designOption.a_4Level = shapeOptionEntity.getConstructionMap().get_a_4Level();
        designOption.a_5Level = shapeOptionEntity.getConstructionMap().get_a_5Level();
        designOption.a_6Level = shapeOptionEntity.getConstructionMap().get_a_6Level();
        designOption.a_7Level = shapeOptionEntity.getConstructionMap().get_a_7Level();
        designOption.a_8Level = shapeOptionEntity.getConstructionMap().get_a_8Level();
        designOption.a_9Level = shapeOptionEntity.getConstructionMap().get_a_9Level();
        designOption.a_10Level = shapeOptionEntity.getConstructionMap().get_a_10Level();
        designOption.a_11Level = shapeOptionEntity.getConstructionMap().get_a_11Level();
        designOption.a_12Level = shapeOptionEntity.getConstructionMap().get_a_12Level();
        designOption.a_13Level = shapeOptionEntity.getConstructionMap().get_a_13Level();
        designOption.a_14Level = shapeOptionEntity.getConstructionMap().get_a_14Level();
        designOption.a_15Level = shapeOptionEntity.getConstructionMap().get_a_15Level();
        designOption.a_16Level = shapeOptionEntity.getConstructionMap().get_a_16Level();
        designOption.a_17Level = shapeOptionEntity.getConstructionMap().get_a_17Level();
        designOption.a_18Level = shapeOptionEntity.getConstructionMap().get_a_18Level();
        designOption.a_19Level = shapeOptionEntity.getConstructionMap().get_a_19Level();
        designOption.a_20Level = shapeOptionEntity.getConstructionMap().get_a_20Level();
        designOption.a_21Level = shapeOptionEntity.getConstructionMap().get_a_21Level();
        designOption.a_22Level = shapeOptionEntity.getConstructionMap().get_a_22Level();
        designOption.a_1Sequence = shapeOptionEntity.getConstructionMap().get_a_1Sequence();
        designOption.a_2Sequence = shapeOptionEntity.getConstructionMap().get_a_2Sequence();
        designOption.a_3Sequence = shapeOptionEntity.getConstructionMap().get_a_3Sequence();
        designOption.a_4Sequence = shapeOptionEntity.getConstructionMap().get_a_4Sequence();
        designOption.a_5Sequence = shapeOptionEntity.getConstructionMap().get_a_5Sequence();
        designOption.a_6Sequence = shapeOptionEntity.getConstructionMap().get_a_6Sequence();
        designOption.a_7Sequence = shapeOptionEntity.getConstructionMap().get_a_7Sequence();
        designOption.a_8Sequence = shapeOptionEntity.getConstructionMap().get_a_8Sequence();
        designOption.a_9Sequence = shapeOptionEntity.getConstructionMap().get_a_9Sequence();
        designOption.a_10Sequence = shapeOptionEntity.getConstructionMap().get_a_10Sequence();
        designOption.a_11Sequence = shapeOptionEntity.getConstructionMap().get_a_11Sequence();
        designOption.a_12Sequence = shapeOptionEntity.getConstructionMap().get_a_12Sequence();
        designOption.a_13Sequence = shapeOptionEntity.getConstructionMap().get_a_13Sequence();
        designOption.a_14Sequence = shapeOptionEntity.getConstructionMap().get_a_14Sequence();
        designOption.a_15Sequence = shapeOptionEntity.getConstructionMap().get_a_15Sequence();
        designOption.a_16Sequence = shapeOptionEntity.getConstructionMap().get_a_16Sequence();
        designOption.a_17Sequence = shapeOptionEntity.getConstructionMap().get_a_17Sequence();
        designOption.a_18Sequence = shapeOptionEntity.getConstructionMap().get_a_18Sequence();
        designOption.a_19Sequence = shapeOptionEntity.getConstructionMap().get_a_19Sequence();
        designOption.a_20Sequence = shapeOptionEntity.getConstructionMap().get_a_20Sequence();
        designOption.a_21Sequence = shapeOptionEntity.getConstructionMap().get_a_21Sequence();
        designOption.a_22Sequence = shapeOptionEntity.getConstructionMap().get_a_22Sequence();

        designOption.optionid = shapeOptionEntity.getOptionId();
        designOption.answerid = shapeOptionEntity.getAnswerId();
        designOption.qtyanswer = shapeOptionEntity.getQtyAnswer();
        designOption.sizeanswer = shapeOptionEntity.getSizeAnswer();
        designOption.sizeansweri = shapeOptionEntity.getSizeAnswerI();
        designOption.depthanswer = shapeOptionEntity.getDepthAnswer();
        designOption.depthansweri = shapeOptionEntity.getDepthAnswerI();
        designOption.adjust = shapeOptionEntity.getAdjust();
        designOption.adjusti = shapeOptionEntity.getAdjustI();
        designOption.textAnswer = shapeOptionEntity.getTextAnswer();
//        designOption.rgb_R = shapeOptionEntity.rgb_R;
//        designOption.rgb_G = shapeOptionEntity.rgb_G;
//        designOption.rgb_B = shapeOptionEntity.rgb_B;
        designOption.price = shapeOptionEntity.getPrice();
        designOption.discountP = shapeOptionEntity.getDiscountP();
        designOption.priceUser = shapeOptionEntity.getPrice();
        designOption.cost = shapeOptionEntity.getCost();
        designOption.w = shapeOptionEntity.getW();
        designOption.h = shapeOptionEntity.getH();
        designOption.wi = shapeOptionEntity.getWi();
        designOption.hi = shapeOptionEntity.getHi();
        designOption.d = shapeOptionEntity.getD();
        designOption.di = shapeOptionEntity.getDi();
        designOption.l = shapeOptionEntity.getL();
        designOption.li = shapeOptionEntity.getLi();
        designOption.priceuom = shapeOptionEntity.getPriceUOMId();
        designOption.costuom = shapeOptionEntity.getCostUOMId();
        designOption.pricemeasure = shapeOptionEntity.getPriceMeasureId();
        designOption.priceTotal = shapeOptionEntity.getPriceTotal();
        designOption.priceTotalUser = shapeOptionEntity.getPriceTotalUser();
        designOption.costTotal = shapeOptionEntity.getCostTotal();
        designOption.seriesid = shapeOptionEntity.getSeriesId();
        designOption.ruleno = shapeOptionEntity.getRuleno();
        designOption.isAuto = shapeOptionEntity.isAuto();
        designOption.remove = shapeOptionEntity.isRemove();
        designOption.global = shapeOptionEntity.isGlobal();
        designOption.seriesid = shapeOptionEntity.getSeriesId();

        if (!itemFrame.isSupplier) {
            designOption.supplierID = shapeOptionEntity.getSupplierId();
            designOption.supplierSeriesID = shapeOptionEntity.getSupplierSeriesId();
            designOption.remote = shapeOptionEntity.isRemote();
        }

        //Init Option Definitions
        if (designOption.remote) {
            designOption.myoption = ItemFrame.getApplicationRemoteBaseRules().getOptionDefinitions(shapeOptionEntity.getSupplierId(),
                    shapeOptionEntity.getOptionId());
        } else {
            designOption.myoption = ItemFrame.getApplicationBaseRules().getOptionDefinitions(shapeOptionEntity.getOptionId());
        }

        //Init Option Answers
        if (designOption.remote) {
            designOption.myanswer = ItemFrame.getApplicationRemoteBaseRules().getOptionAnswers(shapeOptionEntity.getSupplierId(),
                    shapeOptionEntity.getOptionId(), shapeOptionEntity.getOptionAnswersId());
        } else {
            designOption.myanswer = ItemFrame.getApplicationBaseRules().getOptionAnswers(shapeOptionEntity.getOptionId(),
                    shapeOptionEntity.getOptionAnswersId());
        }

        //Init Design Option Answers Allowed
        if (designOption.remote) {
            designOption.optionsAllowedAnswers.addAll(ItemFrame.getApplicationRemoteBaseRules().getOptionAnswers(
                    shapeOptionEntity.getSupplierId(), shapeOptionEntity.getOptionId()));
        } else {
            designOption.optionsAllowedAnswers.addAll(ItemFrame.getApplicationBaseRules().getOptionAnswers(
                    shapeOptionEntity.getOptionId()));
        }

        return designOption;
    }

    /**
     * Return Design Option Entity Object from ShapeOptionEntity
     *
     * @param shapeOptionEntity, ShapeOptionEntityObject
     * @return DesignOptionEntityObject
     * @throws DTOTransformationError, Error
     */
    public static DesignOptionEntityObject getDesignOptionEntityObject(ShapeOptionEntityObject shapeOptionEntity) throws DTOTransformationError {

        if (shapeOptionEntity == null) {
            throw new DTOTransformationError();
        }

        DesignOptionEntityObject designOptionEntity = new DesignOptionEntityObject();
        designOptionEntity.setId(shapeOptionEntity.getId());
        designOptionEntity.setLevelId(shapeOptionEntity.getLevelId());
        designOptionEntity.setSequenceId(shapeOptionEntity.getSequenceId());
        designOptionEntity.setAssemblyLevelId(shapeOptionEntity.getAssemblyLevelId());
        designOptionEntity.setSeriesId(shapeOptionEntity.getSeriesId());
        designOptionEntity.setSeq(shapeOptionEntity.getSequenceId());
        designOptionEntity.setRuleno(shapeOptionEntity.getRuleno());
        designOptionEntity.setOptionId(shapeOptionEntity.getOptionId());
        designOptionEntity.setAnswerId(shapeOptionEntity.getAnswerId());
        designOptionEntity.setSizeAnswer(shapeOptionEntity.getSizeAnswer());
        designOptionEntity.setSizeAnswerI(shapeOptionEntity.getSizeAnswerI());
        designOptionEntity.setDepthAnswer(shapeOptionEntity.getDepthAnswer());
        designOptionEntity.setDepthAnswerI(shapeOptionEntity.getDepthAnswerI());
        designOptionEntity.setAdjust(shapeOptionEntity.getAdjust());
        designOptionEntity.setAdjustI(shapeOptionEntity.getAdjustI());
        designOptionEntity.setTextAnswer(shapeOptionEntity.getTextAnswer());
        designOptionEntity.setW(shapeOptionEntity.getW());
        designOptionEntity.setH(shapeOptionEntity.getH());
        designOptionEntity.setWi(shapeOptionEntity.getWi());
        designOptionEntity.setHi(shapeOptionEntity.getHi());
        designOptionEntity.setD(shapeOptionEntity.getD());
        designOptionEntity.setDi(shapeOptionEntity.getDi());
        designOptionEntity.setL(shapeOptionEntity.getL());
        designOptionEntity.setLi(shapeOptionEntity.getLi());
        designOptionEntity.setPriceUOM(shapeOptionEntity.getPriceUOMId());
        designOptionEntity.setCostUOM(shapeOptionEntity.getCostUOMId());
        designOptionEntity.setPriceMeasure(shapeOptionEntity.getPriceMeasureId());
        designOptionEntity.setRgb_R(0);
        designOptionEntity.setRgb_G(0);
        designOptionEntity.setRgb_B(0);
        designOptionEntity.setQtyAnswer(shapeOptionEntity.getQtyAnswer());
        designOptionEntity.setDiscountP(shapeOptionEntity.getDiscountP());
        designOptionEntity.setPriceTotal(shapeOptionEntity.getPriceTotal());
        designOptionEntity.setPriceTotalUser(shapeOptionEntity.getPriceTotalUser());
        designOptionEntity.setCostTotal(shapeOptionEntity.getCostTotal());
        designOptionEntity.setPriceUser(shapeOptionEntity.getPriceUser());
        designOptionEntity.setCost(shapeOptionEntity.getCost());
        designOptionEntity.setPrice(shapeOptionEntity.getPrice());
        designOptionEntity.setMixed(false);
        designOptionEntity.setAuto(shapeOptionEntity.isAuto());
        designOptionEntity.setRemove(shapeOptionEntity.isRemove());
        designOptionEntity.setGlobal(shapeOptionEntity.isGlobal());
        designOptionEntity.setOptionDefinitionsId(shapeOptionEntity.getOptionDefinitionsId());
        designOptionEntity.setOptionDefinitionsTypeId(shapeOptionEntity.getOptionDefinitionsTypeId());
        designOptionEntity.setOptionAnswersId(shapeOptionEntity.getOptionAnswersId());
        designOptionEntity.setDesignNet(false);
        designOptionEntity.setDesignAll(false);

        designOptionEntity.setSupplierId(shapeOptionEntity.getSupplierId());
        designOptionEntity.setSupplierSeriesId(shapeOptionEntity.getSupplierSeriesId());
        designOptionEntity.setRemote(shapeOptionEntity.isRemote());

        designOptionEntity.setConstructionMap(shapeOptionEntity.getConstructionMap());

        return designOptionEntity;
    }

}

package dto;

import Model.DesignOption;
import Presentation.ItemFrame;
import openjanela.model.entities.design.ConstructionMap;
import openjanela.model.entities.design.DesignOptionEntityObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 12-23-12
 * Time: 10:36 PM
 */
public class DesignOptionDTO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(DesignOptionDTO.class);

    /**
     * Return design option entity object
     *
     * @param designOption, DesignOption
     * @param netOption,    Net option collection
     * @param allOption,    All option collection
     * @return DesignOptionEntityObject
     * @throws DTOTransformationError, Error
     */
    public static DesignOptionEntityObject getDesignOptionEntity(DesignOption designOption, boolean netOption, boolean allOption)
            throws DTOTransformationError {

        if (designOption == null) {
            throw new DTOTransformationError();
        }

        //**************************************************************************
        //Creating and applying transformation
        //**************************************************************************
        DesignOptionEntityObject designOptionEntity = new DesignOptionEntityObject();

        ConstructionMap constructionMap = new ConstructionMap();
        constructionMap.set_a_1Level(designOption.a_1Level);
        constructionMap.set_a_2Level(designOption.a_2Level);
        constructionMap.set_a_3Level(designOption.a_3Level);
        constructionMap.set_a_4Level(designOption.a_4Level);
        constructionMap.set_a_5Level(designOption.a_5Level);
        constructionMap.set_a_6Level(designOption.a_6Level);
        constructionMap.set_a_7Level(designOption.a_7Level);
        constructionMap.set_a_8Level(designOption.a_8Level);
        constructionMap.set_a_9Level(designOption.a_9Level);
        constructionMap.set_a_10Level(designOption.a_10Level);
        constructionMap.set_a_11Level(designOption.a_11Level);
        constructionMap.set_a_12Level(designOption.a_12Level);
        constructionMap.set_a_13Level(designOption.a_13Level);
        constructionMap.set_a_14Level(designOption.a_14Level);
        constructionMap.set_a_15Level(designOption.a_15Level);
        constructionMap.set_a_16Level(designOption.a_16Level);
        constructionMap.set_a_17Level(designOption.a_17Level);
        constructionMap.set_a_18Level(designOption.a_18Level);
        constructionMap.set_a_19Level(designOption.a_19Level);
        constructionMap.set_a_20Level(designOption.a_20Level);
        constructionMap.set_a_21Level(designOption.a_21Level);
        constructionMap.set_a_22Level(designOption.a_22Level);
        constructionMap.set_a_1Sequence(designOption.a_1Sequence);
        constructionMap.set_a_2Sequence(designOption.a_2Sequence);
        constructionMap.set_a_3Sequence(designOption.a_3Sequence);
        constructionMap.set_a_4Sequence(designOption.a_4Sequence);
        constructionMap.set_a_5Sequence(designOption.a_5Sequence);
        constructionMap.set_a_6Sequence(designOption.a_6Sequence);
        constructionMap.set_a_7Sequence(designOption.a_7Sequence);
        constructionMap.set_a_8Sequence(designOption.a_8Sequence);
        constructionMap.set_a_9Sequence(designOption.a_9Sequence);
        constructionMap.set_a_10Sequence(designOption.a_10Sequence);
        constructionMap.set_a_11Sequence(designOption.a_11Sequence);
        constructionMap.set_a_12Sequence(designOption.a_12Sequence);
        constructionMap.set_a_13Sequence(designOption.a_13Sequence);
        constructionMap.set_a_14Sequence(designOption.a_14Sequence);
        constructionMap.set_a_15Sequence(designOption.a_15Sequence);
        constructionMap.set_a_16Sequence(designOption.a_16Sequence);
        constructionMap.set_a_17Sequence(designOption.a_17Sequence);
        constructionMap.set_a_18Sequence(designOption.a_18Sequence);
        constructionMap.set_a_19Sequence(designOption.a_19Sequence);
        constructionMap.set_a_20Sequence(designOption.a_20Sequence);
        constructionMap.set_a_21Sequence(designOption.a_21Sequence);
        constructionMap.set_a_22Sequence(designOption.a_22Sequence);

        //Setting construction map
        designOptionEntity.setConstructionMap(constructionMap);

        designOptionEntity.setLevelId(designOption.a_levelID);
        designOptionEntity.setSequenceId(designOption.a_sequenceID);
        designOptionEntity.setAssemblyLevelId(designOption.a_assemblyLevel);
        designOptionEntity.setSeq(designOption.seq);
        designOptionEntity.setRuleno(designOption.ruleno);
        designOptionEntity.setOptionId(designOption.optionid);
        designOptionEntity.setAnswerId(designOption.answerid);
        designOptionEntity.setMixed(designOption.isMixed);
        designOptionEntity.setAuto(designOption.isAuto);
        designOptionEntity.setQtyAnswer(designOption.qtyanswer);
        designOptionEntity.setSizeAnswer(designOption.sizeanswer);
        designOptionEntity.setSizeAnswerI(designOption.sizeansweri);
        designOptionEntity.setDepthAnswer(designOption.depthanswer);
        designOptionEntity.setDepthAnswerI(designOption.depthansweri);
        designOptionEntity.setAdjust(designOption.adjust);
        designOptionEntity.setAdjustI(designOption.adjusti);
        designOptionEntity.setTextAnswer(designOption.textAnswer);
        designOptionEntity.setRgb_R(designOption.rgb_R);
        designOptionEntity.setRgb_G(designOption.rgb_G);
        designOptionEntity.setRgb_B(designOption.rgb_B);
        designOptionEntity.setPrice(designOption.price);
        designOptionEntity.setDiscountP(designOption.discountP);
        designOptionEntity.setPriceUser(designOption.priceUser);
        designOptionEntity.setCost(designOption.cost);
        designOptionEntity.setW(designOption.w);
        designOptionEntity.setH(designOption.h);
        designOptionEntity.setWi(designOption.wi);
        designOptionEntity.setHi(designOption.hi);
        designOptionEntity.setD(designOption.d);
        designOptionEntity.setDi(designOption.di);
        designOptionEntity.setL(designOption.l);
        designOptionEntity.setLi(designOption.li);
        designOptionEntity.setPriceUOM(designOption.priceuom);
        designOptionEntity.setCostUOM(designOption.costuom);
        designOptionEntity.setPriceMeasure(designOption.pricemeasure);
        designOptionEntity.setPriceTotal(designOption.priceTotal);
        designOptionEntity.setPriceTotalUser(designOption.priceTotalUser);
        designOptionEntity.setCostTotal(designOption.costTotal);
        designOptionEntity.setSeriesId(designOption.seriesid);
        designOptionEntity.setRemove(designOption.remove);
        designOptionEntity.setGlobal(designOption.global);
        designOptionEntity.setOptionDefinitionsId(designOption.myoption.getId());
        designOptionEntity.setOptionDefinitionsDesc(designOption.myoption.getOptions());

        designOptionEntity.setOptionDefinitionsTypeId(designOption.myoption.getOptiontypeid());
        designOptionEntity.setOptionAnswersId(designOption.myanswer.getId().getId());
        designOptionEntity.setOptionAnswersDesc(designOption.myanswer.getDescription());

        designOptionEntity.setSupplierId(designOption.supplierID);
        designOptionEntity.setSupplierSeriesId(designOption.supplierSeriesID);
        designOptionEntity.setRemote(designOption.remote);

        designOptionEntity.setDesignNet(netOption);
        designOptionEntity.setDesignAll(allOption);

        return designOptionEntity;
    }

    /**
     * Return a design option model from his EAO model
     *
     * @param designOptionEntity, DesignOptionEntityObject model design
     * @return DesignOption, DesignOption model application
     * @throws DTOTransformationError, Error
     */
    public static DesignOption getDesignOptionModel(DesignOptionEntityObject designOptionEntity) throws DTOTransformationError {

        if (designOptionEntity == null) {
            throw new DTOTransformationError();
        }

        DesignOption designOption = new DesignOption();

        designOption.a_1Level = designOptionEntity.getConstructionMap().get_a_1Level();
        designOption.a_2Level = designOptionEntity.getConstructionMap().get_a_2Level();
        designOption.a_3Level = designOptionEntity.getConstructionMap().get_a_3Level();
        designOption.a_4Level = designOptionEntity.getConstructionMap().get_a_4Level();
        designOption.a_5Level = designOptionEntity.getConstructionMap().get_a_5Level();
        designOption.a_6Level = designOptionEntity.getConstructionMap().get_a_6Level();
        designOption.a_7Level = designOptionEntity.getConstructionMap().get_a_7Level();
        designOption.a_8Level = designOptionEntity.getConstructionMap().get_a_8Level();
        designOption.a_9Level = designOptionEntity.getConstructionMap().get_a_9Level();
        designOption.a_10Level = designOptionEntity.getConstructionMap().get_a_10Level();
        designOption.a_11Level = designOptionEntity.getConstructionMap().get_a_11Level();
        designOption.a_12Level = designOptionEntity.getConstructionMap().get_a_12Level();
        designOption.a_13Level = designOptionEntity.getConstructionMap().get_a_13Level();
        designOption.a_14Level = designOptionEntity.getConstructionMap().get_a_14Level();
        designOption.a_15Level = designOptionEntity.getConstructionMap().get_a_15Level();
        designOption.a_16Level = designOptionEntity.getConstructionMap().get_a_16Level();
        designOption.a_17Level = designOptionEntity.getConstructionMap().get_a_17Level();
        designOption.a_18Level = designOptionEntity.getConstructionMap().get_a_18Level();
        designOption.a_19Level = designOptionEntity.getConstructionMap().get_a_19Level();
        designOption.a_20Level = designOptionEntity.getConstructionMap().get_a_20Level();
        designOption.a_21Level = designOptionEntity.getConstructionMap().get_a_21Level();
        designOption.a_22Level = designOptionEntity.getConstructionMap().get_a_22Level();
        designOption.a_1Sequence = designOptionEntity.getConstructionMap().get_a_1Sequence();
        designOption.a_2Sequence = designOptionEntity.getConstructionMap().get_a_2Sequence();
        designOption.a_3Sequence = designOptionEntity.getConstructionMap().get_a_3Sequence();
        designOption.a_4Sequence = designOptionEntity.getConstructionMap().get_a_4Sequence();
        designOption.a_5Sequence = designOptionEntity.getConstructionMap().get_a_5Sequence();
        designOption.a_6Sequence = designOptionEntity.getConstructionMap().get_a_6Sequence();
        designOption.a_7Sequence = designOptionEntity.getConstructionMap().get_a_7Sequence();
        designOption.a_8Sequence = designOptionEntity.getConstructionMap().get_a_8Sequence();
        designOption.a_9Sequence = designOptionEntity.getConstructionMap().get_a_9Sequence();
        designOption.a_10Sequence = designOptionEntity.getConstructionMap().get_a_10Sequence();
        designOption.a_11Sequence = designOptionEntity.getConstructionMap().get_a_11Sequence();
        designOption.a_12Sequence = designOptionEntity.getConstructionMap().get_a_12Sequence();
        designOption.a_13Sequence = designOptionEntity.getConstructionMap().get_a_13Sequence();
        designOption.a_14Sequence = designOptionEntity.getConstructionMap().get_a_14Sequence();
        designOption.a_15Sequence = designOptionEntity.getConstructionMap().get_a_15Sequence();
        designOption.a_16Sequence = designOptionEntity.getConstructionMap().get_a_16Sequence();
        designOption.a_17Sequence = designOptionEntity.getConstructionMap().get_a_17Sequence();
        designOption.a_18Sequence = designOptionEntity.getConstructionMap().get_a_18Sequence();
        designOption.a_19Sequence = designOptionEntity.getConstructionMap().get_a_19Sequence();
        designOption.a_20Sequence = designOptionEntity.getConstructionMap().get_a_20Sequence();
        designOption.a_21Sequence = designOptionEntity.getConstructionMap().get_a_21Sequence();
        designOption.a_22Sequence = designOptionEntity.getConstructionMap().get_a_22Sequence();

        designOption.a_levelID = designOptionEntity.getLevelId();
        designOption.a_sequenceID = designOptionEntity.getSequenceId();
        designOption.a_assemblyLevel = designOptionEntity.getConstructionMap().get_a_assemblyLevel();
        designOption.seq = designOptionEntity.getSeq();
        designOption.ruleno = designOptionEntity.getRuleno();
        designOption.optionid = designOptionEntity.getOptionId();
        designOption.answerid = designOptionEntity.getAnswerId();
        designOption.isMixed = designOptionEntity.isMixed();
        designOption.isAuto = designOptionEntity.isAuto();
        designOption.qtyanswer = designOptionEntity.getQtyAnswer();
        designOption.sizeanswer = designOptionEntity.getSizeAnswer();
        designOption.sizeansweri = designOptionEntity.getSizeAnswerI();
        designOption.depthanswer = designOptionEntity.getDepthAnswer();
        designOption.depthansweri = designOptionEntity.getDepthAnswerI();
        designOption.adjust = designOptionEntity.getAdjust();
        designOption.adjusti = designOptionEntity.getAdjustI();
        designOption.textAnswer = designOptionEntity.getTextAnswer();
        designOption.rgb_R = designOptionEntity.getRgb_R();
        designOption.rgb_G = designOptionEntity.getRgb_G();
        designOption.rgb_B = designOptionEntity.getRgb_B();
        designOption.price = designOptionEntity.getPrice();
        designOption.discountP = designOptionEntity.getDiscountP();
        designOption.priceUser = designOptionEntity.getPriceUser();
        designOption.cost = designOptionEntity.getCost();
        designOption.w = designOptionEntity.getW();
        designOption.h = designOptionEntity.getH();
        designOption.wi = designOptionEntity.getWi();
        designOption.hi = designOptionEntity.getHi();
        designOption.d = designOptionEntity.getD();
        designOption.di = designOptionEntity.getDi();
        designOption.l = designOptionEntity.getL();
        designOption.li = designOptionEntity.getLi();
        designOption.priceuom = designOptionEntity.getPriceUOM();
        designOption.costuom = designOptionEntity.getCostUOM();
        designOption.pricemeasure = designOptionEntity.getPriceMeasure();
        designOption.priceTotal = designOptionEntity.getPriceTotal();
        designOption.priceTotalUser = designOptionEntity.getPriceTotalUser();
        designOption.costTotal = designOptionEntity.getCostTotal();
        designOption.seriesid = designOptionEntity.getSeriesId();
        designOption.remove = designOptionEntity.isRemove();
        designOption.global = designOptionEntity.isGlobal();

        designOption.supplierID = designOptionEntity.getSupplierId();
        designOption.supplierSeriesID = designOptionEntity.getSupplierSeriesId();
        designOption.remote = designOptionEntity.isRemote();

        //Init Option Definitions
        if (designOption.remote) {
            designOption.myoption = ItemFrame.getApplicationRemoteBaseRules().getOptionDefinitions(
                    designOptionEntity.getSupplierId(), designOptionEntity.getOptionDefinitionsId());
        } else {
            designOption.myoption = ItemFrame.getApplicationBaseRules().getOptionDefinitions(designOptionEntity.getOptionDefinitionsId());
        }

        //Init Option Answers
        if (designOption.remote) {
            designOption.myanswer = ItemFrame.getApplicationRemoteBaseRules().getOptionAnswers(
                    designOptionEntity.getSupplierId(), designOptionEntity.getOptionDefinitionsId(),
                    designOptionEntity.getOptionAnswersId());
        } else {
            designOption.myanswer = ItemFrame.getApplicationBaseRules().getOptionAnswers(designOptionEntity.getOptionDefinitionsId(),
                    designOptionEntity.getOptionAnswersId());
        }

        //Init Design Option Answers Allowed
        if (designOption.remote) {
            designOption.optionsAllowedAnswers.addAll(ItemFrame.getApplicationRemoteBaseRules().getOptionAnswers(
                    designOptionEntity.getSupplierId(), designOptionEntity.getOptionDefinitionsId()));
        } else {
            designOption.optionsAllowedAnswers.addAll(ItemFrame.getApplicationBaseRules().getOptionAnswers(
                    designOptionEntity.getOptionDefinitionsId()));
        }

        return designOption;
    }

    /**
     * This method creates clone of DesignOptionEntity implementation method
     *
     * @param designOptionEntity, DesignOptionEntityObject
     * @return DesignOptionEntityObject
     * @throws DTOTransformationError, Error
     */
    public static DesignOptionEntityObject cloneDesignOptionObject(DesignOptionEntityObject designOptionEntity)
            throws DTOTransformationError {

        try {

            if (designOptionEntity == null) {
                throw new DTOTransformationError();
            }

            DesignOptionEntityObject designOption = (DesignOptionEntityObject) BeanUtils.cloneBean(designOptionEntity);
            designOption.setId(null);

            ConstructionMap constructionMap = (ConstructionMap) BeanUtils.cloneBean(designOptionEntity.getConstructionMap());
            constructionMap.setId(null);
            designOption.setConstructionMap(constructionMap);


            return designOption;

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

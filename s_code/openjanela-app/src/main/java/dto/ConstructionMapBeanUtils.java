package dto;

import openjanela.model.entities.design.ConstructionMap;
import org.apache.log4j.Logger;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 01-09-13
 * Time: 10:20 PM
 */
public class ConstructionMapBeanUtils {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ConstructionMapBeanUtils.class);

    /**
     * This method clone ConstructionMap to a new instance
     *
     * @param bean, ConstructionMap
     * @return ConstructionMap
     * @throws DTOTransformationError, Error
     */
    public static ConstructionMap cloneBean(ConstructionMap bean) throws DTOTransformationError {

        ConstructionMap constructionMap = new ConstructionMap();
        constructionMap.set_a_assemblyLevel(bean.get_a_assemblyLevel());
        constructionMap.set_a_1Level(bean.get_a_1Level());
        constructionMap.set_a_2Level(bean.get_a_2Level());
        constructionMap.set_a_3Level(bean.get_a_3Level());
        constructionMap.set_a_4Level(bean.get_a_4Level());
        constructionMap.set_a_5Level(bean.get_a_5Level());
        constructionMap.set_a_6Level(bean.get_a_6Level());
        constructionMap.set_a_7Level(bean.get_a_7Level());
        constructionMap.set_a_8Level(bean.get_a_8Level());
        constructionMap.set_a_9Level(bean.get_a_9Level());
        constructionMap.set_a_10Level(bean.get_a_10Level());
        constructionMap.set_a_11Level(bean.get_a_11Level());
        constructionMap.set_a_12Level(bean.get_a_12Level());
        constructionMap.set_a_13Level(bean.get_a_13Level());
        constructionMap.set_a_14Level(bean.get_a_14Level());
        constructionMap.set_a_15Level(bean.get_a_15Level());
        constructionMap.set_a_16Level(bean.get_a_16Level());
        constructionMap.set_a_17Level(bean.get_a_17Level());
        constructionMap.set_a_18Level(bean.get_a_18Level());
        constructionMap.set_a_19Level(bean.get_a_19Level());
        constructionMap.set_a_20Level(bean.get_a_20Level());
        constructionMap.set_a_21Level(bean.get_a_21Level());
        constructionMap.set_a_22Level(bean.get_a_22Level());
        constructionMap.set_a_1Sequence(bean.get_a_1Sequence());
        constructionMap.set_a_2Sequence(bean.get_a_2Sequence());
        constructionMap.set_a_3Sequence(bean.get_a_3Sequence());
        constructionMap.set_a_4Sequence(bean.get_a_4Sequence());
        constructionMap.set_a_5Sequence(bean.get_a_5Sequence());
        constructionMap.set_a_6Sequence(bean.get_a_6Sequence());
        constructionMap.set_a_7Sequence(bean.get_a_7Sequence());
        constructionMap.set_a_8Sequence(bean.get_a_8Sequence());
        constructionMap.set_a_9Sequence(bean.get_a_9Sequence());
        constructionMap.set_a_10Sequence(bean.get_a_10Sequence());
        constructionMap.set_a_11Sequence(bean.get_a_11Sequence());
        constructionMap.set_a_12Sequence(bean.get_a_12Sequence());
        constructionMap.set_a_13Sequence(bean.get_a_13Sequence());
        constructionMap.set_a_14Sequence(bean.get_a_14Sequence());
        constructionMap.set_a_15Sequence(bean.get_a_15Sequence());
        constructionMap.set_a_16Sequence(bean.get_a_16Sequence());
        constructionMap.set_a_17Sequence(bean.get_a_17Sequence());
        constructionMap.set_a_18Sequence(bean.get_a_18Sequence());
        constructionMap.set_a_19Sequence(bean.get_a_19Sequence());
        constructionMap.set_a_20Sequence(bean.get_a_20Sequence());
        constructionMap.set_a_21Sequence(bean.get_a_21Sequence());
        constructionMap.set_a_22Sequence(bean.get_a_22Sequence());

        return constructionMap;
    }
}

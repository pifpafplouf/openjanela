package dto;

import openjanela.model.entities.design.ConstructionMap;
import openjanela.model.entities.design.ShapeOptionEntityObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 01-10-13
 * Time: 12:21 AM
 */
public class ShapeOptionBeanUtils {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ProfilesBeanUtils.class);

    /**
     * This method clone ProfileAbstractObject to a new instance
     *
     * @param bean, ShapeOptionEntityObject
     * @return ShapeOptionEntityObject
     * @throws DTOTransformationError, Error
     */
    public static ShapeOptionEntityObject cloneBean(ShapeOptionEntityObject bean) throws DTOTransformationError {

        try {

            if (bean == null) {
                throw new DTOTransformationError();
            }

            ShapeOptionEntityObject shapeOption = new ShapeOptionEntityObject();
            BeanUtils.copyProperties(shapeOption, bean);
            shapeOption.setId(null);
            shapeOption.setConstructionMap(null);

            //Clone Construction Map
            ConstructionMap constructionMap = new ConstructionMap();
            BeanUtils.copyProperties(constructionMap, bean.getConstructionMap());
            constructionMap.setId(null);
            shapeOption.setConstructionMap(constructionMap);

            return shapeOption;

        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }
    }
}

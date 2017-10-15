package dto;

import openjanela.model.entities.design.ConstructionMap;
import openjanela.model.entities.design.DesignOptionEntityObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 01-10-13
 * Time: 09:57 AM
 */
public class DesignOptionBeanUtils {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ConstructionMapBeanUtils.class);

    /**
     * This method clone DesignOptionEntityObject to a new instance
     *
     * @param bean, DesignOptionEntityObject
     * @return DesignOptionEntityObject
     * @throws DTOTransformationError, Error
     */
    public static DesignOptionEntityObject cloneBean(DesignOptionEntityObject bean) throws DTOTransformationError {

        try {

            if (bean == null) {
                throw new DTOTransformationError();
            }

            DesignOptionEntityObject designOption = new DesignOptionEntityObject();
            BeanUtils.copyProperties(designOption, bean);
            designOption.setId(null);
            designOption.setConstructionMap(null);

            //Clone ConstructionMap
            ConstructionMap constructionMap = new ConstructionMap();
            BeanUtils.copyProperties(constructionMap, bean.getConstructionMap());
            constructionMap.setId(null);
            designOption.setConstructionMap(constructionMap);

            return designOption;

        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }
    }
}

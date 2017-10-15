package dto;

import openjanela.model.entities.design.ConstructionMap;
import openjanela.model.entities.design.DesignGlassEntityObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 01-10-13
 * Time: 10:58 AM
 */
public class DesignGlassBeanUtils {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(DesignGlassBeanUtils.class);

    /**
     * This method clone DesignGlassEntityObject to a new instance
     *
     * @param bean, DesignGlassEntityObject
     * @return DesignGlassEntityObject
     * @throws DTOTransformationError, Error
     */
    public static DesignGlassEntityObject cloneBean(DesignGlassEntityObject bean) throws DTOTransformationError {

        try {

            if (bean == null) {
                throw new DTOTransformationError();
            }

            DesignGlassEntityObject designGlass = new DesignGlassEntityObject();
            BeanUtils.copyProperties(designGlass, bean);
            designGlass.setId(null);
            designGlass.setConstructionMap(null);

            //Clone construction map
            ConstructionMap constructionMap = new ConstructionMap();
            BeanUtils.copyProperties(constructionMap, bean.getConstructionMap());
            constructionMap.setId(null);
            designGlass.setConstructionMap(constructionMap);

            return designGlass;

        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }
    }
}

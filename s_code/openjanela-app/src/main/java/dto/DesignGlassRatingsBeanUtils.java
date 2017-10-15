package dto;

import openjanela.model.entities.design.DesignGlassRatingsEntityObject;
import openjanela.model.entities.design.DesignRatingsLabel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-16-13
 *          Time: 09:13 AM
 */
public class DesignGlassRatingsBeanUtils {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(DesignGlassRatingsBeanUtils.class);

    /**
     * This method clone DesignGlassRatingsEntityObject to a new instance
     *
     * @param bean, DesignGlassRatingsEntityObject
     * @return DesignGlassRatingsEntityObject
     * @throws DTOTransformationError, Error
     */
    public static DesignGlassRatingsEntityObject cloneBean(DesignGlassRatingsEntityObject bean) throws DTOTransformationError {

        try {

            if (bean == null) {
                throw new DTOTransformationError();
            }

            DesignGlassRatingsEntityObject glassLabel = new DesignGlassRatingsEntityObject();
            BeanUtils.copyProperties(glassLabel, bean);
            glassLabel.setId(null);

            //********************************************************************************
            //Clone Design Glass Label
            //********************************************************************************
            List<DesignRatingsLabel> designRatingsLabel = new ArrayList<DesignRatingsLabel>();
            for (DesignRatingsLabel ratingLabel : glassLabel.getDesignRatings()) {
                DesignRatingsLabel newObject = ratingLabel.clone();
                newObject.setId(null);

                designRatingsLabel.add(newObject);
            }
            glassLabel.setDesignRatings(designRatingsLabel);

            return glassLabel;

        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }
    }
}

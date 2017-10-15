package dto;

import openjanela.model.entities.design.ShapeNotesEntityObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-02-13
 *          Time: 03:46 PM
 */
public class ShapeNotesBeanUtils {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ShapeNotesBeanUtils.class);

    /**
     * This method clone ShapeNotesEntityObject to a new instance
     *
     * @param bean, ShapeNotesEntityObject
     * @return ShapeNotesEntityObject
     * @throws DTOTransformationError, Error
     */
    public static ShapeNotesEntityObject cloneBean(ShapeNotesEntityObject bean) throws DTOTransformationError {

        try {

            if (bean == null) {
                throw new DTOTransformationError();
            }

            ShapeNotesEntityObject shapeNotes = new ShapeNotesEntityObject();
            BeanUtils.copyProperties(shapeNotes, bean);
            shapeNotes.setId(null);

            return shapeNotes;

        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }
    }
}

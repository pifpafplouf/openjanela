package dto;

import Model.ProfileParts.ProfileParts;
import Model.ShapeObject;
import openjanela.model.entities.design.ConstructionMap;
import openjanela.model.entities.design.ProfileAbstractObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 01-09-13
 * Time: 10:50 PM
 */
public class ProfilesBeanUtils {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ProfilesBeanUtils.class);

    /**
     * This method clone ProfileAbstractObject to a new instance
     *
     * @param bean,  ProfileAbstractObject
     * @param clazz, Class instance object to create
     * @return ProfileAbstractObject
     * @throws DTOTransformationError, Error
     */
    public static ProfileAbstractObject cloneBean(ProfileAbstractObject bean, Class clazz) throws DTOTransformationError {

        try {

            ProfileAbstractObject profileObject = (ProfileAbstractObject)clazz.newInstance();
            BeanUtils.copyProperties(profileObject, bean);
            profileObject.setId(null);
            profileObject.setPartsNotching(null);
            profileObject.setOptions(null);

            return profileObject;

        } catch (InstantiationException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }
    }

    /**
     * This method copy properties from ShapeObject to a new instance clazz
     *
     * @param object, ShapeObject
     * @param clazz,       Class extends from ShapeObject
     * @return ShapeObject model design
     * @throws DTOTransformationError, Error
     */
    public static ProfileParts copyProperties(ProfileParts object, Class clazz) throws DTOTransformationError {

        try {

            ProfileParts newObject = (ProfileParts) clazz.newInstance();

            Field[] fields = object.getClass().getFields();
            for (Field field : fields) {
                Object value = field.get(object);

                Field newField = newObject.getClass().getField(field.getName());
                newField.set(newObject, value);
            }

            return newObject;

        } catch (InstantiationException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (NoSuchFieldException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }
    }
}

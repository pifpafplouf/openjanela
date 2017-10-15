package dto;

import Model.ProfileParts.*;
import Model.ShapeObject;
import openjanela.model.entities.design.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 01-09-13
 * Time: 09:52 PM
 */
public class ShapeObjectBeanUtils {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ShapeObjectBeanUtils.class);

    /**
     * This method clone ShapeAbstractObject to a new instance
     *
     * @param bean,  ShapeAbstractObject
     * @param clazz, Class instance object to create
     * @return ShapeAbstractObject
     * @throws DTOTransformationError, Error
     */
    public static ShapeAbstractObject cloneBean(ShapeAbstractObject bean, Class clazz) throws DTOTransformationError {

        try {

            ShapeAbstractObject shapeObject = (ShapeAbstractObject) clazz.newInstance();
            BeanUtils.copyProperties(shapeObject, bean);
            shapeObject.setId(null);
            shapeObject.setConstructionMap(null);
//            shapeObject.setBoms(null);
            shapeObject.setOptions(null);
            shapeObject.setProfileBOMs(null);
            shapeObject.setProfileCollection(null);

            //Clone construction map
            ConstructionMap constructionMap = new ConstructionMap();
            BeanUtils.copyProperties(constructionMap, bean.getConstructionMap());
            constructionMap.setId(null);
            shapeObject.setConstructionMap(constructionMap);

            return shapeObject;

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
    public static ShapeObject copyProperties(ShapeObject object, Class clazz) throws DTOTransformationError {

        try {

            ShapeObject newObject = (ShapeObject) clazz.newInstance();

            Field[] fields = object.getClass().getFields();
            for (Field field : fields) {
                Object value = field.get(object);

                Field newField = newObject.getClass().getField(field.getName());
                newField.set(newObject, value);
            }

            //Copy properties for parts object
            newObject.top1Part = (Profiles)ProfilesBeanUtils.copyProperties(object.top1Part, Profiles.class);
            newObject.top2Part = (Profiles)ProfilesBeanUtils.copyProperties(object.top2Part, Profiles.class);
            newObject.top3Part = (Profiles)ProfilesBeanUtils.copyProperties(object.top3Part, Profiles.class);
            newObject.bot1Part = (Profiles)ProfilesBeanUtils.copyProperties(object.bot1Part, Profiles.class);
            newObject.bot2Part = (Profiles)ProfilesBeanUtils.copyProperties(object.bot2Part, Profiles.class);
            newObject.bot3Part = (Profiles)ProfilesBeanUtils.copyProperties(object.bot3Part, Profiles.class);
            newObject.leftPart = (Profiles)ProfilesBeanUtils.copyProperties(object.leftPart, Profiles.class);
            newObject.rightPart = (Profiles)ProfilesBeanUtils.copyProperties(object.rightPart, Profiles.class);
            newObject.top1 = (Top1Object)ProfilesBeanUtils.copyProperties(object.top1, Top1Object.class);
            newObject.top2 = (Top2Object)ProfilesBeanUtils.copyProperties(object.top2, Top2Object.class);
            newObject.top3 = (Top3Object)ProfilesBeanUtils.copyProperties(object.top3, Top3Object.class);
            newObject.bot1 = (Bot1Object)ProfilesBeanUtils.copyProperties(object.bot1, Bot1Object.class);
            newObject.bot2 = (Bot2Object)ProfilesBeanUtils.copyProperties(object.bot2, Bot2Object.class);
            newObject.bot3 = (Bot3Object)ProfilesBeanUtils.copyProperties(object.bot3, Bot3Object.class);
            newObject.left = (LeftObject)ProfilesBeanUtils.copyProperties(object.left, LeftObject.class);
            newObject.right = (RightObject)ProfilesBeanUtils.copyProperties(object.right, RightObject.class);

            //Copy properties for parts collection object
            Collection partObjects = new ArrayList();
            for (Object parts : newObject.partObjects) {
                Profiles profiles = (Profiles)ProfilesBeanUtils.copyProperties((ProfileParts)parts, Profiles.class);
                partObjects.add(profiles);
            }
            newObject.partObjects = partObjects;

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
                                                                                  
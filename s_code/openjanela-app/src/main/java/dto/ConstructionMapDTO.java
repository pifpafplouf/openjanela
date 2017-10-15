package dto;

import Model.LevelSequence;
import Model.ProfileParts.ProfileParts;
import Model.ShapeObject;
import openjanela.model.entities.design.ConstructionMap;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 01-04-13
 * Time: 12:51 PM
 */
public class ConstructionMapDTO {

    private static final Logger logger = Logger.getLogger(ConstructionMapDTO.class);

    /**
     * This method return a Construction map for ShapeObject
     *
     * @param shapeObject, ShapeObject
     * @return ConstructionMap
     */
    public static ConstructionMap getConstructionMap(ShapeObject shapeObject) {

        ConstructionMap constructionMap = new ConstructionMap();
        constructionMap.set_a_assemblyLevel(shapeObject.a_assemblyLevel);
        constructionMap.set_a_1Level(shapeObject.a_1Level);
        constructionMap.set_a_2Level(shapeObject.a_2Level);
        constructionMap.set_a_3Level(shapeObject.a_3Level);
        constructionMap.set_a_4Level(shapeObject.a_4Level);
        constructionMap.set_a_5Level(shapeObject.a_5Level);
        constructionMap.set_a_6Level(shapeObject.a_6Level);
        constructionMap.set_a_7Level(shapeObject.a_7Level);
        constructionMap.set_a_8Level(shapeObject.a_8Level);
        constructionMap.set_a_9Level(shapeObject.a_9Level);
        constructionMap.set_a_10Level(shapeObject.a_10Level);
        constructionMap.set_a_11Level(shapeObject.a_11Level);
        constructionMap.set_a_12Level(shapeObject.a_12Level);
        constructionMap.set_a_13Level(shapeObject.a_13Level);
        constructionMap.set_a_14Level(shapeObject.a_14Level);
        constructionMap.set_a_15Level(shapeObject.a_15Level);
        constructionMap.set_a_16Level(shapeObject.a_16Level);
        constructionMap.set_a_17Level(shapeObject.a_17Level);
        constructionMap.set_a_18Level(shapeObject.a_18Level);
        constructionMap.set_a_19Level(shapeObject.a_19Level);
        constructionMap.set_a_20Level(shapeObject.a_20Level);
        constructionMap.set_a_21Level(shapeObject.a_21Level);
        constructionMap.set_a_22Level(shapeObject.a_22Level);
        constructionMap.set_a_1Sequence(shapeObject.a_1Sequence);
        constructionMap.set_a_2Sequence(shapeObject.a_2Sequence);
        constructionMap.set_a_3Sequence(shapeObject.a_3Sequence);
        constructionMap.set_a_4Sequence(shapeObject.a_4Sequence);
        constructionMap.set_a_5Sequence(shapeObject.a_5Sequence);
        constructionMap.set_a_6Sequence(shapeObject.a_6Sequence);
        constructionMap.set_a_7Sequence(shapeObject.a_7Sequence);
        constructionMap.set_a_8Sequence(shapeObject.a_8Sequence);
        constructionMap.set_a_9Sequence(shapeObject.a_9Sequence);
        constructionMap.set_a_10Sequence(shapeObject.a_10Sequence);
        constructionMap.set_a_11Sequence(shapeObject.a_11Sequence);
        constructionMap.set_a_12Sequence(shapeObject.a_12Sequence);
        constructionMap.set_a_13Sequence(shapeObject.a_13Sequence);
        constructionMap.set_a_14Sequence(shapeObject.a_14Sequence);
        constructionMap.set_a_15Sequence(shapeObject.a_15Sequence);
        constructionMap.set_a_16Sequence(shapeObject.a_16Sequence);
        constructionMap.set_a_17Sequence(shapeObject.a_17Sequence);
        constructionMap.set_a_18Sequence(shapeObject.a_18Sequence);
        constructionMap.set_a_19Sequence(shapeObject.a_19Sequence);
        constructionMap.set_a_20Sequence(shapeObject.a_20Sequence);
        constructionMap.set_a_21Sequence(shapeObject.a_21Sequence);
        constructionMap.set_a_22Sequence(shapeObject.a_22Sequence);

        return constructionMap;
    }

    /**
     * Return a List of Map Levels for Shape Object
     *
     * @param shapeClazz , Class Shape Object
     * @param object     , Object to process
     * @return Map
     */
    public static Map<Integer, LevelSequence> shapeMapLevels(Class shapeClazz, Object object)
            throws IllegalAccessException, InvocationTargetException {

        // Levels map for shapeObject
        Map<Integer, LevelSequence> levels = new HashMap<Integer, LevelSequence>();

        // Start and Finish level count for Shape Object Map
        int position = 1;
        int startLevel = 1;
        int maxLevels = 22;

        Method[] childFields = shapeClazz.getMethods();
        if (shapeClazz.getSuperclass().getFields().length > 0) {
            childFields = shapeClazz.getSuperclass().getMethods();
        }

        do {

            for (Method level : childFields) {

                String levelName = level.getName();

                if (levelName.equals("get_a_" + startLevel + "Level")) {

                    for (Method sequence : childFields) {

                        String sequenceName = sequence.getName();

                        if (sequenceName.equals("get_a_" + startLevel + "Sequence")) {
                            Integer levelID = (Integer) level.invoke(object);
                            Integer sequenceID = (Integer) sequence.invoke(object);

                            if (levelID > 0 && sequenceID > 0) {
                                LevelSequence childSequence = new LevelSequence(levelID, sequenceID);
                                levels.put(position, childSequence);

                                position++;

                                break;
                            }
                        }
                    }
                    startLevel++;
                }
            }

        } while (startLevel <= maxLevels);

        return levels;
    }

    /**
     * This method clone a ConstructionMap javaBean properties
     *
     * @param constructionMapEntity, ConstructionMap
     * @return ConstructionMap
     */
    public static ConstructionMap cloneConstructionMap(ConstructionMap constructionMapEntity) throws DTOTransformationError {

        if (constructionMapEntity == null) {
            throw new DTOTransformationError();
        }

        //Clone Construction Map
        return ConstructionMapBeanUtils.cloneBean(constructionMapEntity);
    }

    /**
     * This method copy a contruction map from a parent ShapeObject to ProfileParts
     *
     * @param profile,     ProfileParts object model
     * @param shapeObject, ShapeObject object model
     * @throws DTOTransformationError, Error
     */
    public static void copyConstructionMap(ProfileParts profile, ShapeObject shapeObject) throws DTOTransformationError {

        if (profile == null) {
            throw new DTOTransformationError();
        }

        if (shapeObject == null) {
            throw new DTOTransformationError();
        }

        profile.a_1Level = shapeObject.a_1Level;
        profile.a_2Level = shapeObject.a_2Level;
        profile.a_3Level = shapeObject.a_3Level;
        profile.a_4Level = shapeObject.a_4Level;
        profile.a_5Level = shapeObject.a_5Level;
        profile.a_6Level = shapeObject.a_6Level;
        profile.a_7Level = shapeObject.a_7Level;
        profile.a_8Level = shapeObject.a_8Level;
        profile.a_9Level = shapeObject.a_9Level;
        profile.a_10Level = shapeObject.a_10Level;
        profile.a_11Level = shapeObject.a_11Level;
        profile.a_12Level = shapeObject.a_12Level;
        profile.a_13Level = shapeObject.a_13Level;
        profile.a_14Level = shapeObject.a_14Level;
        profile.a_15Level = shapeObject.a_15Level;
        profile.a_16Level = shapeObject.a_16Level;
        profile.a_17Level = shapeObject.a_17Level;
        profile.a_18Level = shapeObject.a_18Level;
        profile.a_19Level = shapeObject.a_19Level;
        profile.a_20Level = shapeObject.a_20Level;
        profile.a_21Level = shapeObject.a_21Level;
        profile.a_22Level = shapeObject.a_22Level;

        profile.a_1Sequence = shapeObject.a_1Sequence;
        profile.a_2Sequence = shapeObject.a_2Sequence;
        profile.a_3Sequence = shapeObject.a_3Sequence;
        profile.a_4Sequence = shapeObject.a_4Sequence;
        profile.a_5Sequence = shapeObject.a_5Sequence;
        profile.a_6Sequence = shapeObject.a_6Sequence;
        profile.a_7Sequence = shapeObject.a_7Sequence;
        profile.a_8Sequence = shapeObject.a_8Sequence;
        profile.a_9Sequence = shapeObject.a_9Sequence;
        profile.a_10Sequence = shapeObject.a_10Sequence;
        profile.a_11Sequence = shapeObject.a_11Sequence;
        profile.a_12Sequence = shapeObject.a_12Sequence;
        profile.a_13Sequence = shapeObject.a_13Sequence;
        profile.a_14Sequence = shapeObject.a_14Sequence;
        profile.a_15Sequence = shapeObject.a_15Sequence;
        profile.a_16Sequence = shapeObject.a_16Sequence;
        profile.a_17Sequence = shapeObject.a_17Sequence;
        profile.a_18Sequence = shapeObject.a_18Sequence;
        profile.a_19Sequence = shapeObject.a_19Sequence;
        profile.a_20Sequence = shapeObject.a_20Sequence;
        profile.a_21Sequence = shapeObject.a_21Sequence;
    }

    /**
     * This method evaluate if a construction map is the correct for a ShapeObject
     *
     * @param shapeObject,     ShapeObject
     * @param constructionMap, ConstructionMap
     * @return int
     */
    public static int isEqualsConstructionMap(ShapeObject shapeObject, ConstructionMap constructionMap) {

        int equals = 0;

        if (shapeObject.a_assemblyLevel > constructionMap.get_a_assemblyLevel()) {
            equals += 1;
        } else if (shapeObject.a_assemblyLevel < constructionMap.get_a_assemblyLevel()) {
            equals -= 1;
        }

        if (shapeObject.a_1Level > constructionMap.get_a_1Level()) {
            equals += 1;
        } else if (shapeObject.a_1Level < constructionMap.get_a_1Level()) {
            equals -= 1;
        }

        if (shapeObject.a_2Level > constructionMap.get_a_2Level()) {
            equals += 1;
        } else if (shapeObject.a_2Level < constructionMap.get_a_2Level()) {
            equals -= 1;
        }

        if (shapeObject.a_3Level > constructionMap.get_a_3Level()) {
            equals += 1;
        } else if (shapeObject.a_3Level < constructionMap.get_a_3Level()) {
            equals -= 1;
        }

        if (shapeObject.a_4Level > constructionMap.get_a_4Level()) {
            equals += 1;
        } else if (shapeObject.a_4Level < constructionMap.get_a_4Level()) {
            equals -= 1;
        }

        if (shapeObject.a_5Level > constructionMap.get_a_5Level()) {
            equals += 1;
        } else if (shapeObject.a_5Level < constructionMap.get_a_5Level()) {
            equals -= 1;
        }

        if (shapeObject.a_6Level > constructionMap.get_a_6Level()) {
            equals += 1;
        } else if (shapeObject.a_6Level < constructionMap.get_a_6Level()) {
            equals -= 1;
        }

        if (shapeObject.a_7Level > constructionMap.get_a_7Level()) {
            equals += 1;
        } else if (shapeObject.a_7Level < constructionMap.get_a_7Level()) {
            equals -= 1;
        }

        if (shapeObject.a_8Level > constructionMap.get_a_8Level()) {
            equals += 1;
        } else if (shapeObject.a_8Level < constructionMap.get_a_8Level()) {
            equals -= 1;
        }

        if (shapeObject.a_9Level > constructionMap.get_a_9Level()) {
            equals += 1;
        } else if (shapeObject.a_9Level < constructionMap.get_a_9Level()) {
            equals -= 1;
        }

        if (shapeObject.a_10Level > constructionMap.get_a_10Level()) {
            equals += 1;
        } else if (shapeObject.a_10Level < constructionMap.get_a_10Level()) {
            equals -= 1;
        }

        if (shapeObject.a_11Level > constructionMap.get_a_11Level()) {
            equals += 1;
        } else if (shapeObject.a_11Level < constructionMap.get_a_11Level()) {
            equals -= 1;
        }

        if (shapeObject.a_12Level > constructionMap.get_a_12Level()) {
            equals += 1;
        } else if (shapeObject.a_12Level < constructionMap.get_a_12Level()) {
            equals -= 1;
        }

        if (shapeObject.a_13Level > constructionMap.get_a_13Level()) {
            equals += 1;
        } else if (shapeObject.a_13Level < constructionMap.get_a_13Level()) {
            equals -= 1;
        }

        if (shapeObject.a_14Level > constructionMap.get_a_14Level()) {
            equals += 1;
        } else if (shapeObject.a_14Level < constructionMap.get_a_14Level()) {
            equals -= 1;
        }

        if (shapeObject.a_15Level > constructionMap.get_a_15Level()) {
            equals += 1;
        } else if (shapeObject.a_15Level < constructionMap.get_a_15Level()) {
            equals -= 1;
        }

        if (shapeObject.a_16Level > constructionMap.get_a_16Level()) {
            equals += 1;
        } else if (shapeObject.a_16Level < constructionMap.get_a_16Level()) {
            equals -= 1;
        }

        if (shapeObject.a_17Level > constructionMap.get_a_17Level()) {
            equals += 1;
        } else if (shapeObject.a_17Level < constructionMap.get_a_17Level()) {
            equals -= 1;
        }

        if (shapeObject.a_18Level > constructionMap.get_a_18Level()) {
            equals += 1;
        } else if (shapeObject.a_18Level < constructionMap.get_a_18Level()) {
            equals -= 1;
        }

        if (shapeObject.a_19Level > constructionMap.get_a_19Level()) {
            equals += 1;
        } else if (shapeObject.a_19Level < constructionMap.get_a_19Level()) {
            equals -= 1;
        }

        if (shapeObject.a_20Level > constructionMap.get_a_20Level()) {
            equals += 1;
        } else if (shapeObject.a_20Level < constructionMap.get_a_20Level()) {
            equals -= 1;
        }

        if (shapeObject.a_21Level > constructionMap.get_a_21Level()) {
            equals += 1;
        } else if (shapeObject.a_21Level < constructionMap.get_a_21Level()) {
            equals -= 1;
        }

        if (shapeObject.a_22Level > constructionMap.get_a_22Level()) {
            equals += 1;
        } else if (shapeObject.a_22Level < constructionMap.get_a_22Level()) {
            equals -= 1;
        }

        if (shapeObject.a_1Sequence > constructionMap.get_a_1Sequence()) {
            equals += 1;
        } else if (shapeObject.a_1Sequence < constructionMap.get_a_1Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_1Sequence > constructionMap.get_a_1Sequence()) {
            equals += 1;
        } else if (shapeObject.a_1Sequence < constructionMap.get_a_1Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_2Sequence > constructionMap.get_a_2Sequence()) {
            equals += 1;
        } else if (shapeObject.a_2Sequence < constructionMap.get_a_2Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_3Sequence > constructionMap.get_a_3Sequence()) {
            equals += 1;
        } else if (shapeObject.a_3Sequence < constructionMap.get_a_3Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_4Sequence > constructionMap.get_a_4Sequence()) {
            equals += 1;
        } else if (shapeObject.a_4Sequence < constructionMap.get_a_4Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_5Sequence > constructionMap.get_a_5Sequence()) {
            equals += 1;
        } else if (shapeObject.a_5Sequence < constructionMap.get_a_5Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_6Sequence > constructionMap.get_a_6Sequence()) {
            equals += 1;
        } else if (shapeObject.a_6Sequence < constructionMap.get_a_6Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_7Sequence > constructionMap.get_a_7Sequence()) {
            equals += 1;
        } else if (shapeObject.a_7Sequence < constructionMap.get_a_7Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_8Sequence > constructionMap.get_a_8Sequence()) {
            equals += 1;
        } else if (shapeObject.a_8Sequence < constructionMap.get_a_8Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_9Sequence > constructionMap.get_a_9Sequence()) {
            equals += 1;
        } else if (shapeObject.a_9Sequence < constructionMap.get_a_9Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_10Sequence > constructionMap.get_a_10Sequence()) {
            equals += 1;
        } else if (shapeObject.a_10Sequence < constructionMap.get_a_10Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_11Sequence > constructionMap.get_a_11Sequence()) {
            equals += 1;
        } else if (shapeObject.a_11Sequence < constructionMap.get_a_11Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_12Sequence > constructionMap.get_a_12Sequence()) {
            equals += 1;
        } else if (shapeObject.a_12Sequence < constructionMap.get_a_12Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_13Sequence > constructionMap.get_a_13Sequence()) {
            equals += 1;
        } else if (shapeObject.a_13Sequence < constructionMap.get_a_13Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_14Sequence > constructionMap.get_a_14Sequence()) {
            equals += 1;
        } else if (shapeObject.a_14Sequence < constructionMap.get_a_14Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_15Sequence > constructionMap.get_a_15Sequence()) {
            equals += 1;
        } else if (shapeObject.a_15Sequence < constructionMap.get_a_15Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_16Sequence > constructionMap.get_a_16Sequence()) {
            equals += 1;
        } else if (shapeObject.a_16Sequence < constructionMap.get_a_16Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_17Sequence > constructionMap.get_a_17Sequence()) {
            equals += 1;
        } else if (shapeObject.a_17Sequence < constructionMap.get_a_17Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_18Sequence > constructionMap.get_a_18Sequence()) {
            equals += 1;
        } else if (shapeObject.a_18Sequence < constructionMap.get_a_18Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_19Sequence > constructionMap.get_a_19Sequence()) {
            equals += 1;
        } else if (shapeObject.a_19Sequence < constructionMap.get_a_19Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_20Sequence > constructionMap.get_a_20Sequence()) {
            equals += 1;
        } else if (shapeObject.a_20Sequence < constructionMap.get_a_20Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_21Sequence > constructionMap.get_a_21Sequence()) {
            equals += 1;
        } else if (shapeObject.a_21Sequence < constructionMap.get_a_21Sequence()) {
            equals -= 1;
        }

        if (shapeObject.a_22Sequence > constructionMap.get_a_22Sequence()) {
            equals += 1;
        } else if (shapeObject.a_22Sequence < constructionMap.get_a_22Sequence()) {
            equals -= 1;
        }

        //Evaluate equals variable
        if (equals == 0) {
            equals = 0;
        } else if (equals > 0) {
            equals = 1;
        } else if (equals < 0) {
            equals = -1;
        }

        return equals;
    }
}

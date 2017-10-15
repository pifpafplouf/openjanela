package openjanela.model.eao.design.designGlassRatingsEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.DesignGlassRatingsEntityObject;

import java.util.List;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 10/10/13
 *          Time: 10:11 PM
 */
public interface DesignGlassRatingsEAO extends GenericEAO<DesignGlassRatingsEntityObject, Integer> {

    /**
     * Find Glass Ratings Values
     *
     * @param orderId,   Order Identification Id
     * @param itemNo,    Item Number Identification Id
     * @param versionNo, Version Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<DesignGlassRatingsEntityObject> findGlassRatings(Integer orderId, Integer itemNo, Integer versionNo)
            throws GenericPersistenceEAOException;

    /**
     * Find Glass Ratings Values by Order, Item, Version & Map Level Shape
     *
     * @param orderId,         Order Identification Id
     * @param itemNo,          Item Number Identification Id
     * @param versionNo,       Version Identification Id
     * @param levelId,         Level Identification Id
     * @param sequenceId,      Sequence Identification Id
     * @param assemblyLevelId, Assembly Level Identification Id
     * @param level1,          Level 1
     * @param level2,          Level 2
     * @param level3,          Level 3
     * @param level4,          Level 4
     * @param level5,          Level 5
     * @param level6,          Level 6
     * @param level7,          Level 7
     * @param level8,          Level 8
     * @param level9,          Level 9
     * @param level10,         Level 10
     * @param level11,         Level 11
     * @param level12,         Level 12
     * @param level13,         Level 13
     * @param level14,         Level 14
     * @param level15,         Level 15
     * @param level16,         Level 16
     * @param level17,         Level 17
     * @param level18,         Level 18
     * @param level19,         Level 19
     * @param level20,         Level 20
     * @param level21,         Level 21
     * @param level22,         Level 22
     * @param sequence1,       Sequence 1
     * @param sequence2,       Sequence 2
     * @param sequence3,       Sequence 3
     * @param sequence4,       Sequence 4
     * @param sequence5,       Sequence 5
     * @param sequence6,       Sequence 6
     * @param sequence7,       Sequence 7
     * @param sequence8,       Sequence 8
     * @param sequence9,       Sequence 9
     * @param sequence10,      Sequence 10
     * @param sequence11,      Sequence 11
     * @param sequence12,      Sequence 12
     * @param sequence13,      Sequence 13
     * @param sequence14,      Sequence 14
     * @param sequence15,      Sequence 15
     * @param sequence16,      Sequence 16
     * @param sequence17,      Sequence 17
     * @param sequence18,      Sequence 18
     * @param sequence19,      Sequence 19
     * @param sequence20,      Sequence 20
     * @param sequence21,      Sequence 21
     * @param sequence22,      Sequence 22
     * @return List<DesignGlassRatingsEntityObject>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<DesignGlassRatingsEntityObject> findGlassRatings(int orderId, int itemNo, Integer versionNo,
                                                                 int levelId, int sequenceId, int assemblyLevelId,
                                                                 int level1, int level2, int level3, int level4, int level5,
                                                                 int level6, int level7, int level8, int level9, int level10,
                                                                 int level11, int level12, int level13, int level14, int level15,
                                                                 int level16, int level17, int level18, int level19, int level20,
                                                                 int level21, int level22, int sequence1, int sequence2,
                                                                 int sequence3, int sequence4, int sequence5, int sequence6,
                                                                 int sequence7, int sequence8, int sequence9, int sequence10,
                                                                 int sequence11, int sequence12, int sequence13, int sequence14,
                                                                 int sequence15, int sequence16, int sequence17, int sequence18,
                                                                 int sequence19, int sequence20, int sequence21, int sequence22)
            throws GenericPersistenceEAOException;
}

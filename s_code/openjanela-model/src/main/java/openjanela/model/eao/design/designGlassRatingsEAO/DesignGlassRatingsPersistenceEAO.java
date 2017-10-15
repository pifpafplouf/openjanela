package openjanela.model.eao.design.designGlassRatingsEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.DesignGlassRatingsEntityObject;
import org.hibernate.Hibernate;

import java.util.List;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 10/10/13
 *          Time: 10:10 PM
 */
public class DesignGlassRatingsPersistenceEAO extends GenericPersistenceEAO<DesignGlassRatingsEntityObject, Integer>
        implements DesignGlassRatingsEAO {

    @Override
    public List<DesignGlassRatingsEntityObject> findGlassRatings(Integer orderId, Integer itemNo, Integer versionNo)
            throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            List<DesignGlassRatingsEntityObject> glassRatings = em.createQuery("select d from DesignGlassRatingsEntityObject d " +
                    "where d.orderId = :orderId and " +
                    "d.itemNo = :itemNo and d.versionId = :versionNo").
                    setParameter("orderId", orderId).
                    setParameter("itemNo", itemNo).
                    setParameter("versionNo", versionNo).getResultList();

            for (DesignGlassRatingsEntityObject glassRating : glassRatings) {
                Hibernate.initialize(glassRating.getDesignRatings());
            }

            return glassRatings;

        } finally {
            closeService();
        }
    }

    @Override
    public List<DesignGlassRatingsEntityObject> findGlassRatings(int orderId, int itemNo, Integer versionNo, int levelId,
                                                                 int sequenceId, int assemblyLevelId, int level1, int level2,
                                                                 int level3, int level4, int level5, int level6, int level7,
                                                                 int level8, int level9, int level10, int level11,
                                                                 int level12, int level13, int level14, int level15,
                                                                 int level16, int level17, int level18, int level19,
                                                                 int level20, int level21, int level22, int sequence1,
                                                                 int sequence2, int sequence3, int sequence4, int sequence5,
                                                                 int sequence6, int sequence7, int sequence8, int sequence9,
                                                                 int sequence10, int sequence11, int sequence12, int sequence13,
                                                                 int sequence14, int sequence15, int sequence16, int sequence17,
                                                                 int sequence18, int sequence19, int sequence20, int sequence21,
                                                                 int sequence22) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            List<DesignGlassRatingsEntityObject> glassRatings = em.createQuery("select d from DesignGlassRatingsEntityObject d " +
                    "where d.orderId = :orderId and " +
                    "d.itemNo = :itemNo and " +
                    "d.versionId = :versionNo and " +
                    "d.levelId = :levelId and " +
                    "d.sequenceId = :sequenceId and " +
                    "d.assemblyLevelId = :assemblyLevelId and " +
                    "d.level1 = :level1 and " +
                    "d.level2 = :level2 and " +
                    "d.level3 = :level3 and " +
                    "d.level4 = :level4 and " +
                    "d.level5 = :level5 and " +
                    "d.level6 = :level6 and " +
                    "d.level7 = :level7 and " +
                    "d.level8 = :level8 and " +
                    "d.level9 = :level9 and " +
                    "d.level10 = :level10 and " +
                    "d.level11 = :level11 and " +
                    "d.level12 = :level12 and " +
                    "d.level13 = :level13 and " +
                    "d.level14 = :level14 and " +
                    "d.level15 = :level15 and " +
                    "d.level16 = :level16 and " +
                    "d.level17 = :level17 and " +
                    "d.level18 = :level18 and " +
                    "d.level19 = :level19 and " +
                    "d.level20 = :level20 and " +
                    "d.level21 = :level21 and " +
                    "d.level22 = :level22 and " +
                    "d.sequence1 = :sequence1 and " +
                    "d.sequence2 = :sequence2 and " +
                    "d.sequence3 = :sequence3 and " +
                    "d.sequence4 = :sequence4 and " +
                    "d.sequence5 = :sequence5 and " +
                    "d.sequence6 = :sequence6 and " +
                    "d.sequence7 = :sequence7 and " +
                    "d.sequence8 = :sequence8 and " +
                    "d.sequence9 = :sequence9 and " +
                    "d.sequence10 = :sequence10 and " +
                    "d.sequence11 = :sequence11 and " +
                    "d.sequence12 = :sequence12 and " +
                    "d.sequence13 = :sequence13 and " +
                    "d.sequence14 = :sequence14 and " +
                    "d.sequence15 = :sequence15 and " +
                    "d.sequence16 = :sequence16 and " +
                    "d.sequence17 = :sequence17 and " +
                    "d.sequence18 = :sequence18 and " +
                    "d.sequence19 = :sequence19 and " +
                    "d.sequence20 = :sequence20 and " +
                    "d.sequence21 = :sequence21 and " +
                    "d.sequence22 = :sequence22").
                    setParameter("orderId", orderId).
                    setParameter("itemNo", itemNo).
                    setParameter("versionNo", versionNo).
                    setParameter("levelId", levelId).
                    setParameter("sequenceId", sequenceId).
                    setParameter("assemblyLevelId", assemblyLevelId).
                    setParameter("level1", level1).
                    setParameter("level2", level2).
                    setParameter("level3", level3).
                    setParameter("level4", level4).
                    setParameter("level5", level5).
                    setParameter("level6", level6).
                    setParameter("level7", level7).
                    setParameter("level8", level8).
                    setParameter("level9", level9).
                    setParameter("level10", level10).
                    setParameter("level11", level11).
                    setParameter("level12", level12).
                    setParameter("level13", level13).
                    setParameter("level14", level14).
                    setParameter("level15", level15).
                    setParameter("level16", level16).
                    setParameter("level17", level17).
                    setParameter("level18", level18).
                    setParameter("level19", level19).
                    setParameter("level20", level20).
                    setParameter("level21", level21).
                    setParameter("level22", level22).
                    setParameter("sequence1", sequence1).
                    setParameter("sequence2", sequence2).
                    setParameter("sequence3", sequence3).
                    setParameter("sequence4", sequence4).
                    setParameter("sequence5", sequence5).
                    setParameter("sequence6", sequence6).
                    setParameter("sequence7", sequence7).
                    setParameter("sequence8", sequence8).
                    setParameter("sequence9", sequence9).
                    setParameter("sequence10", sequence10).
                    setParameter("sequence11", sequence11).
                    setParameter("sequence12", sequence12).
                    setParameter("sequence13", sequence13).
                    setParameter("sequence14", sequence14).
                    setParameter("sequence15", sequence15).
                    setParameter("sequence16", sequence16).
                    setParameter("sequence17", sequence17).
                    setParameter("sequence18", sequence18).
                    setParameter("sequence19", sequence19).
                    setParameter("sequence20", sequence20).
                    setParameter("sequence21", sequence21).
                    setParameter("sequence22", sequence22).getResultList();

            for (DesignGlassRatingsEntityObject glassRating : glassRatings) {
                Hibernate.initialize(glassRating.getDesignRatings());
            }

            return glassRatings;

        } finally {
            closeService();
        }
    }
}

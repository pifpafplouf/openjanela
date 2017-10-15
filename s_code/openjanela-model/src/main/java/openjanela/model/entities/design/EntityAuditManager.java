package openjanela.model.entities.design;

import org.apache.log4j.Logger;

import javax.persistence.PrePersist;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 01-07-13
 * Time: 12:28 PM
 */
public class EntityAuditManager {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(EntityAuditManager.class);

    /**
     * This method clean a detach entity object Identification Id
     *
     * @param entity, Object
     */
    @PrePersist
    public void detachEntityObject(Object entity) {

//        try {
//
//            Method setId = entity.getClass().getMethod("setId", Integer.class);
//            setId.invoke(entity, null);
//
//        } catch (NoSuchMethodException e) {
//            logger.error(e.getMessage(), e);
//        } catch (InvocationTargetException e) {
//            logger.error(e.getMessage(), e);
//        } catch (IllegalAccessException e) {
//            logger.error(e.getMessage(), e);
//        }
    }
}

package dto;

import openjanela.model.entities.design.AssemblyEntityObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 02-27-13
 * Time: 01:26 PM
 */
public class AssemblyBeanUtils {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(AssemblyBeanUtils.class);

    /**
     *
     * @param bean
     * @return
     * @throws DTOTransformationError
     */
    public static AssemblyEntityObject cloneBean(AssemblyEntityObject bean) throws DTOTransformationError {

        try {

            if (bean == null) {
                throw new DTOTransformationError();
            }

            AssemblyEntityObject assemblyEntity = new AssemblyEntityObject();
            BeanUtils.copyProperties(assemblyEntity, bean);
            assemblyEntity.setId(null);
            assemblyEntity.setBom(null);

            return assemblyEntity;

        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }

    }
}

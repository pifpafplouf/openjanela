package dto;

import openjanela.model.entities.design.AssemblyEntityObject;
import openjanela.model.entities.design.BillOfMaterialEntityObject;
import openjanela.model.entities.design.ConstructionMap;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 01-10-13
 * Time: 09:05 AM
 */
public class BillOfMaterialBeanUtils {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ProfilesBeanUtils.class);

    /**
     * This method clone BillOfMaterialEntityObject to a new instance
     *
     * @param bean, BillOfMaterialEntityObject
     * @return BillOfMaterialEntityObject
     * @throws DTOTransformationError, Error
     */
    public static BillOfMaterialEntityObject cloneBean(BillOfMaterialEntityObject bean) throws DTOTransformationError {

        try {

            if (bean == null) {
                throw new DTOTransformationError();
            }

            BillOfMaterialEntityObject billOfMaterial = new BillOfMaterialEntityObject();
            BeanUtils.copyProperties(billOfMaterial, bean);
            billOfMaterial.setId(null);
            billOfMaterial.setConstructionMap(null);

            //Clone Construction Map
            ConstructionMap constructionMap = new ConstructionMap();
            BeanUtils.copyProperties(constructionMap, bean.getConstructionMap());
            constructionMap.setId(null);
            billOfMaterial.setConstructionMap(constructionMap);

            //Clone Assembly part
            if (bean.getAssembly() != null) {
                AssemblyEntityObject assembly = AssemblyBeanUtils.cloneBean(bean.getAssembly());
                assembly.setBom(billOfMaterial);
                billOfMaterial.setAssembly(assembly);
            }

            return billOfMaterial;

        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }
    }
}

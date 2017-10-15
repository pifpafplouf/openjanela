package openjanela.model.eao.partner.attributeTypeEAO;

import java.util.List;

import javax.persistence.Query;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.parts.PartsFamily;
import openjanela.model.entities.parts.TypeAttribute;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public class AttributeTypePersistenceEAO extends GenericPersistenceEAO<TypeAttribute, Integer> implements AttributeTypeEAO {

	 @Override
	    public List<TypeAttribute> findAll() throws GenericPersistenceEAOException {

	        try {

	            // Init service
	            initService();

	            Query query = em.createQuery("select p from TypeAttribute p order by p.id");
	            List<TypeAttribute> pcp = query.getResultList();

	            return pcp;

	        } finally {
	            closeService();
	        }
	    }


}

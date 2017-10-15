package openjanela.model.eao.admin;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.SystemModuleAction;
import openjanela.model.entities.admin.SystemModuleActionPK;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Consultant
 * @version 2.0.8
 *          Date Initial: 03-26-14
 *          Time Initial: 06:39 PM
 */
public interface SystemModuleActionEAO extends GenericEAO<SystemModuleAction, SystemModuleActionPK> {
	
	List<SystemModuleAction> findAllByModule(Integer moduleId) throws GenericPersistenceEAOException;
	
}

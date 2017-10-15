package openjanela.model.eao.admin.userGroupEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.UserGroup;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-03-13
 *          Time: 09:54 AM
 */
public interface UserGroupEAO extends GenericEAO<UserGroup, Integer> {

    /**
     * Return Group List
     * @param groupIds, Group Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<UserGroup> findByIds(String groupIds) throws GenericPersistenceEAOException;
}

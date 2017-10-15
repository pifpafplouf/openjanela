package openjanela.model.eao.admin.userGroupEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
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
public class UserGroupPersistenceEAO extends GenericPersistenceEAO<UserGroup, Integer> implements UserGroupEAO {

    @Override
    public List<UserGroup> findByIds(String groupIds) throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            String query = "select g from UserGroup g where g.id in (" + groupIds + ") order by g.id";

            List<UserGroup> groups = em.createQuery(query).getResultList();

            return groups;

        } finally {
            closeService();
        }
    }
}

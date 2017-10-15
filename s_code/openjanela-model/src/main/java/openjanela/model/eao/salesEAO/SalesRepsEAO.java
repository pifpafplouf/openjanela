package openjanela.model.eao.salesEAO;

import java.sql.Date;
import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.sales.SalesReps;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Consultant
 * @version 2.0.8
 *          Date Initial: 11-05-13
 *          Time Initial: 11:10 PM
 */
public interface SalesRepsEAO extends GenericEAO<SalesReps, Integer> {

    public List<SalesReps> finAllWithUser(boolean all) throws GenericPersistenceEAOException;

    public List<SalesReps> findWithUserBetweenDate(boolean all, Date fromDate, Date toDate) throws GenericPersistenceEAOException;

    public List<SalesReps> findByList(boolean all, List<Integer> userIds, boolean searchDate, Date fromDate, Date toDate) throws GenericPersistenceEAOException;

    public int updateDeletedSalesPerson(Integer userId) throws GenericPersistenceEAOException;

    public boolean existById(Integer userId) throws GenericPersistenceEAOException;
	
}

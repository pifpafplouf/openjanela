package openjanela.model.eao.salesEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.sales.SalesRepsCommission;

import java.sql.Date;
import java.util.List;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Consultant
 * @version 2.0.8
 *          Date Initial: 01-08-14
 *          Time Initial: 11:28 PM
 */
public interface SalesRepsCommissionEAO extends GenericEAO<SalesRepsCommission, Integer> {

    public List<SalesRepsCommission> findAll(boolean all) throws GenericPersistenceEAOException;

    public List<SalesRepsCommission> findBetweenDate(boolean all, Date fromDate, Date toDate) throws GenericPersistenceEAOException;

    public List<SalesRepsCommission> findByQuery(boolean all, String query, String searchBy1, int searchBy2, boolean wildCard,
                                                 boolean isLike) throws GenericPersistenceEAOException;

    public int updateDeletedSalesPersonCommission(Integer salesRepsCommissionId) throws GenericPersistenceEAOException;

    public Integer getMaxId() throws GenericPersistenceEAOException;

    public SalesRepsCommission finByRep(int repID) throws GenericPersistenceEAOException;
	
}

package openjanela.model.eao.salesEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import org.apache.log4j.Logger;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.entities.sales.SalesRepsCommission;
import org.hibernate.Session;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Consultant
 * @version 2.0.8
 *          Date Initial: 01-08-14
 *          Time Initial: 11:28 PM
 */
public class SalesRepsCommissionPersistenceEAO extends GenericPersistenceEAO<SalesRepsCommission, Integer> implements SalesRepsCommissionEAO {
	 //Apache log4j
    private static final Logger logger = Logger.getLogger(SalesRepsCommissionPersistenceEAO.class);

    @Override
    public List<SalesRepsCommission> findAll(boolean all) throws GenericPersistenceEAOException {

        List<SalesRepsCommission> salesRepsCommissions = new ArrayList<SalesRepsCommission>();

        String query = "SELECT src FROM SalesRepsCommission src ";
        		
        try {

            initService();

            if (!all) {
            	query = query.concat("WHERE deleted = 0");
            }
            
            salesRepsCommissions = em.createQuery(query).getResultList();

        }finally{
            closeService();
        }

        return salesRepsCommissions;
    }

    @Override
    public SalesRepsCommission finByRep(int commID) throws GenericPersistenceEAOException {
        SalesRepsCommission comm = new SalesRepsCommission();

        try {
            initService();
            comm = (SalesRepsCommission) em.createQuery("SELECT src FROM SalesRepsCommission src WHERE id = :cid").
                    setParameter("cid", commID).getSingleResult();
        }finally{
            closeService();
        }

        return comm;
    }


    @Override
    public List<SalesRepsCommission> findBetweenDate(boolean all, Date fromDate, Date toDate) throws GenericPersistenceEAOException {
        List<SalesRepsCommission> salesRepsCommissions = new ArrayList<SalesRepsCommission>();
        String query = "SELECT src FROM SalesRepsCommission src WHERE createDate BETWEEN :fromDate AND :toDate";
        		
        try {
            initService();
            
            if (!all) {
            	query = query.concat("AND deleted = 0");
            }
            
            salesRepsCommissions = em.createQuery(query).setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList();
        }finally{
            closeService();
        }

        return salesRepsCommissions;
    }

    @Override
    public List<SalesRepsCommission> findByQuery(boolean all, String query, String searchBy1, int searchBy2, boolean wildCard,
                                                 boolean isLike) throws GenericPersistenceEAOException {

        List<SalesRepsCommission> salesRepsCommissions = null;

        if(isLike){
            if(!searchBy1.equals("")){
                query = query.concat(searchBy1 + "%' ");
            }else if(searchBy2 != -1){
                query = query.concat(searchBy2 + "%' ");
            }
        }
        
        if (!all) {
        	query = query.concat("AND deleted = 0 ");
        }

        query = query.concat("ORDER BY src.id ASC");

        try{
            initService();
            salesRepsCommissions = em.createQuery(query).getResultList();
        }finally{
            closeService();
        }

        return salesRepsCommissions;
    }

    @Override
    public int updateDeletedSalesPersonCommission(Integer salesRepsCommissionId) throws GenericPersistenceEAOException {
        int updated = 0;

        try {
            initService();

            updated = em.createQuery("UPDATE SalesRepsCommission src SET src.deleted = 1 WHERE src.id = :salesRepsCommissionId").
                    setParameter("salesRepsCommissionId", salesRepsCommissionId).executeUpdate();
        } finally {
            closeService();
        }

        return updated;
    }

    @Override
    public Integer getMaxId() throws GenericPersistenceEAOException {
        Integer maxId = null;

        try {
            initService();
            maxId = (Integer) em.createQuery("SELECT MAX(src.id) FROM SalesRepsCommission src").getSingleResult();
        }finally{
            closeService();
        }

        return maxId == null ? 0 : maxId;
    }
  
}

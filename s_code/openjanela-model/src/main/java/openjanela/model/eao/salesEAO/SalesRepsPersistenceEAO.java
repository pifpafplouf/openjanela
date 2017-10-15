package openjanela.model.eao.salesEAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import openjanela.model.eao.admin.userAdminEAO.UserAdminEAO;
import openjanela.model.eao.admin.userAdminEAO.UserAdminPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.sales.SalesReps;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Consultant
 * @version 2.0.8
 *          Date Initial: 11-05-13
 *          Time Initial: 11:13 PM
 */
public class SalesRepsPersistenceEAO extends GenericPersistenceEAO<SalesReps, Integer> implements SalesRepsEAO {
    //Apache log4j
    private static final Logger logger = Logger.getLogger(SalesRepsPersistenceEAO.class);
    private UserAdminEAO userAdminEAO = new UserAdminPersistenceEAO();

    @Override
    public List<SalesReps> finAllWithUser(boolean all) throws GenericPersistenceEAOException {
        List<SalesReps> salesReps = new ArrayList<SalesReps>();
        SalesReps salesRep = null;
        String query = "SELECT sr FROM SalesReps sr ";

        try {

            initService();

            //Session session = (Session) em.getDelegate();
            //Timestamp date = (Timestamp)session.createSQLQuery("SELECT DATE_SUB(NOW(), INTERVAL 180 DAY)").uniqueResult();
            
            if (!all) {
            	query = query.concat("WHERE deleted = 0");
            }
            
            Iterator<?> it = em.createQuery(query).getResultList().iterator();

            while (it.hasNext()) {
                salesRep = (SalesReps) it.next();
                salesRep.setUser(userAdminEAO.findById(salesRep.getUserId()));
                salesReps.add(salesRep);
            }

        }finally{
            closeService();
        }

        return salesReps;
    }

    @Override
    public List<SalesReps> findWithUserBetweenDate(boolean all, Date fromDate, Date toDate) throws GenericPersistenceEAOException {
        List<SalesReps> salesReps = new ArrayList<SalesReps>();
        SalesReps salesRep = null;
        String query = "SELECT sr FROM SalesReps sr WHERE createDate BETWEEN :fromDate AND :toDate ";

        try {
            initService();
            
            if (!all) {
            	query = query.concat("AND deleted = 0");
            }
            
            Iterator<?> it  = em.createQuery(query).setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList().iterator();

            while (it.hasNext()) {
                salesRep = (SalesReps) it.next();
                salesRep.setUser(userAdminEAO.findById(salesRep.getUserId()));
                salesReps.add(salesRep);
            }
        }finally{
            closeService();
        }

        return salesReps;
    }

    @Override
    public List<SalesReps> findByList(boolean all, List<Integer> userIds, boolean searchDate, Date fromDate, Date toDate) throws GenericPersistenceEAOException {
        List<SalesReps> salesReps = new ArrayList<SalesReps>();
        SalesReps salesRep = null;
        String query = "SELECT sr FROM SalesReps sr WHERE sr.userId IN(:userIds) ";

        if (searchDate) {
            query = query.concat("AND sr.createDate BETWEEN :fromDate AND :toDate ");
        }
        
        if (!all) {
        	query = query.concat("AND deleted = 0 ");
        }

        query = query.concat("ORDER BY sr.id ASC");
        
        try{
            initService();

            Session session = (Session) em.getDelegate();
            Query queryObject = session.createQuery(query);

            queryObject.setParameterList("userIds", userIds);

            if(searchDate){
                queryObject.setParameter("fromDate", fromDate).setParameter("toDate", toDate);
            }

            Iterator<?> it = queryObject.list().iterator();

            while (it.hasNext()) {
                salesRep = (SalesReps) it.next();
                salesRep.setUser(userAdminEAO.findById(salesRep.getUserId()));
                salesReps.add(salesRep);
            }
        }finally{
            closeService();
        }

        return salesReps;
    }

    @Override
    public int updateDeletedSalesPerson(Integer userId) throws GenericPersistenceEAOException {
        int updated = 0;

        try {
            initService();

            updated = em.createQuery("UPDATE SalesReps sr SET sr.deleted = 1 WHERE sr.userId = :userId").
                    setParameter("userId", userId).executeUpdate();
        } finally {
            closeService();
        }

        return updated;
    }

    @Override
    public boolean existById(Integer userId) throws GenericPersistenceEAOException {
        boolean exist = false;
        int count = 0;

        try {
            initService();

            count = em.createQuery("SELECT sr FROM SalesReps sr WHERE userId = :userId").setParameter("userId", userId)
                    .getResultList().size();
           
            exist = count != 0 ? true: false;
        }finally{
            closeService();
        }

        return exist;
    }
	
}

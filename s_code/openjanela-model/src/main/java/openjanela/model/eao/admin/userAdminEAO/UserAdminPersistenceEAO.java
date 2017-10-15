package openjanela.model.eao.admin.userAdminEAO;

import openjanela.model.PersistenceManagementServiceFactory;
import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.partnerEAO.PartnerPersistenceEAO;
import openjanela.model.entities.admin.UserAdmin;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-03-13
 *          Time: 09:54 AM
 */
public class UserAdminPersistenceEAO extends GenericPersistenceEAO<UserAdmin, Integer> implements UserAdminEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(PartnerPersistenceEAO.class);

    @Override
    public Integer getMaxId() throws GenericPersistenceEAOException {
        Integer maxId = null;

        try {
            initService();
            
            maxId = (Integer) em.createQuery("SELECT MAX(u.id) FROM UserAdmin u").getSingleResult();
        }finally{
            closeService();
        }

        return maxId == null ? 0 : maxId;
    }
    
    @Override
    public boolean existById(String email, int partnerId, int userId) throws GenericPersistenceEAOException {
        boolean exist = false;
        int count = 0;

        try {
            initService();

            count = em.createQuery("SELECT u FROM UserAdmin u WHERE u.email = :email AND u.partnerId = :partnerId AND u.id != :userId")
            		.setParameter("email", email).setParameter("partnerId", partnerId).setParameter("userId", userId)
                    .getResultList().size();
           
            exist = count != 0 ? true: false;
        }finally{
            closeService();
        }

        return exist;
    }
    
    /**
     * Init persistence service
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     *          , Exception
     */
    @Override
    protected void initService() throws GenericPersistenceEAOException {
        try {
            // Getting persistence service
            em = PersistenceManagementServiceFactory.getEntityManager();
            PersistenceManagementServiceFactory.beginTransaction();

        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    /**
     * Commit service
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException , Exception
     */
    @Override
    protected void commitService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceFactory.commit(true);
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    /**
     * This method close session service from entity access objects
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void closeService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceFactory.close();
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }
    
    @Override
    public List<UserAdmin> findAllOrderByField(boolean all, String field) throws GenericPersistenceEAOException {
        List<UserAdmin> users = new ArrayList<UserAdmin>();
        String query = "SELECT u FROM UserAdmin u ";
     
        try {
            initService();
            
            if (!all) {
            	query = query.concat("WHERE u.deleted = 0 ");
            }
            
            query = query.concat("ORDER BY u." + field);
            
            users  = em.createQuery(query).getResultList();
        }finally{
            closeService();
        }

        return users;
    }
    
    @Override
    public List<UserAdmin> findBetweenDate(boolean all, Date fromDate, Date toDate) throws GenericPersistenceEAOException {
        List<UserAdmin> users = new ArrayList<UserAdmin>();
        String query = "SELECT u FROM UserAdmin u WHERE createDate BETWEEN :fromDate AND :toDate ";
     
        try {
            initService();
            
            if (!all) {
            	query = query.concat("AND u.deleted = 0 ");
            }
            
            query = query.concat("ORDER BY u.firstName");
            
            users  = em.createQuery(query).setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList();
        }finally{
            closeService();
        }

        return users;
    }
    
    @Override
    public List<UserAdmin> findByIdList(int userId) throws GenericPersistenceEAOException {
    	List<UserAdmin> users = new ArrayList<UserAdmin>();
    	
    	try {
    		initService();
             
    		users = em.createQuery("SELECT u FROM UserAdmin u WHERE u.id = :userId")
    					.setParameter("userId", userId).getResultList();
        } finally {
            closeService();
        }
    	
        return users;
    }
    
    @Override
    public List<UserAdmin> findByQuery(boolean all, String query, String searchBy1, int searchBy2, boolean wildCard, boolean isLike, boolean searchDate, Date fromDate, Date toDate) throws GenericPersistenceEAOException {
    	List<UserAdmin> users = new ArrayList<UserAdmin>();

        if(isLike) {
            if(!searchBy1.equals("")) {
                query = query.concat(searchBy1 + "%' ");
            } else if (searchBy2 != -1) {
                query = query.concat(searchBy2 + "%' ");
            }
        }
        
        if (!all) {
        	query = query.concat("AND u.deleted = 0 ");
        }
        
        if(searchDate){
			query = query.concat("u.createDate BETWEEN :fromDate AND :toDate ");
		}
		
        query = query.concat("ORDER BY u.firstName ASC");

        try {
            initService();
            
            Query queryObject = em.createQuery(query);
            
            if(searchDate){
		    	queryObject.setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList();
		    }
		   
            users = queryObject.getResultList();
        } finally {
            closeService();
        }

        return users;
    }


    @Override
    public List<UserAdmin> findByPartner(boolean all, Integer partnerId) throws GenericPersistenceEAOException {
    	List<UserAdmin> users = new ArrayList<UserAdmin>();
    	String query = "SELECT u FROM UserAdmin u WHERE u.partnerId = :partnerId ";
    	
    	try {
            //Init values
            initService();
            
            if (!all) {
            	query = query.concat("AND u.deleted = 0 ");
            }
        
            query = query.concat("ORDER BY u.firstName ASC");

            users = em.createQuery(query).setParameter("partnerId", partnerId).getResultList();
        } finally {
            closeService();
        }
    	
        return users;
    }
    
    @Override
    public List<UserAdmin> findByPartnerBetweenDate(boolean all, Integer partnerId, Date fromDate, Date toDate) throws GenericPersistenceEAOException {
    	List<UserAdmin> users = new ArrayList<UserAdmin>();
    	String query = "SELECT u FROM UserAdmin u WHERE u.partnerId = :partnerId AND createDate BETWEEN :fromDate AND :toDate ";
    	
    	try {
            //Init values
            initService();
            
            if (!all) {
            	query = query.concat("AND u.deleted = 0 ");
            }
            
            query = query.concat("ORDER BY u.firstName ASC");

            users = em.createQuery(query).setParameter("partnerId", partnerId).setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList();
        } finally {
            closeService();
        }
        
        return users;
    }
   
    @Override
    public List<UserAdmin> findByPartnerQuery(boolean all, Integer partnerId, String query, String searchBy1, int searchBy2, boolean wildCard, boolean isLike, boolean searchDate, Date fromDate, Date toDate) throws GenericPersistenceEAOException {
    	List<UserAdmin> users = new ArrayList<UserAdmin>();

        if(isLike) {
            if(!searchBy1.equals("")) {
                query = query.concat(searchBy1 + "%' ");
            } else if (searchBy2 != -1) {
                query = query.concat(searchBy2 + "%' ");
            }
        }
        
        query = query.concat("AND u.partnerId = :partnerId ");
        
        if (!all) {
        	query = query.concat("AND u.deleted = 0 ");
        }
        
        if(searchDate){
			query = query.concat("AND deleted = 0 AND u.createDate BETWEEN :fromDate AND :toDate ");
		}
        
        query = query.concat("ORDER BY u.firstName ASC");

        try {
            initService();

        	Query queryObject = em.createQuery(query).setParameter("partnerId", partnerId);
             
             if(searchDate){
 		    	queryObject.setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList();
 		    }
 		   
            users = queryObject.getResultList();        	
        } finally {
            closeService();
        }

        return users;
    }
    
    @Override
    public List<UserAdmin> findByGroupID(Integer gid) throws GenericPersistenceEAOException {
        try {

            initService();

            List<UserAdmin> users = em.createQuery("SELECT u FROM UserAdmin u WHERE u.groupId = :gid").
                    setParameter("gid", gid).getResultList();

            return users;

        } finally {
            closeService();
        }
    }

    @Override
    public List<Integer> findByQuery(List<Integer> userPartnerIds, String query, String searchBy1, int searchBy2, boolean wildCard, boolean isLike) throws GenericPersistenceEAOException {
        List<Integer> userIds = new ArrayList<Integer>();

        if(isLike){
            if(!searchBy1.equals("")){
                query = query.concat(searchBy1 + "%' ");
            }else if(searchBy2 != -1){
                query = query.concat(searchBy2 + "%' ");
            }
        }

        query = query.concat("AND u.id IN(:userIds) ");
        
        query = query.concat("ORDER BY u.firstName ASC");

        try {
            initService();

            Session session = (Session) em.getDelegate();
            userIds = session.createQuery(query).setParameterList("userIds", userPartnerIds).list();
        } finally {
            closeService();
        }

        return userIds;
    }

    @Override
    public List<UserAdmin> findByList(List<Integer> userIds) throws GenericPersistenceEAOException {
        List<UserAdmin> users = new ArrayList<UserAdmin>();

        try{
            initService();

            Session session = (Session) em.getDelegate();
            users = session.createQuery("SELECT u FROM UserAdmin u WHERE u.id IN(:userIds)")
                    .setParameterList("userIds", userIds).list();
        }finally{
            closeService();
        }

        return users;
    }
    
    public UserAdmin create2(UserAdmin object) throws GenericPersistenceEAOException {
        initService();

        try {

            em.persist(object);

            return object;

        } catch (Exception e) {
            System.out.println("Error trying to persist entity: " + e.getMessage());
            throw new GenericPersistenceEAOException("Error trying to persist entity: " + e.getMessage(), e);
        } finally {
        	commitService();
        }
    }
    
    public UserAdmin update2(UserAdmin object) throws GenericPersistenceEAOException {
        initService();

        try {

            em.merge(object);

            return object;

        } catch (Exception e) {
            System.out.println("Error trying to update entity: " + e.getMessage());
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        } finally {
        	commitService();
        }
    }    
    
    @Override
    public int updateDeletedUser(Integer userId) throws GenericPersistenceEAOException {
        int updated = 0;

        try {
            initService();

            updated = em.createQuery("UPDATE UserAdmin u SET u.deleted = 1 WHERE u.id = :userId").
                    setParameter("userId", userId).executeUpdate();
        } finally {
            closeService();
        }

        return updated;
    }
    
}

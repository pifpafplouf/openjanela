package openjanela.model.eao.admin.userAdminEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.UserAdmin;

import java.sql.Date;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-03-13
 *          Time: 09:54 AM
 */
public interface UserAdminEAO extends GenericEAO<UserAdmin, Integer> {

	Integer getMaxId() throws GenericPersistenceEAOException;
	
	boolean existById(String email, int partnerId, int userId) throws GenericPersistenceEAOException;
	
	List<UserAdmin> findAllOrderByField(boolean all, String field) throws GenericPersistenceEAOException;
	
    List<UserAdmin> findBetweenDate(boolean all, Date fromDate, Date toDate) throws GenericPersistenceEAOException;

    List<UserAdmin> findByIdList(int userId) throws GenericPersistenceEAOException;

    List<UserAdmin> findByQuery(boolean all, String query, String searchBy1, int searchBy2, boolean wildCard, boolean isLike, boolean searchDate, Date fromDate, Date toDate) throws GenericPersistenceEAOException;

    List<UserAdmin> findByPartner(boolean all, Integer partnerId) throws GenericPersistenceEAOException;

    List<UserAdmin> findByPartnerBetweenDate(boolean all, Integer partnerId, Date fromDate, Date toDate) throws GenericPersistenceEAOException;
       
    List<UserAdmin> findByPartnerQuery(boolean all, Integer partnerId, String query, String searchBy1, int searchBy2, boolean wildCard, boolean isLike, boolean searchDate, Date fromDate, Date toDate) throws GenericPersistenceEAOException;
        
    List<UserAdmin> findByGroupID(Integer gid) throws GenericPersistenceEAOException;
	
	List<Integer> findByQuery(List<Integer> userPartnerIds, String query, String searchBy1, int searchBy2, boolean wildCard, boolean isLike) throws GenericPersistenceEAOException;
	
	List<UserAdmin> findByList(List<Integer> userIds) throws GenericPersistenceEAOException;
	
	UserAdmin create2(UserAdmin object) throws GenericPersistenceEAOException;
	
	UserAdmin update2(UserAdmin object) throws GenericPersistenceEAOException;
	
	int updateDeletedUser(Integer userId) throws GenericPersistenceEAOException;

}

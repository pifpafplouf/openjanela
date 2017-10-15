package openjanela.model.eao.partner.partnerEAO;

import java.sql.Connection;
import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.Partner;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-25-12
 *          Time: 02:27 PM
 */
public interface PartnerEAO extends GenericEAO<Partner, Integer> {

    /**
     * Find all suppliers
     *
     * @return List<Partner>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Partner> findSuppliers() throws GenericPersistenceEAOException;

    /**
     * Find all prospects by campaign id
     *
     * @return List<Partner>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Partner> findProspectsByCampaignId(int campaignId) throws GenericPersistenceEAOException;

    /**
     * Find all prospects by campaign id
     *
     * @return List<Partner>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Partner> findCustomersByCampaignId(int campaignId) throws GenericPersistenceEAOException;

    /**
     * Return Partner Datas
     *
     * @param pid, Partner Identification Id
     * @return Partner
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public Partner findParner(int pid) throws GenericPersistenceEAOException;

    /**
     * Return Dealer Information
     *
     * @param supplierID, Supplier Identification Id
     * @param dealerID,   Dealer Identification Id
     * @return Partner
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public Partner findRemoteDealerById(int supplierID, int dealerID) throws GenericPersistenceEAOException;

    /**
     * Find all suppliers are in list of values Id's
     *
     * @param suppliersId, List of suppliers Id's
     * @return List<Partner>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Partner> findSuppliersForIds(List<Integer> suppliersId) throws GenericPersistenceEAOException;

    
    /**
     * Find all partner by Type
     *
     * @param Connection conn, int type
     * @return List<Partner>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
	public List<Partner> findByType(Connection connection, int type);

	
	/**
     * Find all suppliers by Campaign
     *
     * @param Connection conn, int type
     * @return List<Partner>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
	public List<Partner> findByCampaign(int type) throws GenericPersistenceEAOException;
	
	/**
     * Find all partner by Market List
     *
     * @param Connection conn, int type
     * @return List<Partner>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
	public List<Partner> findByList(int type) throws GenericPersistenceEAOException;
	
	
	/**
     * Find all partner by referring
     *
     * @param Connection conn, int type
     * @return List<Partner>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
	public List<Partner> findByReferring(int type) throws GenericPersistenceEAOException;
	
	

	/**
     * Find all partner by Inqu
     *
     * @param Connection conn, int type
     * @return List<Partner>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
	public List<Partner> findByInquiryType(int type) throws GenericPersistenceEAOException;
	

}

package openjanela.model.eao.orderEntry.orderEAO;

import java.sql.Date;
import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.orderEntry.Order;
import openjanela.model.entities.orderEntry.OrderPK;

/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-06-13
 *          Time: 07:59 PM
 */
public interface OrderEAO extends GenericEAO<Order, OrderPK> {

    /**
     * Find By Order Identification Code
     *
     * @param orderId, Order Identification
     * @return Order
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public Order findByOrderId(Integer orderId) throws GenericPersistenceEAOException;

    /**
     * Update Order Status
     *
     * @param orderId, Order Identification Code
     * @param status,  Status to process
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public void updateOrderStatus(Integer orderId, Integer status) throws GenericPersistenceEAOException;

    /**
     * Find By Partner Identification Code
     *
     * @param partnerId
     * @return List<Order>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     */
    public List<Order> findByPartnerId(Integer partnerId) throws GenericPersistenceEAOException;


    /**
     * Find By Partner Identification Code Between Date
     *
     * @param partnerId
     * @param fromDate
     * @param toDate
     * @return List<Order>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     */
    public List<Order> findByPartnerIdBetweenDate(Integer partnerId, Date fromDate, Date toDate) throws GenericPersistenceEAOException;

    /**
     * Find Quotes By Partner Identification Code
     *
     * @param partnerId
     * @return List<Order>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     */
    public List<Order> findQuotesByPartnerId(Integer partnerId) throws GenericPersistenceEAOException;

    /**
     * Find Quotes By Partner Identification Code Between Date
     *
     * @param partnerId
     * @param fromDate
     * @param toDate
     * @return List<Order>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     */
    public List<Order> findQuotesByPartnerIdBetweenDate(Integer partnerId, Date fromDate, Date toDate) throws GenericPersistenceEAOException;

    /**
     * Find Quotes By Campaign Identification Code
     *
     * @param campaignId
     * @return List<Order>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     */
    public List<Order> findQuotesByCampaignId(Integer campaignId) throws GenericPersistenceEAOException;

    /**
     * Find Quotes By Campaign Identification Code Between Date
     *
     * @param campaignId
     * @param fromDate
     * @param toDate
     * @return List<Order>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     */
    public List<Order> findQuotesByCampaignIdBetweenDate(Integer campaignId, Date fromDate, Date toDate) throws GenericPersistenceEAOException;

    /**
     * Find Orders By Campaign Identification Code
     *
     * @param campaignId
     * @return List<Order>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     */
    public List<Order> findByCampaignId(Integer campaignId) throws GenericPersistenceEAOException;

    /**
     * Find Orders By Campaign Identification Code Between Date
     *
     * @param campaignId
     * @param fromDate
     * @param toDate
     * @return List<Order>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     */
    public List<Order> findByCampaignIdBetweenDate(Integer campaignId, Date fromDate, Date toDate) throws GenericPersistenceEAOException;

    /**
     * Create Order Object Model Remote
     *
     * @param supplierId, Supplier Identification Id
     * @param order,      Order Object Model
     * @return Order, Order Object Model
     * @throws GenericPersistenceEAOException, Exception
     */
    public Order createRemote(Integer supplierId, Order order) throws GenericPersistenceEAOException;

    /**
     * Update Order Object Model Remote
     *
     * @param supplierId, Supplier Identification Id
     * @param order,      Order Object Model
     * @throws GenericPersistenceEAOException, Exception
     */
    public void updateRemote(Integer supplierId, Order order) throws GenericPersistenceEAOException;

    /**
     * Find Order Object Model Remote
     *
     * @param supplierId, Supplier Identification Id
     * @param orderNo,    Order Number
     * @param versionId,  Version Identification
     * @return Order
     * @throws GenericPersistenceEAOException, Exception
     */
    public Order findRemote(Integer supplierId, Integer orderNo, Integer versionId) throws GenericPersistenceEAOException;

    /**
     * Find Order Object Model Remote
     *
     * @param supplierId, Supplier Identification Id
     * @param codeEDI,    Confirmation Code EDI
     * @return Order
     * @throws GenericPersistenceEAOException, Exception
     */
    public Order findRemote(Integer supplierId, String codeEDI) throws GenericPersistenceEAOException;

}

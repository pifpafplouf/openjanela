package openjanela.model.eao.orderEntry.orderEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.orderEntry.Order;
import openjanela.model.entities.orderEntry.OrderPK;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import javax.persistence.FlushModeType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-06-13
 *          Time: 07:55 PM
 */
public class OrderPersistenceEAO extends GenericPersistenceEAO<Order, OrderPK> implements OrderEAO {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(OrderPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Partner Persistence Default Constructor
     */
    public OrderPersistenceEAO() {
        this.partnersEAO = new PartnersPersistenceEAO();
    }

    /**
     * This method init a remote persistence service
     *
     * @param supplierId, Supplier Identification Id
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void initRemoteService(Integer supplierId) throws GenericPersistenceEAOException {


        try {

            //Search supplier remote values
            Partners supplier = partnersEAO.findById(supplierId);

            //Getting persistence service
            em = PersistenceManagementServiceRemoteFactory.getEntityManager(supplier);

            //Added to prevent Flushing
            em.setFlushMode(FlushModeType.AUTO);

            PersistenceManagementServiceRemoteFactory.beginTransaction();

        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }

    }

    /**
     * This method commit a remote persistence service
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void commitRemoteService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceRemoteFactory.commit(true);
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    /**
     * This method close a remote session service from entity access object
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void closeRemoteService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceRemoteFactory.close();
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }


    @Override
    public Order findByOrderId(Integer orderId) throws GenericPersistenceEAOException {
        try {

            initService();

            List<Order> orders = em.createQuery("select o from Order o where o.id.id = :orderId").
                    setParameter("orderId", orderId).getResultList();

            if (orders != null && orders.size() > 0) {
                return orders.get(0);
            }

            return null;

        } finally {
            closeService();
        }
    }

    @Override
    public void updateOrderStatus(Integer orderId, Integer status) throws GenericPersistenceEAOException {

        try {

            initService();

            em.createQuery("update Order o set o.statusId = :status, o.orderStatusId = :status where o.id.id = :orderId").
                    setParameter("status", status).setParameter("orderId", orderId).executeUpdate();

        } finally {
            closeService();
        }
    }
    
    @Override
	public List<Order> findByPartnerId(Integer partnerId) throws GenericPersistenceEAOException {
		List<Order> orders = null;
		
		try {
			initService();

			orders = em.createQuery("SELECT o FROM Order o WHERE o.orderStatusId <> 1 AND o.partnerId = :partnerId")
						.setParameter("partnerId", partnerId).getResultList();
		} finally {
			closeService();
	    }
		
		return orders;
	}

	@Override
	public List<Order> findByPartnerIdBetweenDate(Integer partnerId, Date fromDate, Date toDate) throws GenericPersistenceEAOException {
		List<Order> orders = null;
		
		try {
			initService();

			orders = em.createQuery("SELECT o FROM Order o WHERE o.orderStatusId <> 1 AND o.partnerId = :partnerId AND o.dateEntered BETWEEN :fromDate AND :toDate").
	                    setParameter("partnerId", partnerId).setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList();
		} finally {
			closeService();
	    }
		
		return orders;
	}

	@Override
	public List<Order> findQuotesByPartnerId(Integer partnerId) throws GenericPersistenceEAOException {
		List<Order> orders = null;
		
		try {
			initService();

			orders = em.createQuery("SELECT o FROM Order o WHERE o.orderStatusId = 1 AND o.partnerId = :partnerId")
						.setParameter("partnerId", partnerId).getResultList();
		} finally {
			closeService();
	    }
		
		return orders;
	}
	
	@Override
	public List<Order> findQuotesByPartnerIdBetweenDate(Integer partnerId, Date fromDate, Date toDate) throws GenericPersistenceEAOException {
		List<Order> orders = null;
		
		try {
			initService();

			orders = em.createQuery("SELECT o FROM Order o WHERE o.orderStatusId = 1 AND o.partnerId = :partnerId AND o.dateEntered BETWEEN :fromDate AND :toDate").
	                    setParameter("partnerId", partnerId).setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList();
		} finally {
			closeService();
	    }
		
		return orders;
	}

	@Override
	public List<Order> findQuotesByCampaignId(Integer campaignId) throws GenericPersistenceEAOException {
		List<Order> orders = null;
		
		try {
			initService();

			orders = em.createQuery("SELECT o FROM Order o WHERE o.orderStatusId = 1 AND o.campaign = :campaignId")
						.setParameter("campaignId", campaignId).getResultList();
		} finally {
			closeService();
	    }
		
		return orders;
	}
	
	@Override
	public List<Order> findQuotesByCampaignIdBetweenDate(Integer campaignId, Date fromDate, Date toDate) throws GenericPersistenceEAOException {
		List<Order> orders = null;
		
		try {
			initService();

			orders = em.createQuery("SELECT o FROM Order o WHERE o.orderStatusId = 1 AND o.campaign = :campaignId AND o.dateEntered BETWEEN :fromDate AND :toDate").
	                    setParameter("campaignId", campaignId).setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList();
		} finally {
			closeService();
	    }
		
		return orders;
	}
	
	@Override
	public List<Order> findByCampaignId(Integer campaignId) throws GenericPersistenceEAOException {
		List<Order> orders = null;
		
		try {
			initService();

			orders = em.createQuery("SELECT o FROM Order o WHERE o.orderStatusId <> 1 AND o.campaign = :campaignId")
						.setParameter("campaignId", campaignId).getResultList();
		} finally {
			closeService();
	    }
		
		return orders;
	}

	@Override
	public List<Order> findByCampaignIdBetweenDate(Integer campaignId, Date fromDate, Date toDate) throws GenericPersistenceEAOException {
		List<Order> orders = null;
		
		try {
			initService();

			orders = em.createQuery("SELECT o FROM Order o WHERE o.orderStatusId <> 1 AND o.campaign = :campaignId AND o.dateEntered BETWEEN :fromDate AND :toDate").
	                    setParameter("campaignId", campaignId).setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList();
		} finally {
			closeService();
	    }
		
		return orders;
	}

    @Override
    public Order createRemote(Integer supplierId, Order order) throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            em.persist(order);

            return order;

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public void updateRemote(Integer supplierId, Order order) throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            em.merge(order);

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public Order findRemote(Integer supplierId, Integer orderNo, Integer versionId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            Order order = (Order)em.createQuery("select o from Order o where o.id.orderNo = :orderNo and o.id.version = :versionNo").
                    setParameter("orderNo", orderNo).
                    setParameter("versionNo", versionId).
                    getSingleResult();

            return order;

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public Order findRemote(Integer supplierId, String codeEDI) throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            final String param_code_EDI = codeEDI;

            final List<Order> orders = new ArrayList<Order>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select o.* from orders o where o.code_EDI = ? ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setString(1, param_code_EDI);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

                        OrderPK orderPK = new OrderPK();
                        orderPK.setId(rs.getInt("id"));
                        orderPK.setType(rs.getInt("type"));
                        orderPK.setPrefix(rs.getString("prefix"));
                        orderPK.setOrderNo(rs.getInt("order_no"));
                        orderPK.setVersion(rs.getInt("version"));

                        Order order = new Order();
                        order.setId(orderPK);

                        order.setDateEntered(rs.getDate("dateentered"));
                        order.setDateRequired(rs.getDate("daterequired"));
                        order.setPono(rs.getString("pono"));
                        order.setOriginalQuoteNo(rs.getInt("originalquoteno"));
                        order.setPartnerId(rs.getInt("partnerid"));
                        order.setContactId(rs.getInt("contactid"));
                        order.setNotes(rs.getString("notes"));
                        order.setSalesRepId(rs.getInt("salesrepid"));
                        order.setPaymentId(rs.getInt("paymentid"));
                        order.setReference(rs.getString("reference"));
                        order.setOrderStatusId(rs.getInt("order_status_id"));
                        order.setStatusId(rs.getInt("statusid"));

                        orders.add(order);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return orders.get(0);

        } finally {
            closeRemoteService();
        }
    }


}

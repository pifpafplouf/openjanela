package openjanela.model.eao.orderItemsEAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.orderEntry.OrderItems;
import openjanela.model.entities.orderEntry.OrderItemsPK;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import javax.persistence.FlushModeType;

public class OrderItemsPersistenceEAO extends GenericPersistenceEAO<OrderItems, Integer> implements OrderItemsEAO {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(OrderItemsPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Partner Persistence Default Constructor
     */
    public OrderItemsPersistenceEAO() {
        this.partnersEAO = new PartnersPersistenceEAO();
    }

    /**
     * This method init a remote persistence service
     *
     * @param supplierId, Supplier Identification Id
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
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
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
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
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
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
    public List<OrderItems> findByOrderId(int orderId) throws GenericPersistenceEAOException {

        try {

            // Init service
            initService();

            // String query builder
            String query = "Select o from OrderItems o where o.id.orderId = :orderId and o.deleted = false";

            // Executing query and retrieve collection
            List<OrderItems> items = em.createQuery(query).setParameter("orderId", orderId).getResultList();

            return items;

        } finally {
            closeService();
        }
    }

    @Override
    public OrderItems findByOrderId(int orderId, int itemId, int versionId) throws PersistenceClassNotFoundException,
            GenericPersistenceEAOException {

        try {

            // Init service
            initService();

            // String query builder
            String query = "Select o from OrderItems o where o.id.orderId = :orderId and o.id.itemId = :itemId and " +
                    "o.id.versionId = :versionId and o.deleted = false";

            // Executing query and retrieve collection
            List<OrderItems> orders = em.createQuery(query).setParameter("orderId", orderId).setParameter("itemId", itemId)
                    .setParameter("versionId", versionId).getResultList();

            if (orders.size() <= 0)
                throw new PersistenceClassNotFoundException(orderId);

            if (orders.size() > 1)
                throw new PersistenceClassNotFoundException("Orders Item found: " + orders.size());

            return orders.get(0);

        } finally {
            closeService();
        }
    }

    @Override
    public OrderItems findByScanOrderId(int orderId, int itemId, int versionId) throws PersistenceClassNotFoundException,
            GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final int param_order_id = orderId;
            final int param_item_id = itemId;
            final int param_version_id = versionId;

            final List<OrderItems> orderItems = new ArrayList<OrderItems>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select o.id, o.order_id, o.item_id, o.version_id, o.description, o.width, o.width_i, o.height, ");
                    query.append("o.height_i, o.image, o.series_id from order_items o where o.order_id = ? and o.item_id = ? and o.version_id = ? ");
                    query.append("and o.deleted = 0");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);
                    pstmt.setInt(2, param_item_id);
                    pstmt.setInt(3, param_version_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        OrderItemsPK orderItemsPK = new OrderItemsPK();
                        orderItemsPK.setId(rs.getInt("id"));
                        orderItemsPK.setOrderId(rs.getInt("order_id"));
                        orderItemsPK.setItemId(rs.getInt("item_id"));
                        orderItemsPK.setVersionId(rs.getInt("version_id"));

                        OrderItems orderItem = new OrderItems();
                        orderItem.setId(orderItemsPK);
                        orderItem.setDescription(rs.getString("description"));
                        orderItem.setWidth(rs.getInt("width"));
                        orderItem.setWidthI(rs.getInt("width_i"));
                        orderItem.setHeight(rs.getInt("height"));
                        orderItem.setHeightI(rs.getInt("height_i"));
                        orderItem.setImage(rs.getBytes("image"));
                        orderItem.setSeriesId(rs.getInt("series_id"));
                        
                        orderItems.add(orderItem);
                    }

                    rs.close();
                    pstmt.close();
                }
            });

            if (orderItems.size() <= 0)
                throw new PersistenceClassNotFoundException(orderId);

            if (orderItems.size() > 1)
                throw new PersistenceClassNotFoundException("Orders Item found: " + orderItems.size());

            return orderItems.get(0);

        } finally {
            closeService();
        }
    }

    @Override
    public Integer getRemoteMaxID(Integer supplierId) throws PersistenceClassNotFoundException, GenericPersistenceEAOException {

        try {

            //Init Service
            initRemoteService(supplierId);

            final int[] maxID = new int[1];

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select max(id) from order_items");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        maxID[0] = rs.getInt(1);
                    }

                    rs.close();
                    pstmt.close();
                }
            });

            return maxID[0];

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public void createRemote(Integer supplierId, OrderItems orderItems) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initRemoteService(supplierId);

            em.persist(orderItems);

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public void updateRemote(Integer supplierId, OrderItems orderItems) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initRemoteService(supplierId);

            em.merge(orderItems);

        } finally {
            closeRemoteService();
        }
    }

}

package openjanela.model.eao.orderItemsEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.orderEntry.OrderItems;

import java.util.List;

public interface OrderItemsEAO extends GenericEAO<OrderItems, Integer> {

    /**
     * Return a list of items for an order
     *
     * @param orderId, Order Identification Id
     * @return List<OrderItems>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     */
    public List<OrderItems> findByOrderId(int orderId) throws GenericPersistenceEAOException;

    /**
     * Find Order Items entity object by Order Identification and Item
     * Identification
     *
     * @param orderId   , Order Identification
     * @param itemId    , Item Identification
     * @param versionId , Version identification
     * @return OrderItems
     * @throws openjanela.model.eao.genericEAO.PersistenceClassNotFoundException , Exception
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException    , Exception
     */
    public OrderItems findByOrderId(int orderId, int itemId, int versionId) throws PersistenceClassNotFoundException,
            GenericPersistenceEAOException;

    /**
     * Find Order Items entity object by Order Identification and Item
     * Identification
     *
     * @param orderId,   Order Identification Id
     * @param itemId,    Item Identification Id
     * @param versionId, Version Identification Id
     * @return OrderItems
     * @throws PersistenceClassNotFoundException, Exception
     * @throws GenericPersistenceEAOException,    Exception
     */
    public OrderItems findByScanOrderId(int orderId, int itemId, int versionId) throws PersistenceClassNotFoundException,
            GenericPersistenceEAOException;

    /**
     * Return Remote max Identification ID
     *
     * @param supplierId, Supplier Identification Id
     * @return Integer
     * @throws GenericPersistenceEAOException, Exception
     */
    public Integer getRemoteMaxID(Integer supplierId) throws GenericPersistenceEAOException;

    /**
     * Create Remote Order Items
     *
     * @param supplierId, Supplier Identification Id
     * @param orderItems, OrderItems
     * @throws GenericPersistenceEAOException, Exception
     */
    public void createRemote(Integer supplierId, OrderItems orderItems) throws GenericPersistenceEAOException;

    /**
     * Update Remote Order Items
     *
     * @param supplierId, Supplier Identification Id
     * @param orderItems, OrderItems
     * @throws GenericPersistenceEAOException, Exception
     */
    public void updateRemote(Integer supplierId, OrderItems orderItems) throws GenericPersistenceEAOException;

}

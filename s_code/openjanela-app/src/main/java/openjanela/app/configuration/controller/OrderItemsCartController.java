package openjanela.app.configuration.controller;

import Presentation.ItemFrame;
import dto.DTOTransformationError;
import dto.OrderItemsCartDTO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.eao.orderEntry.OrderItemsCartEAO.OrderItemsCartEAO;
import openjanela.model.eao.orderEntry.OrderItemsCartEAO.OrderItemsCartPersistenceEAO;
import openjanela.model.entities.design.DesignGlassEntityObject;
import openjanela.model.entities.design.DesignOptionEntityObject;
import openjanela.model.entities.orderEntry.OrderItemsCart;
import openjanela.model.entities.orderEntry.OrderItemsCartPK;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 * <p/>
 * This class manage all transactions necessary for executions OrderItemsCart
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-27-13
 *          Time: 12:03 AM
 */
public class OrderItemsCartController extends BaseController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(JobItemModelController.class);

    //Data Access Object
    private OrderItemsCartEAO orderItemsCartEAO;

    //ItemFrame acess controller
    private ItemFrame myFrame;

    //Order Items Cart
    private OrderItemsCart orderItemsCart;

    //Controller references
    private JobItemModelController jobItemController;

    /**
     * Call OrderItemsCart Controller
     */
    public OrderItemsCartController() {

        //Init Data Access Objects
        orderItemsCartEAO = new OrderItemsCartPersistenceEAO();

        //Init Job Item Controller
        this.jobItemController = new JobItemModelController();
    }

    /**
     * Call OrderItemsCart Controller
     *
     * @param myFrame, ItemFrame
     */
    public OrderItemsCartController(ItemFrame myFrame) {

        //Call main constructor
        this();

        //Access Frame controller
        this.myFrame = myFrame;

        //Init controller
        this.jobItemController = new JobItemModelController(myFrame);
    }

    /**
     * Open Order Items Cart model and setting values to UI
     *
     * @throws Exception, Exception
     */
    public void openOrderItemsCart() throws Exception {

        try {

            //Order Items cart primary key for construction
            OrderItemsCartPK orderItemsCartPK = new OrderItemsCartPK(ItemFrame.userID, ItemFrame.jobID,
                    ItemFrame.itemID, ItemFrame.versionID);

            //Find and return OrderItemsCart
            this.orderItemsCart = orderItemsCartEAO.findById(orderItemsCartPK);

            //Transform orderItemsCart to JobItem UI values
            OrderItemsCartDTO.getOpenOrderItemsCart(this.myFrame.jobItem, orderItemsCart);

        } catch (PersistenceClassNotFoundException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * Create Order Items Cart
     *
     * @throws Exception, Exception
     */

    public void createOrderItemsCart() throws Exception {

        try {

            //Creating JobItem model design
            jobItemController.createJobItemDesign(this.myFrame.jobItem);

            //Get order items cart
            OrderItemsCart orderItemsCart = OrderItemsCartDTO.getOrderItemsCartEntity(this.myFrame.jobItem);

            orderItemsCartEAO.create(orderItemsCart);

        } catch (DTOTransformationError e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * Update Order Items Cart
     *
     * @throws Exception, Exception
     */
    public void updateOrderItemsCart() throws Exception {

        try {

            //Update JobItem model design
            jobItemController.updateJobItemDesign(this.myFrame.jobItem);

            //Get order items cart
            OrderItemsCart orderItemsCart = OrderItemsCartDTO.getOrderItemsCartEntity(this.myFrame.jobItem);

            orderItemsCartEAO.update(orderItemsCart);

        } catch (DTOTransformationError e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * Copy Order Items Cart to new record with item and version number
     *
     * @throws Exception, Exception
     */
    public void copyOrderItemsCart(int fromOrderItemsCartId, int fromOrderId, int fromItemNo, int fromVersionId,
                                   int toOrderItemsCartId, int toOrderId, int toItemNo, int toVersionId, boolean active)
            throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("Copy order items cart with parameters: [fromOrderItemsCartId]: " + fromOrderItemsCartId +
                    ", [fromOrderId]: " + fromOrderId + ", [fromItemNo]: " + fromOrderId + ", [fromItemNo]: " + fromItemNo +
                    ", [fromVersionId]: " + fromVersionId + ", [toOrderItemCartId]: " + toOrderItemsCartId + ", [toOrderId]: " +
                    toOrderId + ", [toItemNo]: " + toItemNo + ", [toVersionId]: " + toVersionId);
        }

        try {

            //Copy JobItem model design
            jobItemController.copyJobItemDesign(fromOrderId, fromItemNo, fromVersionId, toOrderId, toItemNo, toVersionId);

            //Search order items cart for his primary key
            OrderItemsCartPK orderItemsCartPK = new OrderItemsCartPK(fromOrderItemsCartId, fromOrderId, fromItemNo, fromVersionId);
            OrderItemsCart orderItemsCart = orderItemsCartEAO.findById(orderItemsCartPK);

            //Copy Order items cart
            OrderItemsCartPK newOrderItemsCartPK = new OrderItemsCartPK(toOrderItemsCartId, toOrderId, toItemNo, toVersionId);
            OrderItemsCart newOrderItemsCart = new OrderItemsCart();
            BeanUtils.copyProperties(newOrderItemsCart, orderItemsCart);

            //Setting active
            newOrderItemsCart.setActive(active);

            newOrderItemsCart.setId(newOrderItemsCartPK);

            orderItemsCartEAO.create(newOrderItemsCart);

        } catch (PersistenceClassNotFoundException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * This method remove a OrderItemsCart object model
     *
     * @param orderItemsCartId, Order items cart identification Id
     * @param orderId,          Order items identification Id
     * @param itemNo,           Item number identification
     * @param versionId,        Version number identification
     * @throws Exception, Exception
     */
    public void removeOrderItemsCart(int orderItemsCartId, int orderId, int itemNo, int versionId, int typeId) throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("Remove order items cart with parameters: [orderItemsCartId]: " + orderItemsCartId +
                    ", [orderId]: " + orderId + ", [itemNo]: " + itemNo + ", [versionId]: " + versionId);
        }

        try {

            OrderItemsCartEAO orderItemsCartEAO = new OrderItemsCartPersistenceEAO();

            //************************************************************************
            //Remove job item model if is not a part Item.
            //************************************************************************
            if (typeId < 100) {
                jobItemController.removeJobItemDesign(orderId, itemNo, versionId);
            }

            //Remove order items cart with primary key
            OrderItemsCartPK orderItemsCartPK = new OrderItemsCartPK(orderItemsCartId, orderId, itemNo, versionId);
            orderItemsCartEAO.remove(orderItemsCartPK);

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }

    }

    /**
     * Return Order Items Cart
     *
     * @return OrderItemsCart
     */
    public OrderItemsCart getOrderItemsCart() {
        return orderItemsCart;
    }

    /**
     * Return Design Options for Item
     *
     * @param orderId,   Order Identification Id
     * @param itemId,    Item Identification Id
     * @param versionId, Version Identification Id
     * @return List
     * @throws Exception, Exception
     */
    public List<DesignOptionEntityObject> getDesignOptions(int orderId, int itemId, int versionId) throws Exception {
        return jobItemController.getDesignOptions(orderId, itemId, versionId);
    }

    /**
     * Return Glass for Item
     *
     * @param orderId,   Order Identification Id
     * @param itemId,    Item Identification Id
     * @param versionId, Version Identification Id
     * @return List
     * @throws Exception, Exception
     */
    public List<DesignGlassEntityObject> getDesignGlass(int orderId, int itemId, int versionId) throws Exception {
        return jobItemController.getDesignGlass(orderId, itemId, versionId);
    }
}

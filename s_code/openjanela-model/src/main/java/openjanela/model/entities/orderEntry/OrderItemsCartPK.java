package openjanela.model.entities.orderEntry;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Copyright (c) 2011-2013, OpenJanela. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-31-12
 *          Time: 09:21 PM
 */
@Embeddable
public class OrderItemsCartPK implements Serializable {

    @Column(name = "id", nullable = false)
    public Integer id;

    @Column(name = "order_id", nullable = false)
    public Integer orderId;

    @Column(name = "item_id", nullable = false)
    public Integer itemId;

    @Column(name = "version_id", nullable = false)
    public Integer versionId;

    /**
     * Order Items Cart PK Defalt constructor
     */
    public OrderItemsCartPK() {
        this.id = 0;
        this.orderId = 0;
        this.itemId = 0;
        this.versionId = 0;
    }

    /**
     * Order Items Cart PK Default Constructor
     *
     * @param id        , Identification Id
     * @param orderId   , Order Identification Id
     * @param itemId    , Items Identification Id
     * @param versionId , version_id Identification Id
     */
    public OrderItemsCartPK(int id, int orderId, int itemId, int versionId) {
        this.id = id;
        this.orderId = orderId;
        this.itemId = itemId;
        this.versionId = versionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
}

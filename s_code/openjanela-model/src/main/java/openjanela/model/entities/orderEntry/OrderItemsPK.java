package openjanela.model.entities.orderEntry;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-06-13
 *          Time: 10:53 AM
 */
@Embeddable
public class OrderItemsPK implements Serializable {

    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "item_id", nullable = false)
    private Integer itemId;

    @Column(name = "version_id", nullable = false)
    private Integer versionId;

    /**
     * Order Items Primary Key Constructor
     */
    public OrderItemsPK() {
        this.id = 0;
        this.orderId = 0;
        this.itemId = 0;
        this.versionId = 0;
    }

    /**
     * Order Items Primary Key Constructor
     *
     * @param id,        Identification Id
     * @param orderId,   Order Identification Id
     * @param itemId,    Item Identification Id
     * @param versionId, Version Identification Id
     */
    public OrderItemsPK(Integer id, Integer orderId, Integer itemId, Integer versionId) {
        this.id = id;
        this.orderId = orderId;
        this.itemId = itemId;
        this.versionId = versionId;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

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

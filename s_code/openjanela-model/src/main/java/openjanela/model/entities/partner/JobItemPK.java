package openjanela.model.entities.partner;

import org.hibernate.type.IntegerType;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 12-17-12
 * Time: 09:56 PM
 */
@Embeddable
public class JobItemPK implements Serializable {

    @Column(name = "N_ORDER_ID", nullable = false)
    public Integer orderId;

    @Column(name = "N_ITEM_ID", nullable = false)
    public Integer itemId;

    @Column(name = "N_VERSION_ID", nullable = false)
    public Integer versionId;

    /**
     * Job Item PK Constructor
     */
    public JobItemPK() {
    }

    /**
     * Job Item PK Constructor
     *
     * @param orderId,   Identification Id
     * @param itemId,    Order Identification Id
     * @param versionId, Version Identification Id
     */
    public JobItemPK(Integer orderId, Integer itemId, Integer versionId) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.versionId = versionId;
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

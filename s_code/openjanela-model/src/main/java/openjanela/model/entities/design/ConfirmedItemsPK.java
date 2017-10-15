/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openjanela.model.entities.design;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 05-19-13
 *          Time: 07:21 PM
 */
@Embeddable
public class ConfirmedItemsPK implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id = 0;

    @Column(name = "orderid", nullable = false)
    private int orderId = 0;

    @Column(name = "itemno", nullable = false)
    private int itemNo = 0;

    @Column(name = "versionid", nullable = false)
    private int versionId = 0;

    @Column(name = "qtyno", nullable = false)
    private int qtyNo = 0;

    @Column(name = "ofqty", nullable = false)
    private int ofQty = 0;


    /**
     * Default Constructor
     */
    public ConfirmedItemsPK() {
    }

    /**
     * Confirmed Items Constructor
     *
     * @param id,        Item id
     * @param orderId,   Order Code
     * @param itemNo,    Item Number
     * @param qtyNo,     Quantity Number
     * @param ofQty,     Total Quantity
     * @param versionId, Version Code
     */
    public ConfirmedItemsPK(int id, int orderId, int itemNo, int qtyNo, int ofQty, int versionId) {
        this.id = id;
        this.orderId = orderId;
        this.itemNo = itemNo;
        this.qtyNo = qtyNo;
        this.ofQty = ofQty;
        this.versionId = versionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public int getQtyNo() {
        return qtyNo;
    }

    public void setQtyNo(int qtyNo) {
        this.qtyNo = qtyNo;
    }

    public int getOfQty() {
        return ofQty;
    }

    public void setOfQty(int ofQty) {
        this.ofQty = ofQty;
    }
}

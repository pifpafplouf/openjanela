/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openjanela.model.entities.design;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 05-19-13
 *          Time: 07:21 PM
 */
@Entity
@Table(name = "confirmed_items")
public class ConfirmedItems implements Serializable {

    @EmbeddedId
    protected ConfirmedItemsPK confirmedItemsPK;

    @Column(name = "bcid", nullable = false)
    private String barcode = "";

    @Column(name = "prodstartdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date prodStartDate = new Date(System.currentTimeMillis());

    @Column(name = "prodenddate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date prodEndDate = new Date(System.currentTimeMillis());

    @Column(name = "placepodate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date placePODate = new Date(System.currentTimeMillis());

    @Column(name = "shippingdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippingDate = new Date(System.currentTimeMillis());

    @Column(name = "deliverydate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate = new Date(System.currentTimeMillis());

    @Column(name = "lastconfirmdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastConfirmDate = new Date(System.currentTimeMillis());

    @Column(name = "measurestartdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date measureStartDate = new Date(System.currentTimeMillis());

    @Column(name = "measureenddate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date measureEndDate = new Date(System.currentTimeMillis());

    @Column(name = "installationstartdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date installationStartDate = new Date(System.currentTimeMillis());

    @Column(name = "installationenddate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date installationEndDate = new Date(System.currentTimeMillis());

    @Column(name = "lastpermitsdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPermitsDate =  new Date(System.currentTimeMillis());

    @Column(name = "batched", nullable = true)
    private Boolean batched = false;

    @Column(name = "batchid", nullable = true)
    private Integer batchId = 0;

    @Column(name = "shift", nullable = true)
    private Integer shift = 0;

    @Column(name = "invoiceno", nullable = true)
    private Integer invoiceno = 0;

    @Column(name = "invoicelineno", nullable = true)
    private Integer invoiceLineNo = 0;

    @Column(name = "shipdocno", nullable = true)
    private Integer shipDocNo = 0;

    @Column(name = "bomid", nullable = false)
    private Integer bomId = 0;

    @Column(name = "item_shipped_id", nullable = false)
    private Integer itemShippedId;

    @Column(name = "reject_code_id", nullable = false)
    private Integer rejectCodeId;

    @Column(name = "is_repair", nullable = false)
    private boolean repair = false;

    @Column(name = "rush", nullable = false)
    private boolean rush = false;

    @Transient
    private Integer jobItemId = 0;

    @Transient
    private Integer prodLineId = 0;

    @Transient
    private Integer stationId = 0;

    @Transient
    private Integer assemblyId = 0;

    @Transient
    private Integer partId = 0;

    @Transient
    private Integer typeId = 0;

    @Transient
    private Integer stage = 0;

    @Transient
    private Integer orderNo;

    @Transient
    private String itemDescription;

    @Transient
    private int quantity;

    @Transient
    private int width;

    @Transient
    private int width_i;

    @Transient
    private int height;

    @Transient
    private int height_i;

    @Transient
    private int size;

    @Transient
    private int size_i;

    @Transient
    private int supplier_id;

    @Transient
    private String description;

    @Transient
    private String reference;

    @Transient
    private String stockCode;

    @Transient
    private String notes;

    @Transient
    private int partType;

    @Transient
    private int priceMeasure;

    @Transient
    private int priceuom;

    @Transient
    private boolean customPart;

    @Transient
    private int custom_leadtime;

    @Transient
    private boolean inspected;

    @Transient
    private boolean shipped;

    @Transient
    private boolean invoiced;

    @Transient
    private boolean delivered;

    public ConfirmedItems() {
    }

    public ConfirmedItems(ConfirmedItemsPK confirmedItemsPK, String barcode, Date prodStartDate, Date prodEndDate,
                          Date placePODate, Date shippingDate, Date deliveryDate, Date lastConfirmDate, Date measureStartDate,
                          Date measureEndDate, Date installationStartDate, Date installationEndDate, Date lastPermitsDate,
                          Boolean batched, Integer batchId, Integer shift, Integer invoiceno, Integer invoiceLineNo,
                          Integer shipDocNo, Integer bomId, Integer itemShippedId, Integer rejectCodeId, boolean repair,
                          boolean rush) {

        this.confirmedItemsPK = confirmedItemsPK;
        this.barcode = barcode;
        this.prodStartDate = prodStartDate;
        this.prodEndDate = prodEndDate;
        this.placePODate = placePODate;
        this.shippingDate = shippingDate;
        this.deliveryDate = deliveryDate;
        this.lastConfirmDate = lastConfirmDate;
        this.measureStartDate = measureStartDate;
        this.measureEndDate = measureEndDate;
        this.installationStartDate = installationStartDate;
        this.installationEndDate = installationEndDate;
        this.lastPermitsDate = lastPermitsDate;
        this.batched = batched;
        this.batchId = batchId;
        this.shift = shift;
        this.invoiceno = invoiceno;
        this.invoiceLineNo = invoiceLineNo;
        this.shipDocNo = shipDocNo;
        this.bomId = bomId;
        this.itemShippedId = itemShippedId;
        this.rejectCodeId = rejectCodeId;
        this.repair = repair;
        this.rush = rush;
    }

    //*****************************************<Getters & Setters>******************************************************

    public ConfirmedItemsPK getConfirmedItemsPK() {
        return confirmedItemsPK;
    }

    public void setConfirmedItemsPK(ConfirmedItemsPK confirmedItemsPK) {
        this.confirmedItemsPK = confirmedItemsPK;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getProdStartDate() {
        return prodStartDate;
    }

    public void setProdStartDate(Date prodStartDate) {
        this.prodStartDate = prodStartDate;
    }

    public Date getProdEndDate() {
        return prodEndDate;
    }

    public void setProdEndDate(Date prodEndDate) {
        this.prodEndDate = prodEndDate;
    }

    public Date getPlacePODate() {
        return placePODate;
    }

    public void setPlacePODate(Date placePODate) {
        this.placePODate = placePODate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getLastConfirmDate() {
        return lastConfirmDate;
    }

    public void setLastConfirmDate(Date lastConfirmDate) {
        this.lastConfirmDate = lastConfirmDate;
    }

    public Date getMeasureStartDate() {
        return measureStartDate;
    }

    public void setMeasureStartDate(Date measureStartDate) {
        this.measureStartDate = measureStartDate;
    }

    public Date getMeasureEndDate() {
        return measureEndDate;
    }

    public void setMeasureEndDate(Date measureEndDate) {
        this.measureEndDate = measureEndDate;
    }

    public Date getInstallationStartDate() {
        return installationStartDate;
    }

    public void setInstallationStartDate(Date installationStartDate) {
        this.installationStartDate = installationStartDate;
    }

    public Date getInstallationEndDate() {
        return installationEndDate;
    }

    public void setInstallationEndDate(Date installationEndDate) {
        this.installationEndDate = installationEndDate;
    }

    public Date getLastPermitsDate() {
        return lastPermitsDate;
    }

    public void setLastPermitsDate(Date lastPermitsDate) {
        this.lastPermitsDate = lastPermitsDate;
    }

    public Boolean getBatched() {
        return batched;
    }

    public void setBatched(Boolean batched) {
        this.batched = batched;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    public Integer getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(Integer invoiceno) {
        this.invoiceno = invoiceno;
    }

    public Integer getInvoiceLineNo() {
        return invoiceLineNo;
    }

    public void setInvoiceLineNo(Integer invoiceLineNo) {
        this.invoiceLineNo = invoiceLineNo;
    }

    public Integer getShipDocNo() {
        return shipDocNo;
    }

    public void setShipDocNo(Integer shipDocNo) {
        this.shipDocNo = shipDocNo;
    }

    public Integer getBomId() {
        return bomId;
    }

    public void setBomId(Integer bomId) {
        this.bomId = bomId;
    }

    public Integer getItemShippedId() {
        return itemShippedId;
    }

    public void setItemShippedId(Integer itemShippedId) {
        this.itemShippedId = itemShippedId;
    }

    public boolean isRepair() {
        return repair;
    }

    public void setRepair(boolean repair) {
        this.repair = repair;
    }

    public boolean isRush() {
        return rush;
    }

    public void setRush(boolean rush) {
        this.rush = rush;
    }

    public Integer getJobItemId() {
        return jobItemId;
    }

    public void setJobItemId(Integer jobItemId) {
        this.jobItemId = jobItemId;
    }

    public Integer getProdLineId() {
        return prodLineId;
    }

    public void setProdLineId(Integer prodLineId) {
        this.prodLineId = prodLineId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(Integer assemblyId) {
        this.assemblyId = assemblyId;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public Integer getRejectCodeId() {
        return rejectCodeId;
    }

    public void setRejectCodeId(Integer rejectCodeId) {
        this.rejectCodeId = rejectCodeId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth_i() {
        return width_i;
    }

    public void setWidth_i(int width_i) {
        this.width_i = width_i;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight_i() {
        return height_i;
    }

    public void setHeight_i(int height_i) {
        this.height_i = height_i;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize_i() {
        return size_i;
    }

    public void setSize_i(int size_i) {
        this.size_i = size_i;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getPartType() {
        return partType;
    }

    public void setPartType(int partType) {
        this.partType = partType;
    }

    public int getPriceMeasure() {
        return priceMeasure;
    }

    public void setPriceMeasure(int priceMeasure) {
        this.priceMeasure = priceMeasure;
    }

    public int getPriceuom() {
        return priceuom;
    }

    public void setPriceuom(int priceuom) {
        this.priceuom = priceuom;
    }

    public boolean isCustomPart() {
        return customPart;
    }

    public void setCustomPart(boolean customPart) {
        this.customPart = customPart;
    }

    public int getCustom_leadtime() {
        return custom_leadtime;
    }

    public void setCustom_leadtime(int custom_leadtime) {
        this.custom_leadtime = custom_leadtime;
    }

    public boolean isInspected() {
        return inspected;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public boolean isInvoiced() {
        return invoiced;
    }

    public void setInvoiced(boolean invoiced) {
        this.invoiced = invoiced;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}

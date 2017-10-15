package openjanela.model.entities.design;

import openjanela.model.entities.partner.JobItem;

import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-03-14
 *          Time: 11:49 PM
 */
public class PartDelearConfigured implements Serializable {

    /**
     * Part Identification Id
     */
    private Integer partId = 0;
    /**
     * Supplier Identification Id
     */
    private Integer supplierId = 0;
    /**
     * Part Identification
     */
    private String StockCode = "";
    /**
     * Part Description
     */
    private String description = "";
    /**
     * JobItem Model Design
     */
    private JobItem jobItemModel;

    //*********************************************<Getters & Setters>**************************************************

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getStockCode() {
        return StockCode;
    }

    public void setStockCode(String stockCode) {
        StockCode = stockCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobItem getJobItemModel() {
        return jobItemModel;
    }

    public void setJobItemModel(JobItem jobItemModel) {
        this.jobItemModel = jobItemModel;
    }
}

package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-21-12
 * Time: 09:43 AM
 */
@Embeddable
public class PartnerLineDiscountPK implements Serializable {

    /**
     * PROPERTY NAME: Series Identification Key
     */
    private Integer seriesId;
    /**
     * PROPERTY NAME: ItemType Identification Key
     */
    private Integer itemTypeId;
    /**
     * PROPERTY NAME: Partner Identification Key
     */
    private Integer partnerId;
    /**
     * PROPERTY NAME: Price Category Identification Key
     */
    private Integer priceCategoryId;

    /**
     * PROPERTY NAME: Start date
     */
    private Date startDate;
    /**
     * PROPERTY NAME: End date
     */
    private Date endDate;

    //************************************************************************
    // CONSTRUCTORS
    //************************************************************************
    public PartnerLineDiscountPK() {
    }

    /**
     * Create Partner Line Discount PK
     *
     * @param seriesId,        Series Identification Key
     * @param itemTypeId,      Itemtype Identification Key
     * @param partnerId,       Partner Identification Key
     * @param priceCategoryId, Price Category Identification Key
     */
    public PartnerLineDiscountPK(Integer seriesId, Integer itemTypeId, Integer partnerId, Integer priceCategoryId) {
        this.seriesId = seriesId;
        this.itemTypeId = itemTypeId;
        this.partnerId = partnerId;
        this.priceCategoryId = priceCategoryId;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

    @Column(name = "seriesid", nullable = false)
    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    @Column(name = "itemtype", nullable = false)
    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    @Column(name = "partnerid", nullable = false)
    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    @Column(name = "price_category", nullable = false)
    public Integer getPriceCategoryId() {
        return priceCategoryId;
    }

    public void setPriceCategoryId(Integer priceCategoryId) {
        this.priceCategoryId = priceCategoryId;
    }

    @Column(name = "startdate", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "enddate", nullable = false)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

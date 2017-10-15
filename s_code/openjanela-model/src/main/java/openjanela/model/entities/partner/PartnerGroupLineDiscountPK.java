package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-21-12
 * Time: 11:27 AM
 */
@Embeddable
public class PartnerGroupLineDiscountPK implements Serializable {

    /**
     * PROPERTY NAME: Series Id
     */
    private Integer seriesId;
    /**
     * PROPERTY NAME: Item Type Id
     */
    private Integer itemTypeId;
    /**
     * PROPERTY NAME: Group Id
     */
    private Integer groupId;
    /**
     * PROPERTY NAME: Price Category Id
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

    public PartnerGroupLineDiscountPK() {
    }

    /**
     * Create Partner Group Line Discount
     *
     * @param seriesId,        Series Identification Key
     * @param itemTypeId,      Item type Identification Key
     * @param groupId,         Group Identification Key
     * @param priceCategoryId, Price Category Identification Key
     * @param startDate,       Start Date
     * @param endDate,         Start Date
     */
    public PartnerGroupLineDiscountPK(Integer seriesId, Integer itemTypeId, Integer groupId, Integer priceCategoryId,
                                      Date startDate, Date endDate) {
        this.seriesId = seriesId;
        this.itemTypeId = itemTypeId;
        this.groupId = groupId;
        this.priceCategoryId = priceCategoryId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //************************************************************************
    // GETTERS AND SETTERS
    //************************************************************************

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

    @Column(name = "groupid", nullable = false)
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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

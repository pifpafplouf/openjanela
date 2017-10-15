package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 09-19-12
 * Time: 02:00 PM
 */
@Entity
@Table(name = "type_coupler_mullion")
@Cacheable
public class TypeCouplerMullion implements Serializable {

    /**
     * PROPERTY NAME: Identification Id
     */
    private TypeCouplerMullionPK id;
    /**
     * PROPERTY NAME: Description
     */
    private String description;
    /**
     * PROPERTY NAME: Type
     */
    private Integer type;  //0-DIVIDER 1-COUPLER 2-MULLION
    /**
     * PROPERTY NAME: Orientation
     */
    private Integer orientation;  //1-VERTICAL 2-HORIZONTAL
    /**
     * PROPERTY NAME: Pricing UOM Id
     */
    private int pricingUOMId;
    /**
     * PROPERTY NAME: Price actual size
     */
    private boolean priceActualSize;
    /**
     * PROPERTY NAME: Price
     */
    private Double price;
    /**
     * PROPERTY NAME: Matrix
     */
    private Integer matrix;
    /**
     * PROPERTY NAME: Price group Id
     */
    private Integer priceGroupId;
    /**
     * PROPERTY NAME: Min price
     */
    private Double minPrice;
    /**
     * PROPERTY NAME: Start date
     */
    private Date startDate;
    /**
     * PROPERTY NAME: End date
     */
    private Date endDate;
    /**
     * PROPERTY NAME: Angle
     */
    private double angle;
    /**
     * PROPERTY NAME: Part Id
     */
    private Integer partId;
    /**
     * PROPERTY NAME: Supplier Identification Id
     */
    private Integer supplierId;
    /**
     * PROPERTY NAME: Supplier Remote Part
     */
    private boolean remote;

    //************************************************************************
    // GETTERS AND SETTERS
    //************************************************************************

    @EmbeddedId
    public TypeCouplerMullionPK getId() {
        return id;
    }

    public void setId(TypeCouplerMullionPK id) {
        this.id = id;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "orientation")
    public Integer getOrientation() {
        return orientation;
    }

    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
    }

    @Column(name = "pricing_uom_id", nullable = false)
    public int getPricingUOMId() {
        return pricingUOMId;
    }

    public void setPricingUOMId(int pricingUOMId) {
        this.pricingUOMId = pricingUOMId;
    }

    @Column(name = "price_actual_size")
    public boolean isPriceActualSize() {
        return priceActualSize;
    }

    public void setPriceActualSize(boolean priceActualSize) {
        this.priceActualSize = priceActualSize;
    }

    //@Column(name = "price", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "matrix")
    public Integer getMatrix() {
        return matrix;
    }

    public void setMatrix(Integer matrix) {
        this.matrix = matrix;
    }

    @Column(name = "price_group_id")
    public Integer getPriceGroupId() {
        return priceGroupId;
    }

    public void setPriceGroupId(Integer priceGroupId) {
        this.priceGroupId = priceGroupId;
    }

    //@Column(name = "min_price", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    @Column(name = "min_price")
    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
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

    @Column(name = "angle", nullable = false)
    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Column(name = "partid")
    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    @Transient
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    @Transient
    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public String toString() {
        return this.description;
    }
}


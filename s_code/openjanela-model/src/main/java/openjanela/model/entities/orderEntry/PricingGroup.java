package openjanela.model.entities.orderEntry;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 10-11-12
 * Time: 09:50 AM
 */
@Entity
@Table(name = "group_pricing")
@Cacheable
public class PricingGroup implements Serializable {

    /**
     * PROPERTY NAME: Identification Id
     */
    private Integer id;
    /**
     * PROPERTY NAME: Description
     */
    private String description;
    /**
     * PROPERTY NAME: Lenght rounding
     */
    private Double lengthRounding;
    /**
     * PROPERTY NAME: Lenght rounding imperial
     */
    private Double lengthRoundingI;
    /**
     * PROPERTY NAME: UI Rounding
     */
    private Double uiRounding;
    /**
     * PROPERTY NAME: Area Rounding
     */
    private Double areaRounding;
    /**
     * PROPERTY NAME: Area rounding Imperial
     */
    private Double areaRoundingI;
    /**
     * PROPERTY NAME: Minimun Area
     */
    private Double minArea;
    /**
     * PROPERTY NAME: Price rounding
     */
    private int priceRounding;
    /**
     * PROPERTY NAME: Decimal part
     */
    private double decimalPart;
    /**
     * PROPERTY NAME: Taxable
     */
    private Boolean taxable;
    /**
     * PROPERTY NAME: Price category
     */
    private Integer priceCategory;
    /**
     * PROPERTY NAME: Price from cost
     */
    private Boolean priceFromCost;
    /**
     * PROPERTY NAME: Percentage applicable to cost for pricing calculation
     */
    private Double priceMarkup;
    /**
     * PROPERTY NAME: Percentage applicable to cost for cost calculation.
     */
    private Double costMarkup;
    /**
     * PROPERTY NAME: Supplier Identification Id
     */
    private Integer supplierId;
    /**
     * PROPERTY NAME: Pricing Group is remote
     */
    private boolean remote;

    public PricingGroup() {
    }

    public PricingGroup(Integer id, String description, Double lengthRounding, Double lengthRoundingI, Double uiRounding,
                        Double areaRounding, Double areaRoundingI, Double minArea, int priceRounding, double decimalPart,
                        Boolean taxable, Integer priceCategory, Boolean priceFromCost, Double priceMarkup, Double costMarkup) {
        this.id = id;
        this.description = description;
        this.lengthRounding = lengthRounding;
        this.lengthRoundingI = lengthRoundingI;
        this.uiRounding = uiRounding;
        this.areaRounding = areaRounding;
        this.areaRoundingI = areaRoundingI;
        this.minArea = minArea;
        this.priceRounding = priceRounding;
        this.decimalPart = decimalPart;
        this.taxable = taxable;
        this.priceCategory = priceCategory;
        this.priceFromCost = priceFromCost;
        this.priceMarkup = priceMarkup;
        this.costMarkup = costMarkup;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "lengthrounding")
    public Double getLengthRounding() {
        return lengthRounding;
    }

    public void setLengthRounding(Double lengthRounding) {
        this.lengthRounding = lengthRounding;
    }

    @Column(name = "lengthroundingi")
    public Double getLengthRoundingI() {
        return lengthRoundingI;
    }

    public void setLengthRoundingI(Double lengthRoundingI) {
        this.lengthRoundingI = lengthRoundingI;
    }

    @Column(name = "uirounding")
    public Double getUiRounding() {
        return uiRounding;
    }

    public void setUiRounding(Double uiRounding) {
        this.uiRounding = uiRounding;
    }

    @Column(name = "arearounding")
    public Double getAreaRounding() {
        return areaRounding;
    }

    public void setAreaRounding(Double areaRounding) {
        this.areaRounding = areaRounding;
    }

    @Column(name = "arearoundingi")
    public Double getAreaRoundingI() {
        return areaRoundingI;
    }

    public void setAreaRoundingI(Double areaRoundingI) {
        this.areaRoundingI = areaRoundingI;
    }

    @Column(name = "minarea")
    public Double getMinArea() {
        return minArea;
    }

    public void setMinArea(Double minArea) {
        this.minArea = minArea;
    }

    @Column(name = "pricerounding")
    public int getPriceRounding()
    {
        return priceRounding;
    }

    public void setPriceRounding(int priceRounding)
    {
        this.priceRounding = priceRounding;
    }

    @Column(name = "decimalpart")
    public double getDecimalPart()
    {
        return decimalPart;
    }

    public void setDecimalPart(double decimalPart)
    {
        this.decimalPart = decimalPart;
    }

    @Column(name = "taxable")
    public Boolean getTaxable() {
        return taxable;
    }

    public void setTaxable(Boolean taxable) {
        this.taxable = taxable;
    }

    @Column(name = "pricecategory")
    public Integer getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(Integer priceCategory) {
        this.priceCategory = priceCategory;
    }

    @Column(name = "pricefromcost")
    public Boolean getPriceFromCost() {
        return priceFromCost;
    }

    public void setPriceFromCost(Boolean priceFromCost) {
        this.priceFromCost = priceFromCost;
    }

    @Column(name = "price_markup")
    public Double getPriceMarkup() {
        return priceMarkup;
    }

    public void setPriceMarkup(Double priceMarkup) {
        this.priceMarkup = priceMarkup;
    }

    @Column(name = "cost_markup")
    public Double getCostMarkup() {
        return costMarkup;
    }

    public void setCostMarkup(Double costMarkup) {
        this.costMarkup = costMarkup;
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

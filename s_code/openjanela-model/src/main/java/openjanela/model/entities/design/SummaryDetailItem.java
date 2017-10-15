package openjanela.model.entities.design;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 17-03-14
 *          Time: 12:28 AM
 */
public class SummaryDetailItem implements Serializable {

    private int id = 0;

    private String description = "";

    private BigDecimal calculateCost = new BigDecimal("0.00");

    private BigDecimal cost = new BigDecimal("0.00");

    private BigDecimal calculatePrice = new BigDecimal("0.00");

    private BigDecimal price = new BigDecimal("0.00");

    private BigDecimal netPrice = new BigDecimal("0.00");

    private BigDecimal discount = new BigDecimal("0.00");

    private BigDecimal commValue = new BigDecimal("0");

    private BigDecimal commPercent = new BigDecimal("0");

    public SummaryDetailItem() {}

    public SummaryDetailItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public SummaryDetailItem(int id, String description, BigDecimal calculateCost, BigDecimal cost,
                             BigDecimal calculatePrice, BigDecimal price, BigDecimal netPrice, BigDecimal discount,
                             BigDecimal commValue, BigDecimal commPercent) {
        this.id = id;
        this.description = description;
        this.calculateCost = calculateCost;
        this.cost = cost;
        this.calculatePrice = calculatePrice;
        this.price = price;
        this.netPrice = netPrice;
        this.discount = discount;
        this.commValue = commValue;
        this.commPercent = commPercent;
    }

    //**********************************************<Getters & Setters>*************************************************

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCalculateCost() {
        return calculateCost;
    }

    public void setCalculateCost(BigDecimal calculateCost) {
        this.calculateCost = calculateCost;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCalculatePrice() {
        return calculatePrice;
    }

    public void setCalculatePrice(BigDecimal calculatePrice) {
        this.calculatePrice = calculatePrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getCommValue() {
        return commValue;
    }

    public void setCommValue(BigDecimal commValue) {
        this.commValue = commValue;
    }

    public BigDecimal getCommPercent() {
        return commPercent;
    }

    public void setCommPercent(BigDecimal commPercent) {
        this.commPercent = commPercent;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openjanela.model.entities.partner;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif Eldibani
 * @author Eddy Montenegro
 * @version 2.0.8
 */
@Entity
@Table(name = "option_answers")
@Cacheable
public class OptionAnswers implements Serializable {

    @EmbeddedId
    private OptionAnswersPK id;

    @Column(name = "stockcode", nullable = true)
    private String stockcode = "";

    @Column(name = "description", nullable = false)
    private String description = "";

    @Column(name = "abbreviation")
    private String abbreviation = "";

    @Column(name = "pricing_uom_id")
    private int pricing_uom_id = 0;

    @Column(name = "price_matrix_id")
    private int price_matrix_id = 0;

    @Column(name = "price", nullable = true)
    private BigDecimal price = new BigDecimal("0");

    @Column(name = "price_group_id")
    private int price_group_id = 0;

    @Column(name = "thickness", nullable = true)
    private Double thickness = new Double("0");

    @Column(name = "min_price", nullable = false)
    private BigDecimal min_price = new BigDecimal("0");

    @Column(name = "costing_uom_id", nullable = false)
    private int costing_uom_id = 0;

    @Column(name = "cost", nullable = false)
    private BigDecimal cost = new BigDecimal("0");

    @Column(name = "pricemeasure", nullable = false)
    private int priceMeasure = 1;

    @Column(name = "taxable", nullable = false)
    private boolean taxable = false;

    @Column(name = "discountable", nullable = false)
    private boolean discountable = false;

    @Column(name = "pricefromcost", nullable = false)
    private boolean priceFromCost = false;

    @Column(name = "pricemarkup", nullable = false)
    private double priceMarkup = 0;

    @Column(name = "costmarkup", nullable = false)
    private double costMarkup = 0;

    @Column(name = "rgb_r", nullable = false)
    private int rgb_R = 0;

    @Column(name = "rgb_g", nullable = false)
    private int rgb_G = 0;

    @Column(name = "rgb_b", nullable = false)
    private int rgb_B = 0;

    @Transient
    private int supplierId = 0;

    @Transient
    private boolean remote = false;

    public OptionAnswers() {
    }

    public OptionAnswers(OptionAnswersPK id, String stockcode, String description, String abbreviation, int pricing_uom_id,
                         int price_matrix_id, BigDecimal price, int price_group_id, Double thickness, BigDecimal min_price,
                         int costing_uom_id, BigDecimal cost, int priceMeasure, boolean taxable, boolean discountable,
                         boolean priceFromCost, double priceMarkup, double costMarkup, int rgb_R, int rgb_G, int rgb_B) {

        this.id = id;
        this.stockcode = stockcode;
        this.description = description;
        this.abbreviation = abbreviation;
        this.pricing_uom_id = pricing_uom_id;
        this.price_matrix_id = price_matrix_id;
        this.price = price;
        this.price_group_id = price_group_id;
        this.thickness = thickness;
        this.min_price = min_price;
        this.costing_uom_id = costing_uom_id;
        this.cost = cost;
        this.priceMeasure = priceMeasure;
        this.taxable = taxable;
        this.discountable = discountable;
        this.priceFromCost = priceFromCost;
        this.priceMarkup = priceMarkup;
        this.costMarkup = costMarkup;
        this.rgb_R = rgb_R;
        this.rgb_G = rgb_G;
        this.rgb_B = rgb_B;
    }

    //***************************************<GETTERS & SETTERS>********************************************************

    public OptionAnswersPK getId() {
        return id;
    }

    public void setId(OptionAnswersPK id) {
        this.id = id;
    }

    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getPricing_uom_id() {
        return pricing_uom_id;
    }

    public void setPricing_uom_id(int pricing_uom_id) {
        this.pricing_uom_id = pricing_uom_id;
    }

    public int getPrice_matrix_id() {
        return price_matrix_id;
    }

    public void setPrice_matrix_id(int price_matrix_id) {
        this.price_matrix_id = price_matrix_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPrice_group_id() {
        return price_group_id;
    }

    public void setPrice_group_id(int price_group_id) {
        this.price_group_id = price_group_id;
    }

    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    public BigDecimal getMin_price() {
        return min_price;
    }

    public void setMin_price(BigDecimal min_price) {
        this.min_price = min_price;
    }

    public int getCosting_uom_id() {
        return costing_uom_id;
    }

    public void setCosting_uom_id(int costing_uom_id) {
        this.costing_uom_id = costing_uom_id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getPriceMeasure() {
        return priceMeasure;
    }

    public void setPriceMeasure(int priceMeasure) {
        this.priceMeasure = priceMeasure;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public boolean isDiscountable() {
        return discountable;
    }

    public void setDiscountable(boolean discountable) {
        this.discountable = discountable;
    }

    public boolean isPriceFromCost() {
        return priceFromCost;
    }

    public void setPriceFromCost(boolean priceFromCost) {
        this.priceFromCost = priceFromCost;
    }

    public double getPriceMarkup() {
        return priceMarkup;
    }

    public void setPriceMarkup(double priceMarkup) {
        this.priceMarkup = priceMarkup;
    }

    public double getCostMarkup() {
        return costMarkup;
    }

    public int getRgb_R() {
        return rgb_R;
    }

    public void setRgb_R(int rgb_R) {
        this.rgb_R = rgb_R;
    }

    public int getRgb_G() {
        return rgb_G;
    }

    public void setRgb_G(int rgb_G) {
        this.rgb_G = rgb_G;
    }

    public int getRgb_B() {
        return rgb_B;
    }

    public void setRgb_B(int rgb_B) {
        this.rgb_B = rgb_B;
    }

    public void setCostMarkup(double costMarkup) {
        this.costMarkup = costMarkup;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    @Override
    public String toString() {
        return this.description;
    }
}


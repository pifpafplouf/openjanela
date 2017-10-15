package openjanela.model.entities.partner;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 12-17-12
 *          Time: 11:50 PM
 */
@Entity
@Table(name = "group_pricing")
@Cacheable
public class GroupPricing implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    public Integer id;

    @Basic(optional = false)
    @Column(name = "description")
    public String description;

    @Column(name = "lengthrounding")
    public int lengthrounding;

    @Column(name = "uirounding")
    public int uirounding;

    @Column(name = "arearounding")
    public int arearounding;

    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "minarea")
    public Double minarea;

    @Column(name = "pricerounding")
    public int pricerounding;

    @Column(name = "decimalpart")
    public double decimalpart;

    @Column(name = "taxable")
    public boolean taxable;

    @Column(name = "pricecategory")
    public int pricecategory;

    @Column(name = "lengthroundingi")
    public int lengthroundingi;

    @Column(name = "arearoundingi")
    public int arearoundingi;

    @Column(name = "pricefromcost")
    public boolean pricefromcost;

    @Column(name = "price_markup")
    public int pricemarkup;

    @Column(name = "cost_markup")
    public int costmarkup;

    public GroupPricing() {
    }

    public GroupPricing(int id) {
        this.id = id;
    }

    public GroupPricing(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public GroupPricing(int id, String description, int lengthrounding, int uirounding, int arearounding, Double minarea,
                        int pricerounding, double decimalpart, boolean taxable, int pricecategory, int lengthroundingi,
                        int arearoundingi, boolean pricefromcost, int pricemarkup, int costmarkup) {

        this.id = id;
        this.description = description;
        this.lengthrounding = lengthrounding;
        this.uirounding = uirounding;
        this.arearounding = arearounding;
        this.minarea = minarea;
        this.pricerounding = pricerounding;
        this.decimalpart = decimalpart;
        this.taxable = taxable;
        this.pricecategory = pricecategory;
        this.lengthroundingi = lengthroundingi;
        this.arearoundingi = arearoundingi;
        this.pricefromcost = pricefromcost;
        this.pricemarkup = pricemarkup;
        this.costmarkup = costmarkup;
    }

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

    public int getLengthrounding() {
        return lengthrounding;
    }

    public void setLengthrounding(int lengthrounding) {
        this.lengthrounding = lengthrounding;
    }

    public int getUirounding() {
        return uirounding;
    }

    public void setUirounding(int uirounding) {
        this.uirounding = uirounding;
    }

    public int getArearounding() {
        return arearounding;
    }

    public void setArearounding(int arearounding) {
        this.arearounding = arearounding;
    }

    public Double getMinarea() {
        return minarea;
    }

    public void setMinarea(Double minarea) {
        this.minarea = minarea;
    }

    public int getPricerounding() {
        return pricerounding;
    }

    public void setPricerounding(int pricerounding) {
        this.pricerounding = pricerounding;
    }

    public double getDecimalpart() {
        return decimalpart;
    }

    public void setDecimalpart(double decimalpart) {
        this.decimalpart = decimalpart;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof GroupPricing)) {
            return false;
        }
        GroupPricing other = (GroupPricing) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return this.description;
    }

}

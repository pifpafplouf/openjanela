package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-21-12
 * Time: 09:42 AM
 */
@Entity
@Table(name = "partner_line_discount")
@Cacheable
public class PartnerLineDiscount implements Serializable {

    /**
     * PROPERTY NAME: Partner Line Discount Id
     */
    private PartnerLineDiscountPK id;
    /**
     * PROPERTY NAME: Variable 1
     */
    private Integer var_1;
    /**
     * PROPERTY NAME: Variable 2
     */
    private Integer var_2;
    /**
     * PROPERTY NAME: Discount
     */
    private Double discount;

    public PartnerLineDiscount() {
    }

    public PartnerLineDiscount(PartnerLineDiscountPK id, Integer var_1, Integer var_2, Double discount) {
        this.id = id;
        this.var_1 = var_1;
        this.var_2 = var_2;
        this.discount = discount;
    }

    //************************************************************************
    // GETTERS AND SETTERS
    //************************************************************************

    @EmbeddedId
    public PartnerLineDiscountPK getId() {
        return id;
    }

    public void setId(PartnerLineDiscountPK id) {
        this.id = id;
    }

    @Column(name = "var1")
    public Integer getVar_1() {
        return var_1;
    }

    public void setVar_1(Integer var_1) {
        this.var_1 = var_1;
    }

    @Column(name = "var2")
    public Integer getVar_2() {
        return var_2;
    }

    public void setVar_2(Integer var_2) {
        this.var_2 = var_2;
    }

    @Column(name = "discount")
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

}

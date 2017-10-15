package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-21-12
 * Time: 11:26 AM
 */
@Entity
@Table(name = "partner_group_line_discount")
@Cacheable
public class PartnerGroupLineDiscount implements Serializable {

    /**
     * PROPERTY NAME: Partner Group Line Discount Id
     */
    private PartnerGroupLineDiscountPK id;
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

    public PartnerGroupLineDiscount() {
    }

    public PartnerGroupLineDiscount(PartnerGroupLineDiscountPK id, Integer var_1, Integer var_2, Double discount) {
        this.id = id;
        this.var_1 = var_1;
        this.var_2 = var_2;
        this.discount = discount;
    }

    //************************************************************************
    // GETTERS AND SETTERS
    //************************************************************************

    @EmbeddedId
    public PartnerGroupLineDiscountPK getId() {
        return id;
    }

    public void setId(PartnerGroupLineDiscountPK id) {
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

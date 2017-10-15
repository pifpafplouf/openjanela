package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-17-13
 *          Time: 03:35 PM
 */
@Entity
@Table(name = "payment_terms")
@Cacheable
public class PaymentTerms implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = true)
    private String description = "";

    @Column(name = "days", nullable = true)
    private int days = 0;

    @Column(name = "discount", nullable = true)
    private double discount = 0;

    public PaymentTerms() {
    }

    public PaymentTerms(Integer id, String description, int days, double discount) {
        this.id = id;
        this.description = description;
        this.days = days;
        this.discount = discount;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

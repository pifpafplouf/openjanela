package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-01-13
 *          Time: 09:44 PM
 */
@Entity
@Table(name = "partner_weekends")
@Cacheable
public class PartnerWeekends implements Serializable {

    @Id
    @Column(name = "partnerid", nullable = false)
    private Integer partnerId;

    @Column(name = "day1", nullable = false)
    private int day1;

    @Column(name = "day2", nullable = false)
    private int day2;

    @Column(name = "issupplier", nullable = false)
    private boolean isSupplier;

    public PartnerWeekends() {
    }

    public PartnerWeekends(Integer partnerId, int day1, int day2, boolean isSupplier) {
        this.partnerId = partnerId;
        this.day1 = day1;
        this.day2 = day2;
        this.isSupplier = isSupplier;
    }

    //******************************************<Getters & Setters>*****************************************************

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public int getDay1() {
        return day1;
    }

    public void setDay1(int day1) {
        this.day1 = day1;
    }

    public int getDay2() {
        return day2;
    }

    public void setDay2(int day2) {
        this.day2 = day2;
    }

    public boolean isSupplier() {
        return isSupplier;
    }

    public void setSupplier(boolean supplier) {
        isSupplier = supplier;
    }
}

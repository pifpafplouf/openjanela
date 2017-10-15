package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 09-01-13
 *          Time: 09:44 PM
 */
@Embeddable
public class PartnerHolidaysPK implements Serializable {

    @Column(name = "partnerid", nullable = false)
    private int partnerId;

    @Column(name = "month_", nullable = false)
    private int month;

    @Column(name = "day_", nullable = false)
    private int day;

    /**
     * Partner Holidays PK
     */
    public PartnerHolidaysPK() {
    }

    /**
     * Partner Holidays PK
     * @param partnerId, Partner Identification Id
     * @param month, Month Integer Value
     * @param day, Day Integer Value
     */
    public PartnerHolidaysPK(int partnerId, int month, int day) {
        this.partnerId = partnerId;
        this.month = month;
        this.day = day;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

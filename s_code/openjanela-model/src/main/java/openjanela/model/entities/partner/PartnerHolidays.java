package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 09-01-13
 *          Time: 09:44 PM
 */
@Entity
@Table(name = "partner_holidays")
public class PartnerHolidays implements Serializable{

    @EmbeddedId
    private PartnerHolidaysPK partnerHolidaysPK;

    @Column(name = "issupplier", nullable = false)
    private boolean isSupplier;

    public PartnerHolidays() {
    }

    public PartnerHolidays(PartnerHolidaysPK partnerHolidaysPK, boolean isSupplier) {
        this.partnerHolidaysPK = partnerHolidaysPK;
        this.isSupplier = isSupplier;
    }

    //*******************************************<Getters & Setters>****************************************************

    public PartnerHolidaysPK getPartnerHolidaysPK() {
        return partnerHolidaysPK;
    }

    public void setPartnerHolidaysPK(PartnerHolidaysPK partnerHolidaysPK) {
        this.partnerHolidaysPK = partnerHolidaysPK;
    }

    public boolean isSupplier() {
        return isSupplier;
    }

    public void setSupplier(boolean isSupplier) {
        this.isSupplier = isSupplier;
    }
}

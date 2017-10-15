package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-01-13
 *          Time: 09:26 PM
 */
@Entity
@Table(name = "partner_scheduling_preferences")
@Cacheable
public class PartnerSchedulingPreferences implements Serializable {

    @Id
    @Column(name = "partnerid", nullable = false)
    private Integer partnerId;

    @Column(name = "useownweekends", nullable = false)
    private boolean useOwnWeekends = false;

    @Column(name = "useownholidays", nullable = false)
    private boolean useOwnHolidays = false;

    @Column(name = "issupplier", nullable = false)
    private boolean isSupplier = false;

    public PartnerSchedulingPreferences() {
    }

    public PartnerSchedulingPreferences(Integer partnerId, boolean useOwnWeekends, boolean useOwnHolidays,
                                        boolean isSupplier) {
        this.partnerId = partnerId;
        this.useOwnWeekends = useOwnWeekends;
        this.useOwnHolidays = useOwnHolidays;
        this.isSupplier = isSupplier;
    }

    //************************************<Getters & Setters>***********************************************************

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public boolean isUseOwnWeekends() {
        return useOwnWeekends;
    }

    public void setUseOwnWeekends(boolean useOwnWeekends) {
        this.useOwnWeekends = useOwnWeekends;
    }

    public boolean isUseOwnHolidays() {
        return useOwnHolidays;
    }

    public void setUseOwnHolidays(boolean useOwnHolidays) {
        this.useOwnHolidays = useOwnHolidays;
    }

    public boolean isSupplier() {
        return isSupplier;
    }

    public void setSupplier(boolean supplier) {
        isSupplier = supplier;
    }
}

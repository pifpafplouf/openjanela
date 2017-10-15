/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package openjanela.model.entities.admin;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Sherif
 */
@Entity
@Table(name = "country_holidays")
@Cacheable
public class CountryHolidays implements Serializable {

    @EmbeddedId
    protected CountryHolidaysPK countryHolidaysPK;

    public CountryHolidays() {}

    public CountryHolidays(CountryHolidaysPK countryHolidaysPK) {
        this.countryHolidaysPK = countryHolidaysPK;
    }

    //*****************************************<Getters & Setters>******************************************************

    public CountryHolidaysPK getCountryHolidaysPK() {
        return countryHolidaysPK;
    }

    public void setCountryHolidaysPK(CountryHolidaysPK countryHolidaysPK) {
        this.countryHolidaysPK = countryHolidaysPK;
    }

}

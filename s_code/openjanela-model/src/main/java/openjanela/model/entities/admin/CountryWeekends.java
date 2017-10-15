/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @version 2.0.8
 *          Date: 1/11/14
 *          Time: 8:08 PM
 */
@Entity
@Table(name = "country_weekends")
public class CountryWeekends implements Serializable {

    protected CountryWeekendsPK countryWeekendsPK;

    //*****************************************<Constructor>************************************************************

    public CountryWeekends() {
    }

    public CountryWeekends(CountryWeekendsPK countryWeekendsPK) {
        this.countryWeekendsPK = countryWeekendsPK;
    }

    //*****************************************<Getters & Setters>******************************************************

    @EmbeddedId
    public CountryWeekendsPK getCountryWeekendsPK() {
        return countryWeekendsPK;
    }

    public void setCountryWeekendsPK(CountryWeekendsPK countryWeekendsPK) {
        this.countryWeekendsPK = countryWeekendsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryWeekendsPK != null ? countryWeekendsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CountryWeekends)) {
            return false;
        }
        CountryWeekends other = (CountryWeekends) object;
        if ((this.countryWeekendsPK == null && other.countryWeekendsPK != null)
                || (this.countryWeekendsPK != null && !this.countryWeekendsPK.equals(other.countryWeekendsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return countryWeekendsPK.getDay1() + " to " + countryWeekendsPK.getDay2();
    }

}
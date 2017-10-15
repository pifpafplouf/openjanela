/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package openjanela.model.entities.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * @author Sherif
 */
@Entity
@Table(name = "currency")
@Cacheable
public class AppCurrency implements Serializable {

    /**
     * PROPERTY NAME: Identification Id
     */
    public String id;
    /**
     * PROPERTY NAME: Currency name
     */
    public String currencyName;
    /**
     * PROPERTY NAME: Country Identificatio Id
     */
    public String countryId;
    /**
     * PROPERTY NAME: Country name
     */
    public String countryName;

    // ==================================<CONSTRUCTOR>=========================================================


    public AppCurrency() {
    }

    public AppCurrency(String id, String currencyName, String countryId, String countryName) {
        this.id = id;
        this.currencyName = currencyName;
        this.countryId = countryId;
        this.countryName = countryName;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

    @Id
    @Column(name = "id", nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "currency_name")
    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Column(name = "country_id")
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Column(name = "country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppCurrency)) {
            return false;
        }
        AppCurrency other = (AppCurrency) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return currencyName;
    }


}

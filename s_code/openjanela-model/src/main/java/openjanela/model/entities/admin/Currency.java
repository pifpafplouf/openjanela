package openjanela.model.entities.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2014 OpenJanela LLC. All rights reserved.
 *
 * @author emontenegro@openjanela.com
 * @version 2.1.2
 *          Date: 7/7/14
 *          Time: 11:35 AM
 */
@Entity
@Table(name = "currency")
@Cacheable
public class Currency implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "currency_name", nullable = true)
    private String currency_name;

    @Column(name = "country_id", nullable = false)
    private String country_id;

    @Column(name = "country_name", nullable = true)
    private String country_name;

   //**************************************************************************

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.currency_name;
    }
}

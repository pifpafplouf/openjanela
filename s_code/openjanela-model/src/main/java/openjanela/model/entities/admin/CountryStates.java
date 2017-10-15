package openjanela.model.entities.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 1/11/14
 *          Time: 8:08 PM
 */
@Entity
@Table(name = "country_states")
@Cacheable
public class CountryStates implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "abbrev", nullable = true)
    private String abbrev;

    @Column(name = "countryid", nullable = false)
    private String countryId;

    public CountryStates() {
    }

    public CountryStates(Integer id, String description, String abbrev, String countryId) {
        this.id = id;
        this.description = description;
        this.abbrev = abbrev;
        this.countryId = countryId;
    }

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

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }

}

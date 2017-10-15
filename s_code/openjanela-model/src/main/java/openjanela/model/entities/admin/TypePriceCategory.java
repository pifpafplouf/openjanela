package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-11-12
 *          Time: 09:46 AM
 */
@Entity
@Table(name = "type_price_category")
@Cacheable
public class TypePriceCategory implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private int id = 0;

    @Column(name = "description", nullable = false)
    private String description = "";

    public TypePriceCategory() {}

    public TypePriceCategory(int id, String description) {
        this.id = id;
        this.description = description;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return getDescription();
    }
}

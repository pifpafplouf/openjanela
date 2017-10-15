package openjanela.model.entities.design;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-19-13
 *          Time: 10:28 PM
 */
@Entity
@Table(name = "design_family")
public class DesignFamily implements Serializable {

    @EmbeddedId
    private DesignPK id;

    @Column(name = "description")
    private String description;

    public DesignFamily() {
    }

    public DesignFamily(DesignPK id, String description) {
        this.id = id;
        this.description = description;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public DesignPK getId() {
        return id;
    }

    public void setId(DesignPK id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return this.description;
    }
}

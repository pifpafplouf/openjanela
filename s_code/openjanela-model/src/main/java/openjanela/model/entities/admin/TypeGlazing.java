package openjanela.model.entities.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 *
 * @author Eddy Montenegro
 *         Date: 09-17-12
 *         Time: 10:35 PM
 */
@Entity
@Table(name = "type_glazing")
@Cacheable
public class TypeGlazing implements Serializable {

    /**
     * PROPERTY NAME: Primary Key identifier
     */
    private Integer id;
    /**
     * PROPERTY NAME: Description
     */
    private String description;

    public TypeGlazing() {
    }

    public TypeGlazing(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}

package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @author Eddy Montenegro
 * @version 2.0.8
 */
@Entity
@Table(name = "type_shape")
@Cacheable
public class TypeShape implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "abbrev")
    private String abbrev;

    public TypeShape() {
    }

    public TypeShape(Integer id) {
        this.id = id;
    }

    public TypeShape(Integer id, String description, String abbrev) {
        this.id = id;
        this.description = description;
        this.abbrev = abbrev;
    }

    //******************************************<GETTERS & SETTERS>****************************************************

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

    @Override
    public String toString() {
        return getDescription();
    }


}

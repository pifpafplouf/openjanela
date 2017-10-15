package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 1/11/14
 *          Time: 8:08 PM
 */
@Entity
@Table(name = "country")
@Cacheable
public class Country implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "id_2")
    private String id2;

    @Column(name = "id_int")
    private int idInt;

    public Country() {}

    public Country(String id, String description, String id2, int idInt) {
        this.id = id;
        this.description = description;
        this.id2 = id2;
        this.idInt = idInt;
    }

    //*****************************************<Getters & Setters>******************************************************

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public int getIdInt() {
        return idInt;
    }

    public void setIdInt(int idInt) {
        this.idInt = idInt;
    }

    @Override
    public String toString() {
        return description;
    }

}

package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 08-07-12
 * Time: 10:47 PM
 */
public class SystemType implements Serializable {

    /**
     * PROPERTY NAME: Identification primary key
     */
    private Integer id;
    /**
     * PROPERTY NAME: Description system
     */
    private String descripcion;
    /**
     * PROPERTY NAME: Stocked
     */
    private boolean stocked;

    public SystemType() {
    }

    public SystemType(Integer id, String descripcion, boolean stocked) {
        this.id = id;
        this.descripcion = descripcion;
        this.stocked = stocked;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isStocked() {
        return stocked;
    }

    public void setStocked(boolean stocked) {
        this.stocked = stocked;
    }
}

package openjanela.model.entities.design;

import javax.persistence.*;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 03-15-12
 * Time: 03:06 PM
 */
public class GlazingType {

    private Integer id;

    private String description = "";
    private int value = 0;

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

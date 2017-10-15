package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 09-18-12
 * Time: 09:21 AM
 */
@Entity
@Table(name = "su_family")
@Cacheable
public class SUFamily implements Serializable {

    /**
     * PROPERTY NAME: Primary Key identifier
     */
    private Integer id;
    /**
     * PROPERTY NAME: Description
     */
    private String description;

    public SUFamily() {
    }

    public SUFamily(Integer id, String description) {
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

    /**
     * To String description class
     * @return String
     */
    public String toString() {
        return this.getDescription();
    }
}

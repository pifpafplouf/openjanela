package openjanela.model.entities.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 12/3/13
 *          Time: 3:56 PM
 */
@Entity
@Table(name = "type_grid")
@Cacheable
public class TypeGrid implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    public TypeGrid() {
    }

    public TypeGrid(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    //*********************************************<Getters & Setters>**************************************************

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
}

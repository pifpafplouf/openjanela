package openjanela.model.entities.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-28-13
 *          Time: 07:23 PM
 */
@Entity
@Table(name = "type_resource_function")
@Cacheable
public class TypeResourceFunction implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public TypeResourceFunction() {
    }

    public TypeResourceFunction(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    //****************************************<Getter & Setter>*********************************************************

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

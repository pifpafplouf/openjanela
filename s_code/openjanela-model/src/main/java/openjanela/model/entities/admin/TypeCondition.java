/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openjanela.model.entities.admin;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @version 2.0.8
 *          Date: 04-15-13
 *          Time: 12:25 PM
 */
@Entity
@Table(name = "type_condition")
public class TypeCondition implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    public TypeCondition() {
    }

    public TypeCondition(Integer id) {
        this.id = id;
    }

    public TypeCondition(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TypeCondition)) {
            return false;
        }
        TypeCondition other = (TypeCondition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.description;
    }

}

package openjanela.model.entities.admin;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @version 2.0.8
 *          Date: 04-15-13
 *          Time: 12:25 PM
 */
@Entity
@Table(name = "type_endtype")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class TypeEndType implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    public TypeEndType() {
    }

    public TypeEndType(Integer id) {
        this.id = id;
    }

    public TypeEndType(Integer id, String description) {
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
        if (!(object instanceof TypeEndType)) {
            return false;
        }
        TypeEndType other = (TypeEndType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return description;
    }

}

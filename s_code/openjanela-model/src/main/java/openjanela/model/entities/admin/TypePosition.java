package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "type_position")
public class TypePosition implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "seriestype")
    private int seriestype;

    public TypePosition() {
    }

    public TypePosition(Integer id) {
        this.id = id;
    }

    public TypePosition(Integer id, String description, int seriestype) {
        this.id = id;
        this.description = description;
        this.seriestype = seriestype;
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

    public int getSeriesType() {
        return seriestype;
    }

    public void getSeriesType(int seriestype) {
        this.seriestype = seriestype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TypePosition)) {
            return false;
        }
        TypePosition other = (TypePosition) object;
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

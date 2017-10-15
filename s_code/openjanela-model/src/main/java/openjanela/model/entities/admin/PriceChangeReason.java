/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author  Sherif Eldibani
 * @version 2.0.8
 *          Date: 05-27-13
 *          Time: 04:25 PM
 */
@Entity
@Table(name = "price_change_reason")
public class PriceChangeReason implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    //****************************************<Constructors>************************************************************

    public PriceChangeReason() {
    }

    public PriceChangeReason(Integer id) {
        this.id = id;
    }

    public PriceChangeReason(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    //****************************************<Getters & Setters>*******************************************************

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
        if (!(object instanceof TypeDelimiters)) {
            return false;
        }
        PriceChangeReason other = (PriceChangeReason) object;
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

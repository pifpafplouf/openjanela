package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @version 2.0.8
 *          Date: 04-15-13
 *          Time: 12:25 PM
 */
@Entity
@Table(name = "type_part")
@Cacheable
public class TypePart implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "systemtype")
    private Integer systemtype;

    @Column(name = "metric_imp")
    private boolean metricImp;

    @Column(name = "system_uom")
    private Integer systemUom;

    public TypePart() {
    }

    public TypePart(Integer id) {
        this.id = id;
    }

    public TypePart(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public TypePart(Integer id, String description, Integer systemtype, boolean metricImp, Integer systemUom) {
        this.id = id;
        this.description = description;
        this.systemtype = systemtype;
        this.metricImp = metricImp;
        this.systemUom = systemUom;
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

    public Integer getSystemtype() {

        return systemtype;
    }

    public void setSystemtype(Integer systemtype) {

        this.systemtype = systemtype;
    }

    public boolean getMetricImp() {

        return metricImp;
    }

    public void setMetricImp(boolean metricImp) {

        this.metricImp = metricImp;
    }

    public Integer getSystemUom() {

        return systemUom;
    }

    public void setSystemUom(Integer systemUom) {

        this.systemUom = systemUom;
    }

    @Override
    public int hashCode() {

        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TypePart)) {
            return false;
        }
        TypePart other = (TypePart) object;
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

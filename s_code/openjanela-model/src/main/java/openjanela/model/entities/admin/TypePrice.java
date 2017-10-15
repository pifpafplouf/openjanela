package openjanela.model.entities.admin;

import java.io.Serializable;

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
@Table(name = "type_price")
@Cacheable
public class TypePrice implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    private String description;

    @Basic(optional = false)
    private String tablesql;

    @Basic(optional = false)
    private String var2sql;

    public TypePrice() {
    }

    public TypePrice(Integer id) {
        this.id = id;
    }

    public TypePrice(Integer id, String description, String tablesql, String var2sql) {
        this.id = id;
        this.description = description;
        this.tablesql = tablesql;
        this.var2sql = var2sql;
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

    public String getTablesql() {

        return tablesql;
    }

    public void setTablesql(String tablesql) {

        this.tablesql = tablesql;
    }

    public String getVar2sql() {

        return var2sql;
    }

    public void setVar2sql(String var2sql) {

        this.var2sql = var2sql;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TypePrice)) {
            return false;
        }
        TypePrice other = (TypePrice) object;
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

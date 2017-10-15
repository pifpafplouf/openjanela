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
@Table(name = "type_document", catalog = "openjanela")
@Cacheable
public class TypeDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", length = 25)
    private String description;

    @Column(name = "desc2")
    private String desc2;

    @Column(name = "initstatus")
    private Integer initstatus;

    public TypeDocument() {
    }

    public TypeDocument(Integer id) {
        this.id = id;
    }

    public TypeDocument(String description, String desc2, Integer initstatus) {
        this.description = description;
        this.desc2 = desc2;
        this.initstatus = initstatus;
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

    public Integer getInitstatus() {
        return initstatus;
    }

    public void setInitstatus(Integer initstatus) {
        this.initstatus = initstatus;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TypeDocument)) {
            return false;
        }
        TypeDocument other = (TypeDocument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Openjanela_PersistenceObjects.TypeDocument[ id=" + id + " ]";
    }

}

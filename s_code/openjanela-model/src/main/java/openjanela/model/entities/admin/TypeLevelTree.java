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
@Table(name = "type_level_tree")
@Cacheable
public class TypeLevelTree implements Serializable {

    @EmbeddedId
    protected TypeLevelTreePK id;

    @Column(name = "description")
    private String description;

    //**********************************************<GETTERS & SETTERS>***********************************************

    public TypeLevelTreePK getTypeLevelTreePK() {
        return id;
    }

    public void setTypeLevelTreePK(TypeLevelTreePK typeLevelTreePK) {
        this.id = typeLevelTreePK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeLevelTree() {}

    public TypeLevelTree(TypeLevelTreePK typeLevelTreePK) {
        this.id = typeLevelTreePK;
    }

    public TypeLevelTree(int id, int levelId) {
        this.id = new TypeLevelTreePK(id, levelId);
    }

    public TypeLevelTree(TypeLevelTreePK id, String description) {
        this.id = id;
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
        if (!(object instanceof TypeLevelTree)) {
            return false;
        }
        TypeLevelTree other = (TypeLevelTree) object;
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

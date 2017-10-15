package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-11-12
 *          Time: 03:01 PM
 */
@Entity
@Table(name = "type_level")
@Cacheable
public class TypeLevel implements Serializable {

    @EmbeddedId
    private TypeLevelPK typeLevelPK;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "seriestype", nullable = false)
    private int seriesType;

    public TypeLevel() {
    }

    public TypeLevel(TypeLevelPK typeLevelPK) {
        this.typeLevelPK = typeLevelPK;
    }

    public TypeLevel(TypeLevelPK typeLevelPK, String description, int seriesType) {
        this.typeLevelPK = typeLevelPK;
        this.description = description;
        this.seriesType = seriesType;
    }

    //*************************************<GETTERS & SETTERS>**********************************************************

    public TypeLevelPK getTypeLevelPK() {
        return typeLevelPK;
    }

    public void setTypeLevelPK(TypeLevelPK typeLevelPK) {
        this.typeLevelPK = typeLevelPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(int seriesType) {
        this.seriesType = seriesType;
    }

    @Override
    public String toString() {
        return this.description;
    }


}

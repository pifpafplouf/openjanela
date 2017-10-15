package openjanela.model.entities.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 *         Date: 10-11-12
 *         Time: 09:21 AM
 */
@Entity
@Table(name = "system_uom")
public class SystemUOM implements Serializable {

    /**
     * PROPERTY NAME: Identification Id
     */
    private Integer id;
    /**
     * PROPERTY NAME: Description
     */
    private String description;
    /**
     * PROPERTY NAME: Base UOM
     */
    private String baseuom;
    /**
     * PROPERTY NAME: base precision
     */
    private Double basePrecision;

    public SystemUOM() {
    }

    public SystemUOM(Integer id, String description, String baseuom, Double basePrecision) {
        this.id = id;
        this.description = description;
        this.baseuom = baseuom;
        this.basePrecision = basePrecision;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    @Id
    @Column(name = "id", columnDefinition = "TINYINT", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "baseuom", length = 10)
    public String getBaseuom() {
        return baseuom;
    }

    public void setBaseuom(String baseuom) {
        this.baseuom = baseuom;
    }

    @Column(name = "baseprecision", precision = 22)
    public Double getBasePrecision() {
        return basePrecision;
    }

    public void setBasePrecision(Double basePrecision) {
        this.basePrecision = basePrecision;
    }

    public String toString() {
        return this.description;
    }
}

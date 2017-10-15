package openjanela.model.entities.orderEntry;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-12-12
 *          Time: 02:10 PM
 */
@Entity
@Table(name = "group_costing")
@Cacheable
public class CostingGroup implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "lengthrounding")
    private Integer lengthRounding;

    @Column(name = "uirounding")
    private Integer uiRounding;

    @Column(name = "arearounding")
    private Integer areaRounding;

    @Column(name = "minarea")
    private Double minArea;

    @Column(name = "pricerounding")
    private String priceRounding;

    @Column(name = "decimalpart")
    private String decimalPart;

    public CostingGroup() {
    }

    public CostingGroup(Integer id, String description, Integer lengthRounding, Integer uiRounding, Integer areaRounding,
                        Double minArea, String priceRounding, String decimalPart) {
        this.id = id;
        this.description = description;
        this.lengthRounding = lengthRounding;
        this.uiRounding = uiRounding;
        this.areaRounding = areaRounding;
        this.minArea = minArea;
        this.priceRounding = priceRounding;
        this.decimalPart = decimalPart;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================


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

    public Integer getLengthRounding() {
        return lengthRounding;
    }

    public void setLengthRounding(Integer lengthRounding) {
        this.lengthRounding = lengthRounding;
    }

    public Integer getUiRounding() {
        return uiRounding;
    }

    public void setUiRounding(Integer uiRounding) {
        this.uiRounding = uiRounding;
    }

    public Integer getAreaRounding() {
        return areaRounding;
    }

    public void setAreaRounding(Integer areaRounding) {
        this.areaRounding = areaRounding;
    }

    public Double getMinArea() {
        return minArea;
    }

    public void setMinArea(Double minArea) {
        this.minArea = minArea;
    }

    public String getPriceRounding() {
        return priceRounding;
    }

    public void setPriceRounding(String priceRounding) {
        this.priceRounding = priceRounding;
    }

    public String getDecimalPart() {
        return decimalPart;
    }

    public void setDecimalPart(String decimalPart) {
        this.decimalPart = decimalPart;
    }

    public String toString() {
        return this.description;
    }
}


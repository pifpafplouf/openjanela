package openjanela.model.entities.parts;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 08-07-12
 * Time: 11:01 PM
 */
@Entity
@Table(name = "part_family_series")
public class PartFamilySeries implements Serializable {
	
	@EmbeddedId
	public PartFamilySeriesPK id;
	
    @Column(name = "include_in_price")
    private Boolean includeInPrice;

    @Column(name = "price_group")
    private Integer priceGroup;

    @Column(name = "markedup_cost")
    private Boolean markedupCost;

    @Column(name = "price_markup")
    private Double priceMarkup;

    @Column(name = "price_markup_matrix")
    private Integer priceMarkupMatrix;

    @Column(name = "include_in_cost")
    private Boolean includeInCost;

    @Column(name = "cost_group")
    private Integer costGroup;

    @Column(name = "cost_markup")
    private Double costMarkup;

    @Column(name = "cost_markup_matrix")
    private Integer costMarkupMatrix;


    public PartFamilySeries() {
        id = new PartFamilySeriesPK();
    }

    public PartFamilySeries(PartFamilySeriesPK id, Boolean includeInPrice, Integer priceGroup, Boolean markedupCost,
                            Double priceMarkup, Integer priceMarkupMatrix, Boolean includeInCost, Integer costGroup,
                            Double costMarkup, Integer costMarkupMatrix) {

        this.id = id;
        this.includeInPrice = includeInPrice;
        this.priceGroup = priceGroup;
        this.markedupCost = markedupCost;
        this.priceMarkup = priceMarkup;
        this.priceMarkupMatrix = priceMarkupMatrix;
        this.includeInCost = includeInCost;
        this.costGroup = costGroup;
        this.costMarkup = costMarkup;
        this.costMarkupMatrix = costMarkupMatrix;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

	public PartFamilySeriesPK getId() {
		return id;
	}
	
	public void setId(PartFamilySeriesPK id) {
		this.id = id;
	}

    public Boolean getIncludeInPrice() {
        return includeInPrice;
    }

    public void setIncludeInPrice(Boolean includeInPrice) {
        this.includeInPrice = includeInPrice;
    }

    public Integer getPriceGroup() {
        return priceGroup;
    }

    public void setPriceGroup(Integer priceGroup) {
        this.priceGroup = priceGroup;
    }

    public Boolean getMarkedupCost() {
        return markedupCost;
    }

    public void setMarkedupCost(Boolean markedupCost) {
        this.markedupCost = markedupCost;
    }

    public Double getPriceMarkup() {
        return priceMarkup;
    }

    public void setPriceMarkup(Double priceMarkup) {
        this.priceMarkup = priceMarkup;
    }

    public Integer getPriceMarkupMatrix() {
        return priceMarkupMatrix;
    }

    public void setPriceMarkupMatrix(Integer priceMarkupMatrix) {
        this.priceMarkupMatrix = priceMarkupMatrix;
    }

    public Boolean getIncludeInCost() {
        return includeInCost;
    }

    public void setIncludeInCost(Boolean includeInCost) {
        this.includeInCost = includeInCost;
    }

    public Integer getCostGroup() {
        return costGroup;
    }

    public void setCostGroup(Integer costGroup) {
        this.costGroup = costGroup;
    }

    public Double getCostMarkup() {
        return costMarkup;
    }

    public void setCostMarkup(Double costMarkup) {
        this.costMarkup = costMarkup;
    }

    public Integer getCostMarkupMatrix() {
        return costMarkupMatrix;
    }

    public void setCostMarkupMatrix(Integer costMarkupMatrix) {
        this.costMarkupMatrix = costMarkupMatrix;
    }

    @Override
    public String toString() {
        return id.getPartFamily() + " " + id.getSeriesID();
    }
    
    @Override
 	public boolean equals(Object object) {
 		if (!(object instanceof PartFamilySeries)) {
 			return false;
 		}
 		PartFamilySeries other = (PartFamilySeries) object;
 		if (this.getId().getPartFamily() == other.getId().getPartFamily() && 
 				this.getId().getSeriesID() == other.getId().getSeriesID()) {
 			return true;
 		}
 		return false;
 	}
    
}

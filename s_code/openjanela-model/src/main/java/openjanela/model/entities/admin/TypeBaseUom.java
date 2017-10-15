/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "type_base_uom")
@Cacheable
public class TypeBaseUom implements Serializable {

	@Id
	@Column(name = "id")
	public Integer id;

	@Column(name = "description")
	public String description;

	@Column(name = "system_uom")
	public int systemUom;

	@Column(name = "base")
	public Integer base;

	@Column(name = "varconvert")
	public Boolean varconvert;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Column(name = "coverttobase")
	public Double coverttobase;

	@Column(name = "storageprecision")
	public Double storageprecision;

	@Column(name = "decimalprecision")
	public Double decimalprecision;

	@Column(name = "fractiondisplay")
	public Boolean fractiondisplay;

	@Column(name = "fractionprecison")
	public Integer fractionprecison;

    public TypeBaseUom() {
    }

    public TypeBaseUom(Integer id, String description, int systemUom, Integer base, Boolean varconvert, Double coverttobase,
                       Double storageprecision, Double decimalprecision, Boolean fractiondisplay, Integer fractionprecison) {
        this.id = id;
        this.description = description;
        this.systemUom = systemUom;
        this.base = base;
        this.varconvert = varconvert;
        this.coverttobase = coverttobase;
        this.storageprecision = storageprecision;
        this.decimalprecision = decimalprecision;
        this.fractiondisplay = fractiondisplay;
        this.fractionprecison = fractionprecison;
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
	
	public int getSystemUom() {
		return systemUom;
	}
	
	public void setSystemUom(int systemUom) {
		this.systemUom = systemUom;
	}
	
	public Integer getBase() {
		return base;
	}
	
	public void setBase(Integer base) {
		this.base = base;
	}
	
	public Boolean getVarconvert() {
		return varconvert;
	}
	
	public void setVarconvert(Boolean varconvert) {
		this.varconvert = varconvert;
	}
	
	public Double getCoverttobase() {
		return coverttobase;
	}
	
	public void setCoverttobase(Double coverttobase) {
		this.coverttobase = coverttobase;
	}
	
	public Double getStorageprecision() {
		return storageprecision;
	}
	
	public void setStorageprecision(Double storageprecision) {
		this.storageprecision = storageprecision;
	}
	
	public Double getDecimalprecision() {
		return decimalprecision;
	}
	
	public void setDecimalprecision(Double decimalprecision) {
		this.decimalprecision = decimalprecision;
	}
	
	public Boolean getFractiondisplay() {
		return fractiondisplay;
	}
	
	public void setFractiondisplay(Boolean fractiondisplay) {
		this.fractiondisplay = fractiondisplay;
	}
	
	public Integer getFractionprecison() {
		return fractionprecison;
	}
	
	public void setFractionprecison(Integer fractionprecison) {
		this.fractionprecison = fractionprecison;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof TypeBaseUom)) {
			return false;
		}
		TypeBaseUom other = (TypeBaseUom) object;
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

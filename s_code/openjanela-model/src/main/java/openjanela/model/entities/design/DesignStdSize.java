package openjanela.model.entities.design;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-19-13
 *          Time: 10:28 PM
 */
@Entity
@Table(name = "design_std_size")
public class DesignStdSize implements Serializable {

    @EmbeddedId
    private DesignStdSizePK id;

    @Column(name = "description")
    private String description ="";

    @Column(name = "price")
    private BigDecimal price;

    public DesignStdSize() {
    }

    public DesignStdSize(DesignStdSizePK id, String description, BigDecimal price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public DesignStdSizePK getId() {
        return id;
    }

    public void setId(DesignStdSizePK id) {
        this.id = id;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String toString() {
	        return this.description;
	    }
    
}

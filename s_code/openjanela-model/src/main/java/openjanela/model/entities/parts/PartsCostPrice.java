package openjanela.model.entities.parts;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * @author Sherif
 */

@Entity
@Table(name = "parts_costprice")
public class PartsCostPrice implements Serializable {
	
	//Serial Version Number
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	public PartsCostPricePK id;
	
	@Column(name = "priceuomconvert")
	public Double priceuomconvert = 0.0;
	
	@Column(name = "stdcost")
	public BigDecimal stdcost = new BigDecimal(0);
	
	@Column(name = "stdcostmatrix")
	public Integer stdcostmatrix = 0;
	
	@Column(name = "movingavgcost")
	public BigDecimal movingavgcost = new BigDecimal(0);
	
	@Column(name = "lifocost")
	public BigDecimal lifocost = new BigDecimal(0);
	
	@Column(name = "fifocost")
	public BigDecimal fifocost = new BigDecimal(0);
	
	@Column(name = "mostrecentcost")
	public BigDecimal mostrecentcost;
	
	@Column(name = "price")
	public BigDecimal price = new BigDecimal(0);
	
	@Column(name = "pricematrix")
	public Integer pricematrix = 0;
	
	@Column(name = "min_price")
	public BigDecimal minPrice = new BigDecimal(0);
	
	@Column(name = "notes")
	public String notes = "";
	
	@Column(name = "isdefault")
	public boolean isdefault = true;
	
	@Column(name = "description")
	public String description = "";
	
	@Column(name = "pricemeasure")
	public int pricemeasure = 1;
	
	@Column(name = "taxable")
	public boolean taxable;
	
	@Column(name = "discountable")
	public boolean discountable;
	
	@Column(name = "pricefromcost")
	public boolean pricefromcost;
	
	@Column(name = "price_markup")
	public double price_markup;
	
	@Column(name = "cost_markup")
	public double cost_markup;
	
	@Column(name = "costuom")
	public int costuom;

    ///Transient Values
    @Transient
    public boolean inclPrice;

    @Transient
    public boolean inclCost;

	public PartsCostPrice() {
		id = new PartsCostPricePK();
	}

    public PartsCostPrice(PartsCostPricePK id, Double priceuomconvert, BigDecimal stdcost, Integer stdcostmatrix,
                          BigDecimal movingavgcost, BigDecimal lifocost, BigDecimal fifocost, BigDecimal mostrecentcost,
                          BigDecimal price, Integer pricematrix, BigDecimal minPrice, String notes, boolean isdefault,
                          String description, int pricemeasure, boolean taxable, boolean discountable, boolean pricefromcost,
                          double price_markup, double cost_markup, int costuom) {

        this.id = id;
        this.priceuomconvert = priceuomconvert;
        this.stdcost = stdcost;
        this.stdcostmatrix = stdcostmatrix;
        this.movingavgcost = movingavgcost;
        this.lifocost = lifocost;
        this.fifocost = fifocost;
        this.mostrecentcost = mostrecentcost;
        this.price = price;
        this.pricematrix = pricematrix;
        this.minPrice = minPrice;
        this.notes = notes;
        this.isdefault = isdefault;
        this.description = description;
        this.pricemeasure = pricemeasure;
        this.taxable = taxable;
        this.discountable = discountable;
        this.pricefromcost = pricefromcost;
        this.price_markup = price_markup;
        this.cost_markup = cost_markup;
        this.costuom = costuom;
    }

    public PartsCostPricePK getId() {
		return id;
	}
	
	public void setId(PartsCostPricePK id) {
		this.id = id;
	}
	
	public Double getPriceuomconvert() {
		return priceuomconvert;
	}
	
	public void setPriceuomconvert(Double priceuomconvert) {
		this.priceuomconvert = priceuomconvert;
	}
	
	public BigDecimal getStdcost() {
		return stdcost;
	}
	
	public void setStdcost(BigDecimal stdcost) {
		this.stdcost = stdcost;
	}
	
	public Integer getStdcostmatrix() {
		return stdcostmatrix;
	}
	
	public void setStdcostmatrix(Integer stdcostmatrix) {
		this.stdcostmatrix = stdcostmatrix;
	}
	
	public BigDecimal getMovingavgcost() {
		return movingavgcost;
	}
	
	public void setMovingavgcost(BigDecimal movingavgcost) {
		this.movingavgcost = movingavgcost;
	}
	
	public BigDecimal getLifocost() {
		return lifocost;
	}
	
	public void setLifocost(BigDecimal lifocost) {
		this.lifocost = lifocost;
	}
	
	public BigDecimal getFifocost() {
		return fifocost;
	}
	
	public void setFifocost(BigDecimal fifocost) {
		this.fifocost = fifocost;
	}
	
	public BigDecimal getMostrecentcost() {
		return mostrecentcost;
	}
	
	public void setMostrecentcost(BigDecimal mostrecentcost) {
		this.mostrecentcost = mostrecentcost;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Integer getPricematrix() {
		return pricematrix;
	}
	
	public void setPricematrix(Integer pricematrix) {
		this.pricematrix = pricematrix;
	}
	
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public boolean isIsdefault() {
		return isdefault;
	}
	
	public void setIsdefault(boolean isdefault) {
		this.isdefault = isdefault;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPricemeasure() {
		return pricemeasure;
	}
	
	public void setPricemeasure(int pricemeasure) {
		this.pricemeasure = pricemeasure;
	}
	
	public boolean isTaxable() {
		return taxable;
	}
	
	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}
	
	public boolean isDiscountable() {
		return discountable;
	}
	
	public void setDiscountable(boolean discountable) {
		this.discountable = discountable;
	}
	
	public boolean isPricefromcost() {
		return pricefromcost;
	}
	
	public void setPricefromcost(boolean pricefromcost) {
		this.pricefromcost = pricefromcost;
	}
	
	public double getPrice_markup() {
		return price_markup;
	}
	
	public void setPrice_markup(double price_markup) {
		this.price_markup = price_markup;
	}
	
	public double getCost_markup() {
		return cost_markup;
	}
	
	public void setCost_markup(double cost_markup) {
		this.cost_markup = cost_markup;
	}

    public boolean isInclPrice() {
        return inclPrice;
    }

    public void setInclPrice(boolean inclPrice) {
        this.inclPrice = inclPrice;
    }

    public boolean isInclCost() {
        return inclCost;
    }

    public void setInclCost(boolean inclCost) {
        this.inclCost = inclCost;
    }

    @Override
	public boolean equals(Object object) {
		
		// TODO: Warning - this method won't work in the case the id fields
		// are not set
		if (!(object instanceof PartsCostPrice)) {
			return false;
		}
		PartsCostPrice other = (PartsCostPrice) object;
		if (this.getId().getPartid() == other.getId().getPartid() && id.getPriceuom() == other.getId().getPriceuom()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return description;
	}
}

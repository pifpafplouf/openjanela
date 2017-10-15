package openjanela.model.entities.design;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (c) 2013, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 01-19-13
 * Time: 01:12 PM
 */
@Entity
@Table(name = "design")
public class Design implements Serializable {

    @EmbeddedId
    private DesignPK id;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "designFamily", nullable = true)
    private int designFamily;
    @Column(name = "pricing_uom_id", nullable = true)
    private int pricingUOMId;
    @Column(name = "price_actual_size", nullable = true)
    private boolean priceActualSize;
    @Column(name = "price", nullable = true)
    private Double price;
    @Column(name = "matrix", nullable = true)
    private int matrixId;
    @Column(name = "price_group_id", nullable = true)
    private int priceGroupId;
    @Column(name = "min_price", nullable = true)
    private Double minPrice;
    @Column(name = "min_pricing_area", nullable = true)
    private Double minPricingArea;
    @Column(name = "startdate", nullable = false)
    private Date startDate;
    @Column(name = "enddate", nullable = false)
    private Date endDate;

    @Lob
    @Column(name = "scaledimage", nullable = true)
    private byte[] scaledImage;
    
    @Column(name = "width", nullable = false)
    private int width;
    
    @Column(name = "height", nullable = false)
    private int height;
    
    @Column(name = "widthi", nullable = false)
    private int widthi;
    
    @Column(name = "heighti", nullable = false)
    private int heighti;

    public Design() {
    }

    public Design(DesignPK id, String description, int designFamily, int pricingUOMId, boolean priceActualSize,
                  Double price, int matrixId, int priceGroupId, Double minPrice, Double minPricingArea, Date startDate,
                  Date endDate, byte[] scaledImage, int width, int height, int widthi, int heighti) {

        this.id = id;
        this.description = description;
        this.designFamily = designFamily;
        this.pricingUOMId = pricingUOMId;
        this.priceActualSize = priceActualSize;
        this.price = price;
        this.matrixId = matrixId;
        this.priceGroupId = priceGroupId;
        this.minPrice = minPrice;
        this.minPricingArea = minPricingArea;
        this.startDate = startDate;
        this.endDate = endDate;
        this.scaledImage = scaledImage;
        this.width = width;
        this.height = height;
        this.widthi = widthi;
        this.heighti = heighti;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public DesignPK getId() {
        return id;
    }

    public void setId(DesignPK id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDesignFamily() {
        return designFamily;
    }
    
    @Column(name = "heighti", nullable = false)
   
    public void setDesignFamily(int designFamily) {
        this.designFamily = designFamily;
    }

    public int getPricingUOMId() {
        return pricingUOMId;
    }

    public void setPricingUOMId(int pricingUOMId) {
        this.pricingUOMId = pricingUOMId;
    }

    public boolean isPriceActualSize() {
        return priceActualSize;
    }

    public void setPriceActualSize(boolean priceActualSize) {
        this.priceActualSize = priceActualSize;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getMatrixId() {
        return matrixId;
    }

    public void setMatrixId(int matrixId) {
        this.matrixId = matrixId;
    }

    public int getPriceGroupId() {
        return priceGroupId;
    }

    public void setPriceGroupId(int priceGroupId) {
        this.priceGroupId = priceGroupId;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMinPricingArea() {
        return minPricingArea;
    }

    public void setMinPricingArea(Double minPricingArea) {
        this.minPricingArea = minPricingArea;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public byte[] getScaledImage() {
        return scaledImage;
    }

    public void setScaledImage(byte[] scaledImage) {
        this.scaledImage = scaledImage;
    }

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidthi() {
		return widthi;
	}

	public void setWidthi(int widthi) {
		this.widthi = widthi;
	}

	public int getHeighti() {
		return heighti;
	}

	public void setHeighti(int heighti) {
		this.heighti = heighti;
	}
}

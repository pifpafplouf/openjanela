package openjanela.model.entities.partner;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-04-12
 *          Time: 09:28 AM
 */
@Entity
@Table(name = "series_valid_opening_shape")
@Cacheable
public class SeriesValidOpeningShape implements Serializable {

    @EmbeddedId
    private SeriesValidOpeningShapePK seriesValidOpeningPK;

    @Column(name = "pricing_uom_id")
    private Integer pricingUOMId;

    @Column(name = "price_actual_size")
    private Boolean priceActualSize;

    @Column(name = "price")
    private Double price;

    @Column(name = "matrix")
    private Integer matrix;

    @Column(name = "price_group_id")
    private Integer priceGroupId;

    @Column(name = "min_price")
    private Double minPrice;

    @Column(name = "min_pricing_area")
    private Double minPriceArea;

    @Column(name = "min_pricing_area_imp")
    private Double minPriceAreaImp;

    @Column(name = "min_width")
    private Integer minWidth;

    @Column(name = "min_width_imp")
    private Integer minWidthImp;

    @Column(name = "min_height")
    private Integer minHeight;

    @Column(name = "min_height_imp")
    private Integer minHeightImp;

    @Column(name = "max_width")
    private Integer maxWidth;

    @Column(name = "max_width_imp")
    private Integer maxWidthImp;

    @Column(name = "max_height")
    private Integer maxHeight;

    @Column(name = "max_height_imp")
    private Integer maxHeightImp;

    @Column(name = "max_area")
    private Integer maxArea;

    @Column(name = "max_area_imp")
    private Integer maxAreaImp;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "window")
    private boolean window;

    @Column(name = "door")
    private boolean door;

    @Column(name = "entrance")
    private boolean entrance;

    @Column(name = "standard")
    private boolean standard;

    @Column(name = "glazedout")
    private boolean glazedout;

    @Column(name = "louvresize")
    private int louvresize;

    @Column(name = "louvresizei")
    private int louvresizei;
    
    @Column(name = "louvreoverlap")
    private int louvreoverlap;
    
    @Column(name = "louvreoverlapi")
    private int louvreoverlapi;
    
    @Column(name = "louvrepartial")
    private boolean louvrepartial;
    
    @Column(name = "isglazed")
    private boolean glazed;

    @Column(name = "louvresash")
    private boolean louvresash;

    @Column(name = "louvre")
    private boolean louvre;

    @Column(name = "auto_subframe")
    private boolean auto_subframe;

    @Column(name = "auto_subsash")
    private boolean auto_subsash;

    @Column(name = "parent_frame_ud_id")
    private int parent_frame_ud_id;

    @Column(name = "out_track_sash_fixed")
    private boolean outTrackFixed;

    @Column(name = "sequence")
    private int sequence;

    @Transient
    private int supplierId;
    
    @Transient
    private boolean remote;
    
    /**
     * Series Valid Opening Shape constructor
     */
    public SeriesValidOpeningShape() {
    	
    }

    /**
     * Series Valid Opening Shape constructor
     *
     * @param pk, Series Valid Opening Shape Primary Key
     */
    public SeriesValidOpeningShape(SeriesValidOpeningShapePK pk) {
        this.seriesValidOpeningPK = pk;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

    public SeriesValidOpeningShapePK getSeriesValidOpeningPK() {
        return seriesValidOpeningPK;
    }

    public void setSeriesValidOpeningPK(SeriesValidOpeningShapePK seriesValidOpeningPK) {
        this.seriesValidOpeningPK = seriesValidOpeningPK;
    }

    public Integer getPricingUOMId() {
        return pricingUOMId;
    }

    public void setPricingUOMId(Integer pricingUOMId) {
        this.pricingUOMId = pricingUOMId;
    }

    public Boolean getPriceActualSize() {
        return priceActualSize;
    }

    public void setPriceActualSize(Boolean priceActualSize) {
        this.priceActualSize = priceActualSize;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getMatrix() {
        return matrix;
    }

    public void setMatrix(Integer matrix) {
        this.matrix = matrix;
    }

    public Integer getPriceGroupId() {
        return priceGroupId;
    }

    public void setPriceGroupId(Integer priceGroupId) {
        this.priceGroupId = priceGroupId;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMinPriceArea() {
        return minPriceArea;
    }

    public void setMinPriceArea(Double minPriceArea) {
        this.minPriceArea = minPriceArea;
    }

    public Double getMinPriceAreaImp() {
        return minPriceAreaImp;
    }

    public void setMinPriceAreaImp(Double minPriceAreaImp) {
        this.minPriceAreaImp = minPriceAreaImp;
    }

    public Integer getMinWidth() {
        return minWidth;
    }

    public void setMinWidth(Integer minWidth) {
        this.minWidth = minWidth;
    }

    public Integer getMinWidthImp() {
        return minWidthImp;
    }

    public void setMinWidthImp(Integer minWidthImp) {
        this.minWidthImp = minWidthImp;
    }

    public Integer getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Integer minHeight) {
        this.minHeight = minHeight;
    }

    public Integer getMinHeightImp() {
        return minHeightImp;
    }

    public void setMinHeightImp(Integer minHeightImp) {
        this.minHeightImp = minHeightImp;
    }

    public Integer getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Integer getMaxWidthImp() {
        return maxWidthImp;
    }

    public void setMaxWidthImp(Integer maxWidthImp) {
        this.maxWidthImp = maxWidthImp;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Integer getMaxHeightImp() {
        return maxHeightImp;
    }

    public void setMaxHeightImp(Integer maxHeightImp) {
        this.maxHeightImp = maxHeightImp;
    }

    public Integer getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(Integer maxArea) {
        this.maxArea = maxArea;
    }

    public Integer getMaxAreaImp() {
        return maxAreaImp;
    }

    public void setMaxAreaImp(Integer maxAreaImp) {
        this.maxAreaImp = maxAreaImp;
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

    public boolean isWindow() {
        return window;
    }

    public void setWindow(boolean window) {
        this.window = window;
    }

    public boolean isDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    public boolean isEntrance() {
        return entrance;
    }

    public void setEntrance(boolean entrance) {
        this.entrance = entrance;
    }

    public boolean isStandard() {
        return standard;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }

    public boolean isGlazedout() {
        return glazedout;
    }

    public void setGlazedout(boolean glazedout) {
        this.glazedout = glazedout;
    }

    public int getLouvresize() {
        return louvresize;
    }

    public void setLouvresize(int louvresize) {
        this.louvresize = louvresize;
    }

    public int getLouvresizei() {
        return louvresizei;
    }

    public void setLouvresizei(int louvresizei) {
        this.louvresizei = louvresizei;
    }

    public int getLouvreoverlap() {
        return louvreoverlap;
    }

    public void setLouvreoverlap(int louvreoverlap) {
        this.louvreoverlap = louvreoverlap;
    }

    public int getLouvreoverlapi() {
        return louvreoverlapi;
    }

    public void setLouvreoverlapi(int louvreoverlapi) {
        this.louvreoverlapi = louvreoverlapi;
    }

    public boolean isLouvrepartial() {
        return louvrepartial;
    }

    public void setLouvrepartial(boolean louvrepartial) {
        this.louvrepartial = louvrepartial;
    }

    public boolean isGlazed() {
        return glazed;
    }

    public void setGlazed(boolean glazed) {
        this.glazed = glazed;
    }

    public boolean isLouvresash() {
        return louvresash;
    }

    public void setLouvresash(boolean louvresash) {
        this.louvresash = louvresash;
    }

    public boolean isLouvre() {
        return louvre;
    }

    public void setLouvre(boolean louvre) {
        this.louvre = louvre;
    }

    public boolean isAuto_subframe() {
        return auto_subframe;
    }

    public void setAuto_subframe(boolean auto_subframe) {
        this.auto_subframe = auto_subframe;
    }

    public boolean isAuto_subsash() {
        return auto_subsash;
    }

    public void setAuto_subsash(boolean auto_subsash) {
        this.auto_subsash = auto_subsash;
    }

    public int getParent_frame_ud_id() {
        return parent_frame_ud_id;
    }

    public void setParent_frame_ud_id(int parent_frame_ud_id) {
        this.parent_frame_ud_id = parent_frame_ud_id;
    }

	public boolean isOutTrackFixed() {
		return outTrackFixed;
	}

	public void setOutTrackFixed(boolean outTrackFixed) {
		this.outTrackFixed = outTrackFixed;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }
}

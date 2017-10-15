package openjanela.model.entities.design;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2013, OpenJanela. All rights reserved. User: Eddy Montenegro
 * Date: 01-19-13 Time: 10:30 PM
 */
@Embeddable
public class DesignStdSizePK implements Serializable {

	@Column(name = "design_id")
	private Integer designid;
	@Column(name = "series_id")
	private Integer seriesid;
	@Column(name = "width_i")
	private Integer widthi;
	@Column(name = "height_i")
	private Integer heighti;
	@Column(name = "width_m")
	private Integer widthm;
	@Column(name = "height_m")
	private Integer heightm;

	public DesignStdSizePK() {
	}

	public DesignStdSizePK(Integer Id, Integer seriesId, Integer wi,
			Integer hi, Integer wm, Integer hm) {
		this.designid = Id;
		this.seriesid = seriesId;
		this.widthi = wi;
		this.heighti = hi;
		this.widthm = wm;
		this.heightm = hm;

	}

	public Integer getDesignid() {
		return designid;
	}

	public void setDesignid(Integer designid) {
		this.designid = designid;
	}

	public Integer getSeriesid() {
		return seriesid;
	}

	public void setSeriesid(Integer seriesid) {
		this.seriesid = seriesid;
	}

	public Integer getWidthi() {
		return widthi;
	}

	public void setWidthi(Integer widthi) {
		this.widthi = widthi;
	}

	public Integer getHeighti() {
		return heighti;
	}

	public void setHeighti(Integer heighti) {
		this.heighti = heighti;
	}

	public Integer getWidthm() {
		return widthm;
	}

	public void setWidthm(Integer widthm) {
		this.widthm = widthm;
	}

	public Integer getHeightm() {
		return heightm;
	}

	public void setHeightm(Integer heightm) {
		this.heightm = heightm;
	}

}

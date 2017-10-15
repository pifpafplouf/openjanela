package openjanela.model.entities.partner;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 09:25 PM
 */
@Entity
@Table(name = "series")
@Cacheable
public class Series implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = true)
    private String description = "";

    @Column(name = "description_long", nullable = true)
    private String descriptionLong = "";

    @Column(name = "continuity", nullable = true)
    private Integer continuity = 1;

    @Column(name = "decimals_metric", nullable = true)
    private Integer decimalsMetric = 2;

    @Column(name = "decimals_imp", nullable = true)
    private Integer decimalsImp = 6;

    @Column(name = "grid_width_ideal", nullable = true)
    private Integer gridWidthIdeal = 0;

    @Column(name = "grid_width_min", nullable = false)
    private int gridWidthMin = 0;

    @Column(name = "grid_width_max", nullable = false)
    private int gridWidthMax = 0;

    @Column(name = "grid_height_ideal", nullable = false)
    private int gridHeightIdeal = 0;

    @Column(name = "grid_height_min", nullable = false)
    private int gridHeightMin = 0;

    @Column(name = "grid_height_max", nullable = false)
    private int gridHeightMax = 0;

    @Column(name = "rounding", nullable = false)
    private double rounding = 0;

    @Column(name = "frame_depth", nullable = false)
    private int frameDepth = 0;

    @Column(name = "frame_depth_imp", nullable = false)
    private int frameDepthImp = 0;

    @Column(name = "default_lead_time", nullable = false)
    private int defaultLeadTime = 0;

    @Column(name = "facet_min_width", nullable = false)
    private int facetMinWidth = 0;

    @Column(name = "facet_min_height", nullable = false)
    private int facetMinHeight = 0;

    @Column(name = "feet_inch_adjustment", nullable = false)
    private double feetInchAdjustment = 0;

    @Column(name = "default_bay_center_split", nullable = false)
    private double defaultBayCenterSplit = 0;

    @Column(name = "default_opening_type", nullable = false)
    private int defaultOpeningType = 0;

    @Column(name = "frame_in_out_by_any", nullable = false)
    private boolean frameInOutByAny = false;

    @Column(name = "default_opening_class", nullable = false)
    private int defaultOpeningClass = 0;

    @Column(name = "made_in", nullable = false)
    private boolean madeIn = false;

    @Column(name = "supplier_id", nullable = false)
    private int supplierId = 0;

    @Column(name = "supplier_url", nullable = false)
    private String supplierUrl = "";

    @Column(name = "supplier_accountno", nullable = false)
    private int supplierAccountno = 0;

    @Column(name = "supplier_password", nullable = false)
    private String supplierPassword = "";

    @Column(name = "supplier_series_id", nullable = false)
    private int supplierSeriesId = 0;

    @Column(name = "active", nullable = false)
    private boolean active = false;

    @Column(name = "category_id", nullable = false)
    private int categoryId = 0;

    @Column(name = "series_uom", nullable = false)
    private int seriesUom = 0;

    @Column(name = "display_order", nullable = false)
    private int displayOrder = 0;

    @Column(name = "isseg", nullable = false)
    private int isseg = 0;

    @Column(name = "globalsegid", nullable = false)
    private int globalsegid = 0;

    @Column(name = "qtydiscountmatrix", nullable = false)
    private int qtydiscountmatrix = 0;

    @Column(name = "grid_width_ideal_i", nullable = false)
    private int gridWidthIdealI = 0;

    @Column(name = "grid_width_min_i", nullable = false)
    private int gridWidthMinI = 0;

    @Column(name = "grid_width_max_i", nullable = false)
    private int gridWidthMaxI = 0;

    @Column(name = "grid_height_ideal_i", nullable = false)
    private int gridHeightIdealI = 0;

    @Column(name = "grid_height_min_i", nullable = false)
    private int gridHeightMinI = 0;

    @Column(name = "grid_height_max_i", nullable = false)
    private int gridHeightMaxI = 0;

    @Column(name = "facet_min_width_i", nullable = false)
    private int facetMinWidthI = 0;

    @Column(name = "facet_min_height_i", nullable = false)
    private int facetMinHeightI = 0;

    @Column(name = "glazedout", nullable = false)
    private boolean glazedout = false;

    @Column(name = "opening_in", nullable = false)
    private boolean openingIn = false;

    @Column(name = "opening_mid", nullable = false)
    private boolean openingMid = false;

    @Column(name = "opening_out", nullable = false)
    private boolean openingOut = false;

    @Column(name = "sub_frame", nullable = false)
    private boolean subFrame = false;

    @Column(name = "sub_sash", nullable = false)
    private boolean subSash = false;
    
    @Column(name = "manual_frame_endtypes", nullable = false)
    private boolean manualFET = false;
    
    @Column(name = "manual_sash_endtypes", nullable = false)
    private boolean manualSET = false;
    
    @Column(name = "manual_subframe_endtypes", nullable = false)
    private boolean manualSFET = false;
    
    @Column(name = "manual_subsash_endtypes", nullable = false)
    private boolean manualSSET = false;
    
    @Column(name = "manual_frame_profile_select", nullable = false)
    private boolean manualFPS = false;
    
    @Column(name = "manual_sash_profile_select", nullable = false)
    private boolean manualSPS = false;
    
    @Column(name = "manual_subframe_profle_select", nullable = false)
    private boolean manualSFPS = false;
    
    @Column(name = "manual_subsash_profile_select", nullable = false)
    private boolean manualSsPS = false;
       
    @Column(name = "custom_frame_profile", nullable = false)
    private boolean customFP = false;
    
    @Column(name = "custom_sash_profile", nullable = false)
    private boolean customSP = false;
    
    @Column(name = "custom_subframe_profile", nullable = false)
    private boolean customSFP = false;
    
    @Column(name = "custom_subsash_profile", nullable = false)
    private boolean customSSP = false;
    
    @Column(name = "manual_mullion_endtypes", nullable = false)
    private boolean manualMET = false;
    
    @Column(name = "manual_mullion_profile_select", nullable = false)
    private boolean manualMP = false;
    
    @Column(name = "custom_mullion_profile", nullable = false)
    private boolean customMP = false;
    
    @Column(name = "manual_mullion_continuity", nullable = false)
    private boolean manualMC = false;
    
    @Column(name = "edit_profile", nullable = false)
    private boolean editP = false;
    
    @Column(name = "remove_profile", nullable = false)
    private boolean removeP = false;
    
    @Column(name = "pref_save_dim_frame", nullable = false)
    private boolean frameDim = false;

    public Series() {
    }

    public Series(Integer id, String description, String descriptionLong, Integer continuity, Integer decimalsMetric,
                  Integer decimalsImp, Integer gridWidthIdeal, int gridWidthMin, int gridWidthMax, int gridHeightIdeal,
                  int gridHeightMin, int gridHeightMax, double rounding, int frameDepth, int frameDepthImp,
                  int defaultLeadTime, int facetMinWidth, int facetMinHeight, double feetInchAdjustment,
                  double defaultBayCenterSplit, int defaultOpeningType, boolean frameInOutByAny, int defaultOpeningClass,
                  boolean madeIn, int supplierId, String supplierUrl, int supplierAccountno, String supplierPassword,
                  int supplierSeriesId, boolean active, int categoryId, int seriesUom, int displayOrder, int isseg,
                  int globalsegid, int qtydiscountmatrix, int gridWidthIdealI, int gridWidthMinI, int gridWidthMaxI,
                  int gridHeightIdealI, int gridHeightMinI, int gridHeightMaxI, int facetMinWidthI, int facetMinHeightI,
                  boolean glazedout, boolean openingIn, boolean openingMid, boolean openingOut, boolean subFrame,
                  boolean subSash, boolean manualFET, boolean manualSET, boolean manualSFET, boolean manualSSET,
                  boolean manualFPS, boolean manualSPS, boolean manualSFPS, boolean manualSsPS, boolean customFP,
                  boolean customSP, boolean customSFP, boolean customSSP, boolean manualMET, boolean manualMP,
                  boolean customMP, boolean manualMC, boolean editP, boolean removeP, boolean frameDim) {

        this.id = id;
        this.description = description;
        this.descriptionLong = descriptionLong;
        this.continuity = continuity;
        this.decimalsMetric = decimalsMetric;
        this.decimalsImp = decimalsImp;
        this.gridWidthIdeal = gridWidthIdeal;
        this.gridWidthMin = gridWidthMin;
        this.gridWidthMax = gridWidthMax;
        this.gridHeightIdeal = gridHeightIdeal;
        this.gridHeightMin = gridHeightMin;
        this.gridHeightMax = gridHeightMax;
        this.rounding = rounding;
        this.frameDepth = frameDepth;
        this.frameDepthImp = frameDepthImp;
        this.defaultLeadTime = defaultLeadTime;
        this.facetMinWidth = facetMinWidth;
        this.facetMinHeight = facetMinHeight;
        this.feetInchAdjustment = feetInchAdjustment;
        this.defaultBayCenterSplit = defaultBayCenterSplit;
        this.defaultOpeningType = defaultOpeningType;
        this.frameInOutByAny = frameInOutByAny;
        this.defaultOpeningClass = defaultOpeningClass;
        this.madeIn = madeIn;
        this.supplierId = supplierId;
        this.supplierUrl = supplierUrl;
        this.supplierAccountno = supplierAccountno;
        this.supplierPassword = supplierPassword;
        this.supplierSeriesId = supplierSeriesId;
        this.active = active;
        this.categoryId = categoryId;
        this.seriesUom = seriesUom;
        this.displayOrder = displayOrder;
        this.isseg = isseg;
        this.globalsegid = globalsegid;
        this.qtydiscountmatrix = qtydiscountmatrix;
        this.gridWidthIdealI = gridWidthIdealI;
        this.gridWidthMinI = gridWidthMinI;
        this.gridWidthMaxI = gridWidthMaxI;
        this.gridHeightIdealI = gridHeightIdealI;
        this.gridHeightMinI = gridHeightMinI;
        this.gridHeightMaxI = gridHeightMaxI;
        this.facetMinWidthI = facetMinWidthI;
        this.facetMinHeightI = facetMinHeightI;
        this.glazedout = glazedout;
        this.openingIn = openingIn;
        this.openingMid = openingMid;
        this.openingOut = openingOut;
        this.subFrame = subFrame;
        this.subSash = subSash;
        this.manualFET = manualFET;
        this.manualSET = manualSET;
        this.manualSFET = manualSFET;
        this.manualSSET = manualSSET;
        this.manualFPS = manualFPS;
        this.manualSPS = manualSPS;
        this.manualSFPS = manualSFPS;
        this.manualSsPS = manualSsPS;
        this.customFP = customFP;
        this.customSP = customSP;
        this.customSFP = customSFP;
        this.customSSP = customSSP;
        this.manualMET = manualMET;
        this.manualMP = manualMP;
        this.customMP = customMP;
        this.manualMC = manualMC;
        this.editP = editP;
        this.removeP = removeP;
        this.frameDim = frameDim;
    }

    //*************************************************<GETTERS & SETTERS>**********************************************

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

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }

    public Integer getContinuity() {
        return continuity;
    }

    public void setContinuity(Integer continuity) {
        this.continuity = continuity;
    }

    public Integer getDecimalsMetric() {
        return decimalsMetric;
    }

    public void setDecimalsMetric(Integer decimalsMetric) {
        this.decimalsMetric = decimalsMetric;
    }

    public Integer getDecimalsImp() {
        return decimalsImp;
    }

    public void setDecimalsImp(Integer decimalsImp) {
        this.decimalsImp = decimalsImp;
    }

    public Integer getGridWidthIdeal() {
        return gridWidthIdeal;
    }

    public void setGridWidthIdeal(Integer gridWidthIdeal) {
        this.gridWidthIdeal = gridWidthIdeal;
    }

    public int getGridWidthMin() {
        return gridWidthMin;
    }

    public void setGridWidthMin(int gridWidthMin) {
        this.gridWidthMin = gridWidthMin;
    }

    public int getGridWidthMax() {
        return gridWidthMax;
    }

    public void setGridWidthMax(int gridWidthMax) {
        this.gridWidthMax = gridWidthMax;
    }

    public int getGridHeightIdeal() {
        return gridHeightIdeal;
    }

    public void setGridHeightIdeal(int gridHeightIdeal) {
        this.gridHeightIdeal = gridHeightIdeal;
    }

    public int getGridHeightMin() {
        return gridHeightMin;
    }

    public void setGridHeightMin(int gridHeightMin) {
        this.gridHeightMin = gridHeightMin;
    }

    public int getGridHeightMax() {
        return gridHeightMax;
    }

    public void setGridHeightMax(int gridHeightMax) {
        this.gridHeightMax = gridHeightMax;
    }

    public double getRounding() {
        return rounding;
    }

    public void setRounding(double rounding) {
        this.rounding = rounding;
    }

    public int getFrameDepth() {
        return frameDepth;
    }

    public void setFrameDepth(int frameDepth) {
        this.frameDepth = frameDepth;
    }

    public int getFrameDepthImp() {
        return frameDepthImp;
    }

    public void setFrameDepthImp(int frameDepthImp) {
        this.frameDepthImp = frameDepthImp;
    }

    public int getDefaultLeadTime() {
        return defaultLeadTime;
    }

    public void setDefaultLeadTime(int defaultLeadTime) {
        this.defaultLeadTime = defaultLeadTime;
    }

    public int getFacetMinWidth() {
        return facetMinWidth;
    }

    public void setFacetMinWidth(int facetMinWidth) {
        this.facetMinWidth = facetMinWidth;
    }

    public int getFacetMinHeight() {
        return facetMinHeight;
    }

    public void setFacetMinHeight(int facetMinHeight) {
        this.facetMinHeight = facetMinHeight;
    }

    public double getFeetInchAdjustment() {
        return feetInchAdjustment;
    }

    public void setFeetInchAdjustment(double feetInchAdjustment) {
        this.feetInchAdjustment = feetInchAdjustment;
    }

    public double getDefaultBayCenterSplit() {
        return defaultBayCenterSplit;
    }

    public void setDefaultBayCenterSplit(double defaultBayCenterSplit) {
        this.defaultBayCenterSplit = defaultBayCenterSplit;
    }

    public int getDefaultOpeningType() {
        return defaultOpeningType;
    }

    public void setDefaultOpeningType(int defaultOpeningType) {
        this.defaultOpeningType = defaultOpeningType;
    }

    public boolean getFrameInOutByAny() {
        return frameInOutByAny;
    }

    public void setFrameInOutByAny(boolean frameInOutByAny) {
        this.frameInOutByAny = frameInOutByAny;
    }

    public int getDefaultOpeningClass() {
        return defaultOpeningClass;
    }

    public void setDefaultOpeningClass(int defaultOpeningClass) {
        this.defaultOpeningClass = defaultOpeningClass;
    }

    public boolean getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(boolean madeIn) {
        this.madeIn = madeIn;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierUrl() {
        return supplierUrl;
    }

    public void setSupplierUrl(String supplierUrl) {
        this.supplierUrl = supplierUrl;
    }

    public boolean isGlazedout() {
        return glazedout;
    }

    public void setGlazedout(boolean glazedout) {
        this.glazedout = glazedout;
    }

    public int getSupplierAccountno() {
        return supplierAccountno;
    }

    public void setSupplierAccountno(int supplierAccountno) {
        this.supplierAccountno = supplierAccountno;
    }

    public String getSupplierPassword() {
        return supplierPassword;
    }

    public void setSupplierPassword(String supplierPassword) {
        this.supplierPassword = supplierPassword;
    }

    public int getSupplierSeriesId() {
        return supplierSeriesId;
    }

    public void setSupplierSeriesId(int supplierSeriesId) {
        this.supplierSeriesId = supplierSeriesId;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSeriesUom() {
        return seriesUom;
    }

    public void setSeriesUom(int seriesUom) {
        this.seriesUom = seriesUom;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public int getIsseg() {
        return isseg;
    }

    public void setIsseg(int isseg) {
        this.isseg = isseg;
    }

    public int getGlobalsegid() {
        return globalsegid;
    }

    public void setGlobalsegid(int globalsegid) {
        this.globalsegid = globalsegid;
    }

    public int getQtydiscountmatrix() {
        return qtydiscountmatrix;
    }

    public void setQtydiscountmatrix(int qtydiscountmatrix) {
        this.qtydiscountmatrix = qtydiscountmatrix;
    }

    public int getGridWidthIdealI() {
        return gridWidthIdealI;
    }

    public void setGridWidthIdealI(int gridWidthIdealI) {
        this.gridWidthIdealI = gridWidthIdealI;
    }

    public int getGridWidthMinI() {
        return gridWidthMinI;
    }

    public void setGridWidthMinI(int gridWidthMinI) {
        this.gridWidthMinI = gridWidthMinI;
    }

    public int getGridWidthMaxI() {
        return gridWidthMaxI;
    }

    public void setGridWidthMaxI(int gridWidthMaxI) {
        this.gridWidthMaxI = gridWidthMaxI;
    }

    public int getGridHeightIdealI() {
        return gridHeightIdealI;
    }

    public void setGridHeightIdealI(int gridHeightIdealI) {
        this.gridHeightIdealI = gridHeightIdealI;
    }

    public int getGridHeightMinI() {
        return gridHeightMinI;
    }

    public void setGridHeightMinI(int gridHeightMinI) {
        this.gridHeightMinI = gridHeightMinI;
    }

    public int getGridHeightMaxI() {
        return gridHeightMaxI;
    }

    public void setGridHeightMaxI(int gridHeightMaxI) {
        this.gridHeightMaxI = gridHeightMaxI;
    }

    public int getFacetMinWidthI() {
        return facetMinWidthI;
    }

    public void setFacetMinWidthI(int facetMinWidthI) {
        this.facetMinWidthI = facetMinWidthI;
    }

    public int getFacetMinHeightI() {
        return facetMinHeightI;
    }

    public void setFacetMinHeightI(int facetMinHeightI) {
        this.facetMinHeightI = facetMinHeightI;
    }

    
public boolean isManualFET()
{

	return manualFET;
}


public void setManualFET(boolean manualFET)
{

	this.manualFET = manualFET;
}


public boolean isManualSET()
{

	return manualSET;
}


public void setManualSET(boolean manualSET)
{

	this.manualSET = manualSET;
}


public boolean isManualSFET()
{

	return manualSFET;
}


public void setManualSFET(boolean manualSFET)
{

	this.manualSFET = manualSFET;
}


public boolean isManualSSET()
{

	return manualSSET;
}


public void setManualSSET(boolean manualSSET)
{

	this.manualSSET = manualSSET;
}


public boolean isManualFPS()
{

	return manualFPS;
}


public void setManualFPS(boolean manualFPS)
{

	this.manualFPS = manualFPS;
}


public boolean isManualSPS()
{

	return manualSPS;
}


public void setManualSPS(boolean manualSPS)
{

	this.manualSPS = manualSPS;
}


public boolean isManualSFPS()
{

	return manualSFPS;
}


public void setManualSFPS(boolean manualSFPS)
{

	this.manualSFPS = manualSFPS;
}


public boolean isManualSsPS()
{

	return manualSsPS;
}


public void setManualSsPS(boolean manualSsPS)
{

	this.manualSsPS = manualSsPS;
}


public boolean isCustomFP()
{

	return customFP;
}


public void setCustomFP(boolean customFP)
{

	this.customFP = customFP;
}


public boolean isCustomSP()
{

	return customSP;
}


public void setCustomSP(boolean customSP)
{

	this.customSP = customSP;
}


public boolean isCustomSFP()
{

	return customSFP;
}


public void setCustomSFP(boolean customSFP)
{

	this.customSFP = customSFP;
}


public boolean isCustomSSP()
{

	return customSSP;
}


public void setCustomSSP(boolean customSSP)
{

	this.customSSP = customSSP;
}



public boolean isEditP()
{

	return editP;
}


public void setEditP(boolean editP)
{

	this.editP = editP;
}


public boolean isRemoveP()
{

	return removeP;
}


public void setRemoveP(boolean removeP)
{

	this.removeP = removeP;
}

public boolean isManualMET()
{

	return manualMET;
}


public void setManualMET(boolean manualMET)
{

	this.manualMET = manualMET;
}


public boolean isManualMP()
{

	return manualMP;
}


public void setManualMP(boolean manualMP)
{

	this.manualMP = manualMP;
}


public boolean isCustomMP()
{

	return customMP;
}


public void setCustomMP(boolean customMP)
{

	this.customMP = customMP;
}


public boolean isManualMC()
{

	return manualMC;
}


public void setManualMC(boolean manualMC)
{

	this.manualMC = manualMC;
}

public boolean isOpeningIn() {
        return openingIn;
    }

    public void setOpeningIn(boolean openingIn) {
        this.openingIn = openingIn;
    }

    public boolean isOpeningMid() {
        return openingMid;
    }

    public void setOpeningMid(boolean openingMid) {
        this.openingMid = openingMid;
    }

    public boolean isOpeningOut() {
        return openingOut;
    }

    public void setOpeningOut(boolean openingOut) {
        this.openingOut = openingOut;
    }

    public boolean isSubFrame() {
        return subFrame;
    }

    public void setSubFrame(boolean subFrame) {
        this.subFrame = subFrame;
    }

    public boolean isSubSash() {
        return subSash;
    }

    public void setSubSash(boolean subSash) {
        this.subSash = subSash;
    }
    
   

    
public boolean isFrameDim()
{

	return frameDim;
}


public void setFrameDim(boolean frameDim)
{

	this.frameDim = frameDim;
}

@Override
    public String toString() {
        return this.getDescription();
    }

}

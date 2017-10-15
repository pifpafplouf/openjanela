
package openjanela.model.entities.design;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8 Date: 03-06-12 Time: 04:15 PM
 */
public class GlassSUEntityObject extends ShapeAbstractObject {

    //Serializable version
    private static final long serialVersionUID = -6140807902584302851L;

    private String stockCode = "";

    private String description = "";

    private String abbrev = "";

    private Date startDate = new Date();

    private Date endDate = new Date();

    private boolean priceActualSize = false;

    private boolean costActualSize = false;

    private boolean display = false;

    private boolean madeIn = false;

    private boolean isCustom = false;

    private int suId = 0;

    private int assemblyID = 0;

    private int minWidth = 0;

    private int minWidthImp = 0;

    private int minHeight = 0;

    private int minHeightImp = 0;

    private int pricingUOMId = 0;

    private int priceMatrixId = 0;

    private int costGroupId = 0;

    private int priceGroupId = 0;

    private int partnerGroupId = 0;

    private int nextItem = 0;

    private int supplierId = 0;

    private int leadTime = 0;

    private int productionLine = 0;

    private int sortSeq = 0;

    private int glazingType = 0;

    private int numOfLeaves = 0;

    private int leafNo = 0;

    private int leafIn = 0;

    private int leaf_1 = 0;

    private int leaf_2 = 0;

    private int leaf_3 = 0;

    private int leaf_4 = 0;

    private int leafOut = 0;

    private int spacer_1 = 0;

    private int spacer_2 = 0;

    private int spacer_3 = 0;

    private int gas_1 = 0;

    private int gas_2 = 0;

    private int gas_3 = 0;

    private int film_1 = 0;

    private int film_2 = 0;

    private int film_3 = 0;

    private int film_4 = 0;

    private int process_1 = 0;

    private int process_2 = 0;

    private int process_3 = 0;

    private int process_4 = 0;

    private int cavityProcess_1 = 0;

    private int cavityProcess_2 = 0;

    private int cavityProcess_3 = 0;

    private int cavity_1_Process_2 = 0;

    private int cavity_2_Process_2 = 0;

    private int cavity_3_Process_2 = 0;

    private int cavity_1_Process_3 = 0;

    private int cavity_2_Process_3 = 0;

    private int cavity_3_Process_3 = 0;

    private int externalProcess_1 = 0;

    private int externalProcess_2 = 0;

    private int externalProcess_3 = 0;

    private int externalProcess_4 = 0;

    private int external_1_Process_2 = 0;

    private int external_2_Process_2 = 0;

    private int external_3_Process_2 = 0;

    private int external_4_Process_2 = 0;

    private int external_1_Process_3 = 0;

    private int external_2_Process_3 = 0;

    private int external_3_Process_3 = 0;

    private int external_4_Process_3 = 0;

    private int glass_1 = 0;

    private int glass_2 = 0;

    private int glass_3 = 0;

    private int glass_4 = 0;

    private int glass_1_Process_2 = 0;

    private int glass_2_Process_2 = 0;

    private int glass_3_Process_2 = 0;

    private int glass_4_Process_2 = 0;

    private int glass_1_Process_3 = 0;

    private int glass_2_Process_3 = 0;

    private int glass_3_Process_3 = 0;

    private int glass_4_Process_3 = 0;

    private int family_id = 0;

    private int insert_id_1 = 0;

    private int insert_id_2 = 0;

    private int insert_id_3 = 0;

    private BigDecimal minArea = new BigDecimal("0");

    private BigDecimal minAreaImp = new BigDecimal("0");

    private BigDecimal maxArea = new BigDecimal("0");

    private BigDecimal maxAreaImp = new BigDecimal("0");

    private BigDecimal whRatio = new BigDecimal("0");

    private BigDecimal cost = new BigDecimal("0");

    private BigDecimal price = new BigDecimal("0");

    private BigDecimal minPricingArea = new BigDecimal("0");

    private BigDecimal minPricingAreaImp = new BigDecimal("0");

    private BigDecimal minPrice = new BigDecimal("0");

    private BigDecimal waste = new BigDecimal("0");

    private BigDecimal minCostArea = new BigDecimal("0");

    private BigDecimal minCostAreaImp = new BigDecimal("0");

    private BigDecimal thickness = new BigDecimal("0");

    private BigDecimal thicknessImp = new BigDecimal("0");

    private BigDecimal spacerThick_1 = new BigDecimal("0");

    private BigDecimal spacerThick_2 = new BigDecimal("0");

    private BigDecimal spacerThick_3 = new BigDecimal("0");

    private BigDecimal spacerThick_1_i = new BigDecimal("0");

    private BigDecimal spacerThick_2_i = new BigDecimal("0");

    private BigDecimal spacerThick_3_i = new BigDecimal("0");

    private BigDecimal glassToSpacer = new BigDecimal("0");

    private BigDecimal glassToSpacerImp = new BigDecimal("0");

    private BigDecimal airSpace_1 = new BigDecimal("0");

    private BigDecimal airSpace_2 = new BigDecimal("0");

    private BigDecimal airSpace_3 = new BigDecimal("0");

    private BigDecimal airSpace_1_i = new BigDecimal("0");

    private BigDecimal airSpace_2_i = new BigDecimal("0");

    private BigDecimal airSpace_3_i = new BigDecimal("0");

    private int gridID = 0;

    private int gridType = 0;

    private int noGridsV = 0;

    private int noGridsH = 0;

    private int noGridsS = 0;

    private int noGridsR = 0;
    
    private int partFamily = 0;

    /**
     * Bkgrd Opening entity relationship
     */
    private BkgrdOpeningEntityObject bkgrdOpening;

    /**
     * Opening Collection entities
     */
    private Set<OpeningEntityObject> openings;

    /**
     * Design Glass Bom Collection
     */
    private Set<DesignGlassEntityObject> glassBom;

    // ==================================<METODOS GETTTER AND SETTERS>=================================================

    public int getSuId() {
        return suId;
    }

    public void setSuId(int suId) {
        this.suId = suId;
    }

    public int getAssemblyID() {
        return assemblyID;
    }

    public void setAssemblyID(int assemblyID) {
        this.assemblyID = assemblyID;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public BigDecimal getMinArea() {
        return minArea;
    }

    public void setMinArea(BigDecimal minArea) {
        this.minArea = minArea;
    }

    public BigDecimal getMinAreaImp() {
        return minAreaImp;
    }

    public void setMinAreaImp(BigDecimal minAreaImp) {
        this.minAreaImp = minAreaImp;
    }

    public BigDecimal getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(BigDecimal maxArea) {
        this.maxArea = maxArea;
    }

    public BigDecimal getMaxAreaImp() {
        return maxAreaImp;
    }

    public void setMaxAreaImp(BigDecimal maxAreaImp) {
        this.maxAreaImp = maxAreaImp;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    public int getMinWidthImp() {
        return minWidthImp;
    }

    public void setMinWidthImp(int minWidthImp) {
        this.minWidthImp = minWidthImp;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMinHeightImp() {
        return minHeightImp;
    }

    public void setMinHeightImp(int minHeightImp) {
        this.minHeightImp = minHeightImp;
    }

    public BigDecimal getWhRatio() {
        return whRatio;
    }

    public void setWhRatio(BigDecimal whRatio) {
        this.whRatio = whRatio;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public boolean isCostActualSize() {
        return costActualSize;
    }

    public void setCostActualSize(boolean costActualSize) {
        this.costActualSize = costActualSize;
    }

    public int getPriceMatrixId() {
        return priceMatrixId;
    }

    public void setPriceMatrixId(int priceMatrixId) {
        this.priceMatrixId = priceMatrixId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMinPricingArea() {
        return minPricingArea;
    }

    public void setMinPricingArea(BigDecimal minPricingArea) {
        this.minPricingArea = minPricingArea;
    }

    public BigDecimal getMinPricingAreaImp() {
        return minPricingAreaImp;
    }

    public void setMinPricingAreaImp(BigDecimal minPricingAreaImp) {
        this.minPricingAreaImp = minPricingAreaImp;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public int getCostGroupId() {
        return costGroupId;
    }

    public void setCostGroupId(int costGroupId) {
        this.costGroupId = costGroupId;
    }

    public int getPriceGroupId() {
        return priceGroupId;
    }

    public void setPriceGroupId(int priceGroupId) {
        this.priceGroupId = priceGroupId;
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

    public int getPartnerGroupId() {
        return partnerGroupId;
    }

    public void setPartnerGroupId(int partnerGroupId) {
        this.partnerGroupId = partnerGroupId;
    }

    public int getNextItem() {
        return nextItem;
    }

    public void setNextItem(int nextItem) {
        this.nextItem = nextItem;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public BigDecimal getWaste() {
        return waste;
    }

    public void setWaste(BigDecimal waste) {
        this.waste = waste;
    }

    public boolean isMadeIn() {
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

    public int getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(int leadTime) {
        this.leadTime = leadTime;
    }

    public BigDecimal getMinCostArea() {
        return minCostArea;
    }

    public void setMinCostArea(BigDecimal minCostArea) {
        this.minCostArea = minCostArea;
    }

    public BigDecimal getMinCostAreaImp() {
        return minCostAreaImp;
    }

    public void setMinCostAreaImp(BigDecimal minCostAreaImp) {
        this.minCostAreaImp = minCostAreaImp;
    }

    public int getProductionLine() {
        return productionLine;
    }

    public void setProductionLine(int productionLine) {
        this.productionLine = productionLine;
    }

    public int getSortSeq() {
        return sortSeq;
    }

    public void setSortSeq(int sortSeq) {
        this.sortSeq = sortSeq;
    }

    public int getGlazingType() {
        return glazingType;
    }

    public void setGlazingType(int glazingType) {
        this.glazingType = glazingType;
    }

    public boolean isCustom() {
        return isCustom;
    }

    public void setCustom(boolean custom) {
        isCustom = custom;
    }

    public int getNumOfLeaves() {
        return numOfLeaves;
    }

    public void setNumOfLeaves(int numOfLeaves) {
        this.numOfLeaves = numOfLeaves;
    }

    public int getLeafNo() {
        return leafNo;
    }

    public void setLeafNo(int leafNo) {
        this.leafNo = leafNo;
    }

    public BigDecimal getThickness() {
        return thickness;
    }

    public void setThickness(BigDecimal thickness) {
        this.thickness = thickness;
    }

    public BigDecimal getThicknessImp() {
        return thicknessImp;
    }

    public void setThicknessImp(BigDecimal thicknessImp) {
        this.thicknessImp = thicknessImp;
    }

    public int getLeafIn() {
        return leafIn;
    }

    public void setLeafIn(int leafIn) {
        this.leafIn = leafIn;
    }

    public int getLeaf_1() {
        return leaf_1;
    }

    public void setLeaf_1(int leaf_1) {
        this.leaf_1 = leaf_1;
    }

    public int getLeaf_2() {
        return leaf_2;
    }

    public void setLeaf_2(int leaf_2) {
        this.leaf_2 = leaf_2;
    }

    public int getLeaf_3() {
        return leaf_3;
    }

    public void setLeaf_3(int leaf_3) {
        this.leaf_3 = leaf_3;
    }

    public int getLeaf_4() {
        return leaf_4;
    }

    public void setLeaf_4(int leaf_4) {
        this.leaf_4 = leaf_4;
    }

    public int getLeafOut() {
        return leafOut;
    }

    public void setLeafOut(int leafOut) {
        this.leafOut = leafOut;
    }

    public int getSpacer_1() {
        return spacer_1;
    }

    public void setSpacer_1(int spacer_1) {
        this.spacer_1 = spacer_1;
    }

    public int getSpacer_2() {
        return spacer_2;
    }

    public void setSpacer_2(int spacer_2) {
        this.spacer_2 = spacer_2;
    }

    public int getSpacer_3() {
        return spacer_3;
    }

    public void setSpacer_3(int spacer_3) {
        this.spacer_3 = spacer_3;
    }

    public BigDecimal getSpacerThick_1() {
        return spacerThick_1;
    }

    public void setSpacerThick_1(BigDecimal spacerThick_1) {
        this.spacerThick_1 = spacerThick_1;
    }

    public BigDecimal getSpacerThick_2() {
        return spacerThick_2;
    }

    public void setSpacerThick_2(BigDecimal spacerThick_2) {
        this.spacerThick_2 = spacerThick_2;
    }

    public BigDecimal getSpacerThick_3() {
        return spacerThick_3;
    }

    public void setSpacerThick_3(BigDecimal spacerThick_3) {
        this.spacerThick_3 = spacerThick_3;
    }

    public BigDecimal getGlassToSpacer() {
        return glassToSpacer;
    }

    public void setGlassToSpacer(BigDecimal glassToSpacer) {
        this.glassToSpacer = glassToSpacer;
    }

    public BigDecimal getGlassToSpacerImp() {
        return glassToSpacerImp;
    }

    public void setGlassToSpacerImp(BigDecimal glassToSpacerImp) {
        this.glassToSpacerImp = glassToSpacerImp;
    }

    public BigDecimal getAirSpace_1() {
        return airSpace_1;
    }

    public void setAirSpace_1(BigDecimal airSpace_1) {
        this.airSpace_1 = airSpace_1;
    }

    public BigDecimal getAirSpace_2() {
        return airSpace_2;
    }

    public void setAirSpace_2(BigDecimal airSpace_2) {
        this.airSpace_2 = airSpace_2;
    }

    public BigDecimal getAirSpace_3() {
        return airSpace_3;
    }

    public void setAirSpace_3(BigDecimal airSpace_3) {
        this.airSpace_3 = airSpace_3;
    }

    public int getGas_1() {
        return gas_1;
    }

    public void setGas_1(int gas_1) {
        this.gas_1 = gas_1;
    }

    public int getGas_2() {
        return gas_2;
    }

    public void setGas_2(int gas_2) {
        this.gas_2 = gas_2;
    }

    public int getGas_3() {
        return gas_3;
    }

    public void setGas_3(int gas_3) {
        this.gas_3 = gas_3;
    }

    public int getFilm_1() {
        return film_1;
    }

    public void setFilm_1(int film_1) {
        this.film_1 = film_1;
    }

    public int getFilm_2() {
        return film_2;
    }

    public void setFilm_2(int film_2) {
        this.film_2 = film_2;
    }

    public int getFilm_3() {
        return film_3;
    }

    public void setFilm_3(int film_3) {
        this.film_3 = film_3;
    }

    public int getFilm_4() {
        return film_4;
    }

    public void setFilm_4(int film_4) {
        this.film_4 = film_4;
    }

    public int getProcess_1() {
        return process_1;
    }

    public void setProcess_1(int process_1) {
        this.process_1 = process_1;
    }

    public int getProcess_2() {
        return process_2;
    }

    public void setProcess_2(int process_2) {
        this.process_2 = process_2;
    }

    public int getProcess_3() {
        return process_3;
    }

    public void setProcess_3(int process_3) {
        this.process_3 = process_3;
    }

    public int getProcess_4() {
        return process_4;
    }

    public void setProcess_4(int process_4) {
        this.process_4 = process_4;
    }

    public int getCavityProcess_1() {
        return cavityProcess_1;
    }

    public void setCavityProcess_1(int cavityProcess_1) {
        this.cavityProcess_1 = cavityProcess_1;
    }

    public int getCavityProcess_2() {
        return cavityProcess_2;
    }

    public void setCavityProcess_2(int cavityProcess_2) {
        this.cavityProcess_2 = cavityProcess_2;
    }

    public int getCavityProcess_3() {
        return cavityProcess_3;
    }

    public void setCavityProcess_3(int cavityProcess_3) {
        this.cavityProcess_3 = cavityProcess_3;
    }

    public int getCavity_1_Process_2() {
        return cavity_1_Process_2;
    }

    public void setCavity_1_Process_2(int cavity_1_Process_2) {
        this.cavity_1_Process_2 = cavity_1_Process_2;
    }

    public int getCavity_2_Process_2() {
        return cavity_2_Process_2;
    }

    public void setCavity_2_Process_2(int cavity_2_Process_2) {
        this.cavity_2_Process_2 = cavity_2_Process_2;
    }

    public int getCavity_3_Process_2() {
        return cavity_3_Process_2;
    }

    public void setCavity_3_Process_2(int cavity_3_Process_2) {
        this.cavity_3_Process_2 = cavity_3_Process_2;
    }

    public int getCavity_1_Process_3() {
        return cavity_1_Process_3;
    }

    public void setCavity_1_Process_3(int cavity_1_Process_3) {
        this.cavity_1_Process_3 = cavity_1_Process_3;
    }

    public int getCavity_2_Process_3() {
        return cavity_2_Process_3;
    }

    public void setCavity_2_Process_3(int cavity_2_Process_3) {
        this.cavity_2_Process_3 = cavity_2_Process_3;
    }

    public int getCavity_3_Process_3() {
        return cavity_3_Process_3;
    }

    public void setCavity_3_Process_3(int cavity_3_Process_3) {
        this.cavity_3_Process_3 = cavity_3_Process_3;
    }

    public int getExternalProcess_1() {
        return externalProcess_1;
    }

    public void setExternalProcess_1(int externalProcess_1) {
        this.externalProcess_1 = externalProcess_1;
    }

    public int getExternalProcess_2() {
        return externalProcess_2;
    }

    public void setExternalProcess_2(int externalProcess_2) {
        this.externalProcess_2 = externalProcess_2;
    }

    public int getExternalProcess_3() {
        return externalProcess_3;
    }

    public void setExternalProcess_3(int externalProcess_3) {
        this.externalProcess_3 = externalProcess_3;
    }

    public int getExternalProcess_4() {
        return externalProcess_4;
    }

    public void setExternalProcess_4(int externalProcess_4) {
        this.externalProcess_4 = externalProcess_4;
    }

    public int getExternal_1_Process_2() {
        return external_1_Process_2;
    }

    public void setExternal_1_Process_2(int external_1_Process_2) {
        this.external_1_Process_2 = external_1_Process_2;
    }

    public int getExternal_2_Process_2() {
        return external_2_Process_2;
    }

    public void setExternal_2_Process_2(int external_2_Process_2) {
        this.external_2_Process_2 = external_2_Process_2;
    }

    public int getExternal_3_Process_2() {
        return external_3_Process_2;
    }

    public void setExternal_3_Process_2(int external_3_Process_2) {
        this.external_3_Process_2 = external_3_Process_2;
    }

    public int getExternal_4_Process_2() {
        return external_4_Process_2;
    }

    public void setExternal_4_Process_2(int external_4_Process_2) {
        this.external_4_Process_2 = external_4_Process_2;
    }

    public int getExternal_1_Process_3() {
        return external_1_Process_3;
    }

    public void setExternal_1_Process_3(int external_1_Process_3) {
        this.external_1_Process_3 = external_1_Process_3;
    }

    public int getExternal_2_Process_3() {
        return external_2_Process_3;
    }

    public void setExternal_2_Process_3(int external_2_Process_3) {
        this.external_2_Process_3 = external_2_Process_3;
    }

    public int getExternal_3_Process_3() {
        return external_3_Process_3;
    }

    public void setExternal_3_Process_3(int external_3_Process_3) {
        this.external_3_Process_3 = external_3_Process_3;
    }

    public int getExternal_4_Process_3() {
        return external_4_Process_3;
    }

    public void setExternal_4_Process_3(int external_4_Process_3) {
        this.external_4_Process_3 = external_4_Process_3;
    }

    public int getGlass_1() {
        return glass_1;
    }

    public void setGlass_1(int glass_1) {
        this.glass_1 = glass_1;
    }

    public int getGlass_2() {
        return glass_2;
    }

    public void setGlass_2(int glass_2) {
        this.glass_2 = glass_2;
    }

    public int getGlass_3() {
        return glass_3;
    }

    public void setGlass_3(int glass_3) {
        this.glass_3 = glass_3;
    }

    public int getGlass_4() {
        return glass_4;
    }

    public void setGlass_4(int glass_4) {
        this.glass_4 = glass_4;
    }

    public int getGlass_1_Process_2() {
        return glass_1_Process_2;
    }

    public void setGlass_1_Process_2(int glass_1_Process_2) {
        this.glass_1_Process_2 = glass_1_Process_2;
    }

    public int getGlass_2_Process_2() {
        return glass_2_Process_2;
    }

    public void setGlass_2_Process_2(int glass_2_Process_2) {
        this.glass_2_Process_2 = glass_2_Process_2;
    }

    public int getGlass_3_Process_2() {
        return glass_3_Process_2;
    }

    public void setGlass_3_Process_2(int glass_3_Process_2) {
        this.glass_3_Process_2 = glass_3_Process_2;
    }

    public int getGlass_4_Process_2() {
        return glass_4_Process_2;
    }

    public void setGlass_4_Process_2(int glass_4_Process_2) {
        this.glass_4_Process_2 = glass_4_Process_2;
    }

    public int getGlass_1_Process_3() {
        return glass_1_Process_3;
    }

    public void setGlass_1_Process_3(int glass_1_Process_3) {
        this.glass_1_Process_3 = glass_1_Process_3;
    }

    public int getGlass_2_Process_3() {
        return glass_2_Process_3;
    }

    public void setGlass_2_Process_3(int glass_2_Process_3) {
        this.glass_2_Process_3 = glass_2_Process_3;
    }

    public int getGlass_3_Process_3() {
        return glass_3_Process_3;
    }

    public void setGlass_3_Process_3(int glass_3_Process_3) {
        this.glass_3_Process_3 = glass_3_Process_3;
    }

    public int getGlass_4_Process_3() {
        return glass_4_Process_3;
    }

    public void setGlass_4_Process_3(int glass_4_Process_3) {
        this.glass_4_Process_3 = glass_4_Process_3;
    }

    public int getFamily_id() {
        return family_id;
    }

    public void setFamily_id(int family_id) {
        this.family_id = family_id;
    }

    public int getInsert_id_1() {
        return insert_id_1;
    }

    public void setInsert_id_1(int insert_id_1) {
        this.insert_id_1 = insert_id_1;
    }

    public int getInsert_id_2() {
        return insert_id_2;
    }

    public void setInsert_id_2(int insert_id_2) {
        this.insert_id_2 = insert_id_2;
    }

    public int getInsert_id_3() {
        return insert_id_3;
    }

    public void setInsert_id_3(int insert_id_3) {
        this.insert_id_3 = insert_id_3;
    }

    public int getGridID() {
        return gridID;
    }

    public void setGridID(int gridID) {
        this.gridID = gridID;
    }


    public int getGridType() {
        return gridType;
    }

    public void setGridType(int gridType) {
        this.gridType = gridType;
    }

    public int getNoGridsV() {
        return noGridsV;
    }

    public void setNoGridsV(int noGridsV) {
        this.noGridsV = noGridsV;
    }

    public int getNoGridsH() {
        return noGridsH;
    }

    public void setNoGridsH(int noGridsH) {
        this.noGridsH = noGridsH;
    }

    public int getNoGridsS() {
        return noGridsS;
    }

    public void setNoGridsS(int noGridsS) {
        this.noGridsS = noGridsS;
    }

    public int getNoGridsR() {
        return noGridsR;
    }

    public void setNoGridsR(int noGridsR) {
        this.noGridsR = noGridsR;
    }

    public BkgrdOpeningEntityObject getBkgrdOpening() {
        return bkgrdOpening;
    }

    public void setBkgrdOpening(BkgrdOpeningEntityObject bkgrdOpening) {
        this.bkgrdOpening = bkgrdOpening;
    }

    public Set<OpeningEntityObject> getOpenings() {
        return openings;
    }

    public void setOpenings(Set<OpeningEntityObject> openings) {
        this.openings = openings;
    }

    public Set<DesignGlassEntityObject> getGlassBom() {
        return glassBom;
    }

    public void setGlassBom(Set<DesignGlassEntityObject> glassBom) {
        this.glassBom = glassBom;
    }
    
    public int getPartFamily() {
        return partFamily;
    }

    public void setPartFamily(int pf) {
        this.partFamily = pf;
    }

    public BigDecimal getSpacerThick_1_i() {
        return spacerThick_1_i;
    }

    public void setSpacerThick_1_i(BigDecimal spacerThick_1_i) {
        this.spacerThick_1_i = spacerThick_1_i;
    }

    public BigDecimal getSpacerThick_2_i() {
        return spacerThick_2_i;
    }

    public void setSpacerThick_2_i(BigDecimal spacerThick_2_i) {
        this.spacerThick_2_i = spacerThick_2_i;
    }

    public BigDecimal getSpacerThick_3_i() {
        return spacerThick_3_i;
    }

    public void setSpacerThick_3_i(BigDecimal spacerThick_3_i) {
        this.spacerThick_3_i = spacerThick_3_i;
    }

    public BigDecimal getAirSpace_1_i() {
        return airSpace_1_i;
    }

    public void setAirSpace_1_i(BigDecimal airSpace_1_i) {
        this.airSpace_1_i = airSpace_1_i;
    }

    public BigDecimal getAirSpace_2_i() {
        return airSpace_2_i;
    }

    public void setAirSpace_2_i(BigDecimal airSpace_2_i) {
        this.airSpace_2_i = airSpace_2_i;
    }

    public BigDecimal getAirSpace_3_i() {
        return airSpace_3_i;
    }

    public void setAirSpace_3_i(BigDecimal airSpace_3_i) {
        this.airSpace_3_i = airSpace_3_i;
    }
}


package openjanela.model.entities.partner;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved. User: emortiz Date:
 * 09-12-12 Time: 03:41 PM
 */
@Entity
@Table(name = "su_type")
@Cacheable
public class SUType implements Serializable {

    /**
     * PROPERTY NAME: Primary Key identifier
     */
    private Integer id;

    /**
     * PROPERTY NAME: Stock code
     */
    private String stockCode;

    /**
     * PROPERTY NAME: description
     */
    private String description;

    /**
     * PROPERTY NAME: minimum area
     */
    private Double minArea;

    /**
     * PROPERTY NAME: minimum area imperial
     */
    private Double minAreaImp;

    /**
     * PROPERTY NAME: Maximum area
     */
    private Double maxArea;

    /**
     * PROPERTY NAME: Maximum area imperial
     */
    private Double maxAreaImp;

    /**
     * PROPERTY NAME: Minimum width
     */
    private Integer minWidth;

    /**
     * PROPERTY NAME: Minimum width imperial
     */
    private Integer minWidthImp;

    /**
     * PROPERTY NAME: Maximum width
     */
    private Integer maxWidth;

    /**
     * PROPERTY NAME: Maximum width imperial
     */
    private Integer maxWidthImp;

    /**
     * PROPERTY NAME: Minimum height
     */
    private Integer minHeight;

    /**
     * PROPERTY NAME: Minimum height imperial
     */
    private Integer minHeightImp;

    /**
     * PROPERTY NAME: Maximum height
     */
    private Integer maxHeight;

    /**
     * PROPERTY NAME: Meximum height imperial
     */
    private Integer maxHeightImp;

    /**
     * PROPERTY NAME: width - height ratio
     */
    private Double whRatio;

    /**
     * PROPERTY NAME: Pricing unit of metric
     */
    private Integer pricingUOMId;

    /**
     * PROPERTY NAME: Price actual size
     */
    private Boolean priceActualSize;

    /**
     * PROPERTY NAME: Cost
     */
    private BigDecimal cost;

    /**
     * PROPERTY NAME: Cost actual size
     */
    private Boolean costActualSize;

    /**
     * PROPERTY NAME: Price matrix
     */
    private Integer priceMatrixId;

    /**
     * PROPERTY NAME: Price
     */
    private BigDecimal price;

    /**
     * PROPERTY NAME: Minimum pricing area
     */
    private Double minPricingArea;

    /**
     * PROPERTY NAME: Minimum pricing area imperial
     */
    private Double minPricingAreaImp;

    /**
     * PROPERTY NAME: Minimum price
     */
    private BigDecimal minPrice;

    /**
     * PROPERTY NAME: Cost group
     */
    private Integer costGroupId;

    /**
     * PROPERTY NAME: Price group
     */
    private Integer priceGroupId;

    /**
     * PROPERTY NAME: Start date
     */
    private Date startDate;

    /**
     * PROPERTY NAME: End date
     */
    private Date endDate;

    /**
     * PROPERTY NAME: Partner group
     */
    private Integer partnerGroupId;

    /**
     * PROPERTY NAME: Next item
     */
    private Integer nextItem;

    /**
     * PROPERTY NAME: Display
     */
    private Boolean display;

    /**
     * PROPERTY NAME: Waste
     */
    private Double waste;

    /**
     * PROPERTY NAME: Made in
     */
    private boolean madeIn;

    /**
     * PROPERTY NAME: Supplier identification
     */
    private Integer supplierId;

    /**
     * PROPERTY NAME: Lead time
     */
    private Integer leadTime;

    /**
     * PROPERTY NAME: Minimum cost area
     */
    private Double minCostArea;

    /**
     * PROPERTY NAME: Minimum cost area imperial
     */
    private Double minCostAreaImp;

    /**
     * PROPERTY NAME: Production line
     */
    private Integer productionLine;

    /**
     * PROPERTY NAME: Sort sequence
     */
    private Integer sortSeq;

    /**
     * PROPERTY NAME: Glazing type
     */
    private Integer glazingType;

    /**
     * PROPERTY NAME: Custom
     */
    private Boolean isCustom;

    /**
     * PROPERTY NAME: Number of leaves
     */
    private Integer numOfLeaves;

    /**
     * PROPERTY NAME: Thickness
     */
    private Integer thickness;

    /**
     * PROPERTY NAME: Thickness imperial
     */
    private Integer thicknessImp;

    /**
     * PROPERTY NAME: Leaf 1 Id
     */
    private Integer leaf1Id;

    /**
     * PROPERTY NAME: Leaf 2 Id
     */
    private Integer leaf2Id;

    /**
     * PROPERTY NAME: Leaf 3 Id
     */
    private Integer leaf3Id;

    /**
     * PROPERTY NAME: Leaf 4 Id
     */
    private Integer leaf4Id;

    /**
     * PROPERTY NAME: Spacer 1 Part Id
     */
    private Integer spacer1PartId;

    /**
     * PROPERTY NAME: Spacer 2 Part Id
     */
    private Integer spacer2PartId;

    /**
     * PROPERTY NAME: Spacer 3 Part Id
     */
    private Integer spacer3PartId;

    /**
     * PROPERTY NAME: Glass Edge to spacer in
     */
    private Integer glassEdgeToSpacerIn;

    /**
     * PROPERTY NAME: Glass Esde to spacer in imperial
     */
    private Integer glassEdgeToSpacerInImp;

    /**
     * PROPERTY NAME: Gas 1 part Id
     */
    private Integer gas1PartId;

    /**
     * PROPERTY NAME: Gas 2 part Id
     */
    private Integer gas2PartId;

    /**
     * PROPERTY NAME: Gas 3 part Id
     */
    private Integer gas3PartId;

    /**
     * PROPERTY NAME: Glass 1 Film part Id
     */
    private Integer glass1FilmPartId;

    /**
     * PROPERTY NAME: Glass 2 Film part Id
     */
    private Integer glass2FilmPartId;

    /**
     * PROPERTY NAME: Glass 3 Film part Id
     */
    private Integer glass3FilmPartId;

    /**
     * PROPERTY NAME: Glass 4 Film part Id
     */
    private Integer glass4FilmPartId;

    /**
     * PROPERTY NAME: Glass 1 Process Id
     */
    private Integer glass1ProcessId;

    /**
     * PROPERTY NAME: Glass 2 Process Id
     */
    private Integer glass2ProcessId;

    /**
     * PROPERTY NAME: Glass 2 Process Id
     */
    private Integer glass3ProcessId;

    /**
     * PROPERTY NAME: Glass 4 Process Id
     */
    private Integer glass4ProcessId;

    /**
     * PROPERTY NAME: Cavity 1 Process Id
     */
    private Integer cavity1ProcessId;

    /**
     * PROPERTY NAME: Cavity 2 Process Id
     */
    private Integer cavity2ProcessId;

    /**
     * PROPERTY NAME: Cavity 3 Process Id
     */
    private Integer cavity3ProcessId;

    /**
     * PROPERTY NAME: External 1 Process Id
     */
    private Integer external1ProcessId;

    /**
     * PROPERTY NAME: External 2 Process Id
     */
    private Integer external2ProcessId;

    /**
     * PROPERTY NAME: External 3 Process Id
     */
    private Integer external3ProcessId;

    /**
     * PROPERTY NAME: External 4 Process Id
     */
    private Integer external4ProcessId;

    /**
     * PROPERTY NAME: Glass 1 Process 2 Id
     */
    private Integer glass1Process2Id;

    /**
     * PROPERTY NAME: Glass 2 Process 2 Id
     */
    private Integer glass2Process2Id;

    /**
     * PROPERTY NAME: Glass 3 Process 2 Id
     */
    private Integer glass3Process2Id;

    /**
     * PROPERTY NAME: Glass 4 Process 2 Id
     */
    private Integer glass4Process2Id;

    /**
     * PROPERTY NAME: Cavity 1 Process 2 Id
     */
    private Integer cavity1Process2Id;

    /**
     * PROPERTY NAME: Cavity 2 Process 2 Id
     */
    private Integer cavity2Process2Id;

    /**
     * PROPERTY NAME: Cavity 3 Process 2 Id
     */
    private Integer cavity3Process2Id;

    /**
     * PROPERTY NAME: External 1 Process 2 Id
     */
    private Integer external1Process2Id;

    /**
     * PROPERTY NAME: External 2 Process 2 Id
     */
    private Integer external2Process2Id;

    /**
     * PROPERTY NAME: External 3 Process 2 Id
     */
    private Integer external3Process2Id;

    /**
     * PROPERTY NAME: External 4 Process 2 Id
     */
    private Integer external4Process2Id;

    /**
     * PROPERTY NAME: Glass 1 Process 3 Id
     */
    private Integer glass1Process3Id;

    /**
     * PROPERTY NAME: Glass 2 Process 3 Id
     */
    private Integer glass2Process3Id;

    /**
     * PROPERTY NAME: Glass 3 Process 3 Id
     */
    private Integer glass3Process3Id;

    /**
     * PROPERTY NAME: Glass 4 Process 3 Id
     */
    private Integer glass4Process3Id;

    /**
     * PROPERTY NAME: Cavity 1 Process 3 Id
     */
    private Integer cavity1Process3Id;

    /**
     * PROPERTY NAME: Cavity 2 Process 3 Id
     */
    private Integer cavity2Process3Id;

    /**
     * PROPERTY NAME: Cavity 3 Process 3 Id
     */
    private Integer cavity3Process3Id;

    /**
     * PROPERTY NAME: External 1 Process 3 Id
     */
    private Integer external1Process3Id;

    /**
     * PROPERTY NAME: External 3 Process 3 Id
     */
    private Integer external2Process3Id;

    /**
     * PROPERTY NAME: External 3 Process 3 Id
     */
    private Integer external3Process3Id;

    /**
     * PROPERTY NAME: External 4 Process 3 Id
     */
    private Integer external4Process3Id;

    /**
     * PROPERTY NAME: Sealent Part Id
     */
    private Integer sealantPartId;

    /**
     * PROPERTY NAME: Family Id
     */
    private Integer familyId;

    /**
     * PROPERTY NAME: Abbrev
     */
    private String abbrev;

    /**
     * PROPERTY NAME: Image
     */
    private byte[] image;

    /**
     * PROPERTY NAME: Insert 1 Id
     */
    private Integer insert1Id;

    /**
     * PROPERTY NAME: Insert 2 Id
     */
    private Integer insert2Id;

    /**
     * PROPERTY NAME: Insert 3 Id
     */
    private Integer insert3Id;

    /**
     * PROPERTY NAME: Measure
     */
    private Integer measure;

    /**
     * PROPERT NAME: Make in house or not
     */
    private boolean inHouse;

    /**
     * PROPERTY NAME: Assembly code Id
     */
    private Integer assemblyId;

    /**
     * PROPERTY NAME: Air Spacer 1
     */
    private Integer airSpace1;

    /**
     * PROPERTY NAME: Air Spacer 1 Imp
     */
    private Integer airSpace1i;

    /**
     * PROPERTY NAME: Air Spacer 2
     */
    private Integer airSpace2;

    /**
     * PROPERTY NAME: Air Spacer 2 Imp
     */
    private Integer airSpace2i;

    /**
     * PROPERTY NAME: Air Spacer 3
     */
    private Integer airSpace3;

    /**
     * PROPERTY NAME: Air Spacer 3 Imp
     */
    private Integer airSpace3i;

    /**
     * PROPERTY NAME: Part Family
     */
    private Integer partFamily;

    /**
     * PROPERTY NAME: Flag Color
     */
    private Integer flagColor;

    /**
     * PROPERTY NAME: Supplier Remote Id
     */
    private int supplierRemoteId;

    /**
     * PROPERTY NAME: Glass SU Supplier
     */
    private int supplierSeriesId;

    /**
     * PROPERTY NAME: Glass from External Supplier
     */
    private boolean isRemote;

    // ==================================<GETTTER AND SETTERS>=================================================
    
	@Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "stockcode", nullable = false)
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "min_area")
    public Double getMinArea() {
        return minArea;
    }

    public void setMinArea(Double minArea) {
        this.minArea = minArea;
    }

    @Column(name = "min_area_imp")
    public Double getMinAreaImp() {
        return minAreaImp;
    }

    public void setMinAreaImp(Double minAreaImp) {

        this.minAreaImp = minAreaImp;
    }

    @Column(name = "max_area")
    public Double getMaxArea() {

        return maxArea;
    }

    public void setMaxArea(Double maxArea) {

        this.maxArea = maxArea;
    }

    @Column(name = "max_area_imp")
    public Double getMaxAreaImp() {

        return maxAreaImp;
    }

    public void setMaxAreaImp(Double maxAreaImp) {

        this.maxAreaImp = maxAreaImp;
    }

    @Column(name = "min_width")
    public Integer getMinWidth() {

        return minWidth;
    }

    public void setMinWidth(Integer minWidth) {

        this.minWidth = minWidth;
    }

    @Column(name = "min_width_imp")
    public Integer getMinWidthImp() {

        return minWidthImp;
    }

    public void setMinWidthImp(Integer minWidthImp) {

        this.minWidthImp = minWidthImp;
    }

    @Column(name = "max_width")
    public Integer getMaxWidth() {

        return maxWidth;
    }

    public void setMaxWidth(Integer maxWidth) {

        this.maxWidth = maxWidth;
    }

    @Column(name = "max_width_imp")
    public Integer getMaxWidthImp() {

        return maxWidthImp;
    }

    public void setMaxWidthImp(Integer maxWidthImp) {

        this.maxWidthImp = maxWidthImp;
    }

    @Column(name = "min_height")
    public Integer getMinHeight() {

        return minHeight;
    }

    public void setMinHeight(Integer minHeight) {

        this.minHeight = minHeight;
    }

    @Column(name = "min_height_imp")
    public Integer getMinHeightImp() {

        return minHeightImp;
    }

    public void setMinHeightImp(Integer minHeightImp) {

        this.minHeightImp = minHeightImp;
    }

    @Column(name = "max_height")
    public Integer getMaxHeight() {

        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {

        this.maxHeight = maxHeight;
    }

    @Column(name = "max_height_imp")
    public Integer getMaxHeightImp() {

        return maxHeightImp;
    }

    public void setMaxHeightImp(Integer maxHeightImp) {

        this.maxHeightImp = maxHeightImp;
    }

    @Column(name = "w_h_ratio")
    public Double getWhRatio() {

        return whRatio;
    }

    public void setWhRatio(Double whRatio) {

        this.whRatio = whRatio;
    }

    @Column(name = "pricing_uom_id")
    public Integer getPricingUOMId() {

        return pricingUOMId;
    }

    public void setPricingUOMId(Integer pricingUOMId) {

        this.pricingUOMId = pricingUOMId;
    }

    @Column(name = "price_actual_size")
    public Boolean getPriceActualSize() {

        return priceActualSize;
    }

    public void setPriceActualSize(Boolean priceActualSize) {

        this.priceActualSize = priceActualSize;
    }

    @Column(name = "cost", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    public BigDecimal getCost() {

        return cost;
    }

    public void setCost(BigDecimal cost) {

        this.cost = cost;
    }

    @Column(name = "cost_actual_size")
    public Boolean getCostActualSize() {

        return costActualSize;
    }

    public void setCostActualSize(Boolean costActualSize) {

        this.costActualSize = costActualSize;
    }

    @Column(name = "price_matrix_id")
    public Integer getPriceMatrixId() {

        return priceMatrixId;
    }

    public void setPriceMatrixId(Integer priceMatrixId) {

        this.priceMatrixId = priceMatrixId;
    }

    @Column(name = "price", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)")
    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    @Column(name = "min_pricing_area")
    public Double getMinPricingArea() {

        return minPricingArea;
    }

    public void setMinPricingArea(Double minPricingArea) {

        this.minPricingArea = minPricingArea;
    }

    @Column(name = "min_pricing_area_imp")
    public Double getMinPricingAreaImp() {

        return minPricingAreaImp;
    }

    public void setMinPricingAreaImp(Double minPricingAreaImp) {

        this.minPricingAreaImp = minPricingAreaImp;
    }

    @Column(name = "min_price", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)")
    public BigDecimal getMinPrice() {

        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {

        this.minPrice = minPrice;
    }

    @Column(name = "cost_group_id")
    public Integer getCostGroupId() {

        return costGroupId;
    }

    public void setCostGroupId(Integer costGroupId) {

        this.costGroupId = costGroupId;
    }

    @Column(name = "price_group_id")
    public Integer getPriceGroupId() {

        return priceGroupId;
    }

    public void setPriceGroupId(Integer priceGroupId) {

        this.priceGroupId = priceGroupId;
    }

    @Column(name = "startdate")
    public Date getStartDate() {

        return startDate;
    }

    public void setStartDate(Date startDate) {

        this.startDate = startDate;
    }

    @Column(name = "enddate")
    public Date getEndDate() {

        return endDate;
    }

    public void setEndDate(Date endDate) {

        this.endDate = endDate;
    }

    @Column(name = "partner_group_id")
    public Integer getPartnerGroupId() {

        return partnerGroupId;
    }

    public void setPartnerGroupId(Integer partnerGroupId) {

        this.partnerGroupId = partnerGroupId;
    }

    @Column(name = "next_item")
    public Integer getNextItem() {

        return nextItem;
    }

    public void setNextItem(Integer nextItem) {

        this.nextItem = nextItem;
    }

    @Column(name = "display")
    public Boolean getDisplay() {

        return display;
    }

    public void setDisplay(Boolean display) {

        this.display = display;
    }

    @Column(name = "waste")
    public Double getWaste() {

        return waste;
    }

    public void setWaste(Double waste) {

        this.waste = waste;
    }

    @Column(name = "made_in")
    public boolean getMadeIn() {

        return madeIn;
    }

    public void setMadeIn(boolean madeIn) {

        this.madeIn = madeIn;
    }

    @Column(name = "supplier_id")
    public Integer getSupplierId() {

        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {

        this.supplierId = supplierId;
    }

    @Column(name = "lead_time")
    public Integer getLeadTime() {

        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {

        this.leadTime = leadTime;
    }

    @Column(name = "min_cost_area")
    public Double getMinCostArea() {

        return minCostArea;
    }

    public void setMinCostArea(Double minCostArea) {

        this.minCostArea = minCostArea;
    }

    @Column(name = "min_costing_area_imp")
    public Double getMinCostAreaImp() {

        return minCostAreaImp;
    }

    public void setMinCostAreaImp(Double minCostAreaImp) {

        this.minCostAreaImp = minCostAreaImp;
    }

    @Column(name = "production_line")
    public Integer getProductionLine() {

        return productionLine;
    }

    public void setProductionLine(Integer productionLine) {

        this.productionLine = productionLine;
    }

    @Column(name = "sort_seq")
    public Integer getSortSeq() {

        return sortSeq;
    }

    public void setSortSeq(Integer sortSeq) {

        this.sortSeq = sortSeq;
    }

    @Column(name = "glazing_type")
    public Integer getGlazingType() {

        return glazingType;
    }

    public void setGlazingType(Integer glazingType) {

        this.glazingType = glazingType;
    }

    @Column(name = "is_custom")
    public Boolean getCustom() {
        return isCustom;
    }

    public void setCustom(Boolean custom) {

        isCustom = custom;
    }

    @Column(name = "num_of_leaves")
    public Integer getNumOfLeaves() {

        return numOfLeaves;
    }

    public void setNumOfLeaves(Integer numOfLeaves) {

        this.numOfLeaves = numOfLeaves;
    }

    @Column(name = "thickness")
    public Integer getThickness() {

        return thickness;
    }

    public void setThickness(Integer thickness) {

        this.thickness = thickness;
    }

    @Column(name = "thickness_imp")
    public Integer getThicknessImp() {

        return thicknessImp;
    }

    public void setThicknessImp(Integer thicknessImp) {

        this.thicknessImp = thicknessImp;
    }

    @Column(name = "leaf_1_id")
    public Integer getLeaf1Id() {

        return leaf1Id;
    }

    public void setLeaf1Id(Integer leaf1Id) {

        this.leaf1Id = leaf1Id;
    }

    @Column(name = "leaf_2_id")
    public Integer getLeaf2Id() {

        return leaf2Id;
    }

    public void setLeaf2Id(Integer leaf2Id) {

        this.leaf2Id = leaf2Id;
    }

    @Column(name = "leaf_3_id")
    public Integer getLeaf3Id() {

        return leaf3Id;
    }

    public void setLeaf3Id(Integer leaf3Id) {

        this.leaf3Id = leaf3Id;
    }

    @Column(name = "leaf_4_id")
    public Integer getLeaf4Id() {

        return leaf4Id;
    }

    public void setLeaf4Id(Integer leaf4Id) {

        this.leaf4Id = leaf4Id;
    }

    @Column(name = "spacer_1_part_id")
    public Integer getSpacer1PartId() {

        return spacer1PartId;
    }

    public void setSpacer1PartId(Integer spacer1PartId) {

        this.spacer1PartId = spacer1PartId;
    }

    @Column(name = "spacer_2_part_id")
    public Integer getSpacer2PartId() {

        return spacer2PartId;
    }

    public void setSpacer2PartId(Integer spacer2PartId) {

        this.spacer2PartId = spacer2PartId;
    }

    @Column(name = "spacer_3_part_id")
    public Integer getSpacer3PartId() {

        return spacer3PartId;
    }

    public void setSpacer3PartId(Integer spacer3PartId) {

        this.spacer3PartId = spacer3PartId;
    }

    @Column(name = "glass_edge_to_spacer_in")
    public Integer getGlassEdgeToSpacerIn() {

        return glassEdgeToSpacerIn;
    }

    public void setGlassEdgeToSpacerIn(Integer glassEdgeToSpacerIn) {

        this.glassEdgeToSpacerIn = glassEdgeToSpacerIn;
    }

    @Column(name = "glass_edge_to_spacer_in_imp")
    public Integer getGlassEdgeToSpacerInImp() {

        return glassEdgeToSpacerInImp;
    }

    public void setGlassEdgeToSpacerInImp(Integer glassEdgeToSpacerInImp) {

        this.glassEdgeToSpacerInImp = glassEdgeToSpacerInImp;
    }

    @Column(name = "gas_1_part_id")
    public Integer getGas1PartId() {

        return gas1PartId;
    }

    public void setGas1PartId(Integer gas1PartId) {

        this.gas1PartId = gas1PartId;
    }

    @Column(name = "gas_2_part_id")
    public Integer getGas2PartId() {

        return gas2PartId;
    }

    public void setGas2PartId(Integer gas2PartId) {

        this.gas2PartId = gas2PartId;
    }

    @Column(name = "gas_3_part_id")
    public Integer getGas3PartId() {

        return gas3PartId;
    }

    public void setGas3PartId(Integer gas3PartId) {

        this.gas3PartId = gas3PartId;
    }

    @Column(name = "glass_1_film_part_id")
    public Integer getGlass1FilmPartId() {

        return glass1FilmPartId;
    }

    public void setGlass1FilmPartId(Integer glass1FilmPartId) {

        this.glass1FilmPartId = glass1FilmPartId;
    }

    @Column(name = "glass_2_film_part_id")
    public Integer getGlass2FilmPartId() {

        return glass2FilmPartId;
    }

    public void setGlass2FilmPartId(Integer glass2FilmPartId) {

        this.glass2FilmPartId = glass2FilmPartId;
    }

    @Column(name = "glass_3_film_part_id")
    public Integer getGlass3FilmPartId() {

        return glass3FilmPartId;
    }

    public void setGlass3FilmPartId(Integer glass3FilmPartId) {

        this.glass3FilmPartId = glass3FilmPartId;
    }

    @Column(name = "glass_4_film_part_id")
    public Integer getGlass4FilmPartId() {

        return glass4FilmPartId;
    }

    public void setGlass4FilmPartId(Integer glass4FilmPartId) {

        this.glass4FilmPartId = glass4FilmPartId;
    }

    @Column(name = "glass_1_process_id")
    public Integer getGlass1ProcessId() {

        return glass1ProcessId;
    }

    public void setGlass1ProcessId(Integer glass1ProcessId) {

        this.glass1ProcessId = glass1ProcessId;
    }

    @Column(name = "glass_2_process_id")
    public Integer getGlass2ProcessId() {

        return glass2ProcessId;
    }

    public void setGlass2ProcessId(Integer glass2ProcessId) {

        this.glass2ProcessId = glass2ProcessId;
    }

    @Column(name = "glass_3_process_id")
    public Integer getGlass3ProcessId() {

        return glass3ProcessId;
    }

    public void setGlass3ProcessId(Integer glass3ProcessId) {

        this.glass3ProcessId = glass3ProcessId;
    }

    @Column(name = "glass_4_process_id")
    public Integer getGlass4ProcessId() {

        return glass4ProcessId;
    }

    public void setGlass4ProcessId(Integer glass4ProcessId) {

        this.glass4ProcessId = glass4ProcessId;
    }

    @Column(name = "cavity_1_process_id")
    public Integer getCavity1ProcessId() {

        return cavity1ProcessId;
    }

    public void setCavity1ProcessId(Integer cavity1ProcessId) {

        this.cavity1ProcessId = cavity1ProcessId;
    }

    @Column(name = "cavity_2_process_id")
    public Integer getCavity2ProcessId() {

        return cavity2ProcessId;
    }

    public void setCavity2ProcessId(Integer cavity2ProcessId) {

        this.cavity2ProcessId = cavity2ProcessId;
    }

    @Column(name = "cavity_3_process_id")
    public Integer getCavity3ProcessId() {

        return cavity3ProcessId;
    }

    public void setCavity3ProcessId(Integer cavity3ProcessId) {

        this.cavity3ProcessId = cavity3ProcessId;
    }

    @Column(name = "external_1_process_id")
    public Integer getExternal1ProcessId() {

        return external1ProcessId;
    }

    public void setExternal1ProcessId(Integer external1ProcessId) {

        this.external1ProcessId = external1ProcessId;
    }

    @Column(name = "external_2_process_id")
    public Integer getExternal2ProcessId() {

        return external2ProcessId;
    }

    public void setExternal2ProcessId(Integer external2ProcessId) {

        this.external2ProcessId = external2ProcessId;
    }

    @Column(name = "external_3_process_id")
    public Integer getExternal3ProcessId() {

        return external3ProcessId;
    }

    public void setExternal3ProcessId(Integer external3ProcessId) {

        this.external3ProcessId = external3ProcessId;
    }

    @Column(name = "external_4_process_id")
    public Integer getExternal4ProcessId() {

        return external4ProcessId;
    }

    public void setExternal4ProcessId(Integer external4ProcessId) {

        this.external4ProcessId = external4ProcessId;
    }

    @Column(name = "glass_1_process_2_id")
    public Integer getGlass1Process2Id() {

        return glass1Process2Id;
    }

    public void setGlass1Process2Id(Integer glass1Process2Id) {

        this.glass1Process2Id = glass1Process2Id;
    }

    @Column(name = "glass_2_process_2_id")
    public Integer getGlass2Process2Id() {

        return glass2Process2Id;
    }

    public void setGlass2Process2Id(Integer glass2Process2Id) {

        this.glass2Process2Id = glass2Process2Id;
    }

    @Column(name = "glass_3_process_2_id")
    public Integer getGlass3Process2Id() {

        return glass3Process2Id;
    }

    public void setGlass3Process2Id(Integer glass3Process2Id) {

        this.glass3Process2Id = glass3Process2Id;
    }

    @Column(name = "glass_4_process_2_id")
    public Integer getGlass4Process2Id() {

        return glass4Process2Id;
    }

    public void setGlass4Process2Id(Integer glass4Process2Id) {

        this.glass4Process2Id = glass4Process2Id;
    }

    @Column(name = "cavity_1_process_2_id")
    public Integer getCavity1Process2Id() {

        return cavity1Process2Id;
    }

    public void setCavity1Process2Id(Integer cavity1Process2Id) {

        this.cavity1Process2Id = cavity1Process2Id;
    }

    @Column(name = "cavity_2_process_2_id")
    public Integer getCavity2Process2Id() {

        return cavity2Process2Id;
    }

    public void setCavity2Process2Id(Integer cavity2Process2Id) {

        this.cavity2Process2Id = cavity2Process2Id;
    }

    @Column(name = "cavity_3_process_2_id")
    public Integer getCavity3Process2Id() {

        return cavity3Process2Id;
    }

    public void setCavity3Process2Id(Integer cavity3Process2Id) {

        this.cavity3Process2Id = cavity3Process2Id;
    }

    @Column(name = "external_1_process_2_id")
    public Integer getExternal1Process2Id() {

        return external1Process2Id;
    }

    public void setExternal1Process2Id(Integer external1Process2Id) {

        this.external1Process2Id = external1Process2Id;
    }

    @Column(name = "external_2_process_2_id")
    public Integer getExternal2Process2Id() {

        return external2Process2Id;
    }

    public void setExternal2Process2Id(Integer external2Process2Id) {

        this.external2Process2Id = external2Process2Id;
    }

    @Column(name = "external_3_process_2_id")
    public Integer getExternal3Process2Id() {

        return external3Process2Id;
    }

    public void setExternal3Process2Id(Integer external3Process2Id) {

        this.external3Process2Id = external3Process2Id;
    }

    @Column(name = "external_4_process_2_id")
    public Integer getExternal4Process2Id() {

        return external4Process2Id;
    }

    public void setExternal4Process2Id(Integer external4Process2Id) {

        this.external4Process2Id = external4Process2Id;
    }

    @Column(name = "glass_1_process_3_id")
    public Integer getGlass1Process3Id() {

        return glass1Process3Id;
    }

    public void setGlass1Process3Id(Integer glass1Process3Id) {

        this.glass1Process3Id = glass1Process3Id;
    }

    @Column(name = "glass_2_process_3_id")
    public Integer getGlass2Process3Id() {

        return glass2Process3Id;
    }

    public void setGlass2Process3Id(Integer glass2Process3Id) {

        this.glass2Process3Id = glass2Process3Id;
    }

    @Column(name = "glass_3_process_3_id")
    public Integer getGlass3Process3Id() {

        return glass3Process3Id;
    }

    public void setGlass3Process3Id(Integer glass3Process3Id) {

        this.glass3Process3Id = glass3Process3Id;
    }

    @Column(name = "glass_4_process_3_id")
    public Integer getGlass4Process3Id() {

        return glass4Process3Id;
    }

    public void setGlass4Process3Id(Integer glass4Process3Id) {

        this.glass4Process3Id = glass4Process3Id;
    }

    @Column(name = "cavity_1_process_3_id")
    public Integer getCavity1Process3Id() {

        return cavity1Process3Id;
    }

    public void setCavity1Process3Id(Integer cavity1Process3Id) {

        this.cavity1Process3Id = cavity1Process3Id;
    }

    @Column(name = "cavity_2_process_3_id")
    public Integer getCavity2Process3Id() {

        return cavity2Process3Id;
    }

    public void setCavity2Process3Id(Integer cavity2Process3Id) {

        this.cavity2Process3Id = cavity2Process3Id;
    }

    @Column(name = "cavity_3_process_3_id")
    public Integer getCavity3Process3Id() {

        return cavity3Process3Id;
    }

    public void setCavity3Process3Id(Integer cavity3Process3Id) {

        this.cavity3Process3Id = cavity3Process3Id;
    }

    @Column(name = "external_1_process_3_id")
    public Integer getExternal1Process3Id() {

        return external1Process3Id;
    }

    public void setExternal1Process3Id(Integer external1Process3Id) {

        this.external1Process3Id = external1Process3Id;
    }

    @Column(name = "external_2_process_3_id")
    public Integer getExternal2Process3Id() {

        return external2Process3Id;
    }

    public void setExternal2Process3Id(Integer external2Process3Id) {

        this.external2Process3Id = external2Process3Id;
    }

    @Column(name = "external_3_process_3_id")
    public Integer getExternal3Process3Id() {

        return external3Process3Id;
    }

    public void setExternal3Process3Id(Integer external3Process3Id) {

        this.external3Process3Id = external3Process3Id;
    }

    @Column(name = "external_4_process_3_id")
    public Integer getExternal4Process3Id() {

        return external4Process3Id;
    }

    public void setExternal4Process3Id(Integer external4Process3Id) {

        this.external4Process3Id = external4Process3Id;
    }

    @Column(name = "sealant_part_id")
    public Integer getSealantPartId() {

        return sealantPartId;
    }

    public void setSealantPartId(Integer sealantPartId) {

        this.sealantPartId = sealantPartId;
    }

    @Column(name = "family_id")
    public Integer getFamilyId() {

        return familyId;
    }

    public void setFamilyId(Integer familyId) {

        this.familyId = familyId;
    }

    @Column(name = "abbrev")
    public String getAbbrev() {

        return abbrev;
    }

    public void setAbbrev(String abbrev) {

        this.abbrev = abbrev;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    public byte[] getImage() {

        return image;
    }

    public void setImage(byte[] image) {

        this.image = image;
    }

    @Column(name = "insert_1_id")
    public Integer getInsert1Id() {

        return insert1Id;
    }

    public void setInsert1Id(Integer insert1Id) {

        this.insert1Id = insert1Id;
    }

    @Column(name = "insert_2_id")
    public Integer getInsert2Id() {

        return insert2Id;
    }

    public void setInsert2Id(Integer insert2Id) {

        this.insert2Id = insert2Id;
    }

    @Column(name = "insert_3_id")
    public Integer getInsert3Id() {

        return insert3Id;
    }

    public void setInsert3Id(Integer insert3Id) {

        this.insert3Id = insert3Id;
    }

    @Column(name = "measure")
    public Integer getMeasure() {

        return measure;
    }

    public void setMeasure(Integer measure) {

        this.measure = measure;
    }

    @Column(name = "inhouse", nullable = false)
    public boolean isInHouse() {

        return inHouse;
    }

    public void setInHouse(boolean inHouse) {

        this.inHouse = inHouse;
    }

    @Column(name = "assemblyid", nullable = false)
    public Integer getAssemblyId() {

        return assemblyId;
    }

    public void setAssemblyId(Integer assemblyId) {

        this.assemblyId = assemblyId;
    }

    @Column(name = "airspace1", nullable = false)
    public Integer getAirSpace1() {
        return airSpace1;
    }

    public void setAirSpace1(Integer airSpace1) {
        this.airSpace1 = airSpace1;
    }

    @Column(name = "airspace1i", nullable = false)
    public Integer getAirSpace1i() {
        return airSpace1i;
    }

    public void setAirSpace1i(Integer airSpace1i) {
        this.airSpace1i = airSpace1i;
    }

    @Column(name = "airspace2", nullable = false)
    public Integer getAirSpace2() {
        return airSpace2;
    }

    public void setAirSpace2(Integer airSpace2) {
        this.airSpace2 = airSpace2;
    }

    @Column(name = "airspace2i", nullable = false)
    public Integer getAirSpace2i() {
        return airSpace2i;
    }

    public void setAirSpace2i(Integer airSpace2i) {
        this.airSpace2i = airSpace2i;
    }

    @Column(name = "airspace3", nullable = false)
    public Integer getAirSpace3() {
        return airSpace3;
    }

    public void setAirSpace3(Integer airSpace3) {
        this.airSpace3 = airSpace3;
    }

    @Column(name = "airspace3i", nullable = false)
    public Integer getAirSpace3i() {
        return airSpace3i;
    }

    public void setAirSpace3i(Integer airSpace3i) {
        this.airSpace3i = airSpace3i;
    }
    
    @Column(name = "part_family")
    public Integer getPartFamily() {
		return partFamily;
	}

	public void setPartFamily(Integer partFamily) {
		this.partFamily = partFamily;
	}

    @Column(name = "flag_color")
    public Integer getFlagColor() {
        return flagColor;
    }

    public void setFlagColor(Integer flagColor) {
        this.flagColor = flagColor;
    }

    @Transient
    public int getSupplierRemoteId() {
        return supplierRemoteId;
    }

    public void setSupplierRemoteId(int supplierRemoteId) {
        this.supplierRemoteId = supplierRemoteId;
    }

    @Transient
    public int getSupplierSeriesId() {
        return supplierSeriesId;
    }

    public void setSupplierSeriesId(int supplierSeriesId) {
        this.supplierSeriesId = supplierSeriesId;
    }

    @Transient
    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean isRemote) {
        this.isRemote = isRemote;
    }

    /**
     * To String description class
     *
     * @return String
     */
    @Override
    public String toString() {
        return this.getDescription();
    }
}

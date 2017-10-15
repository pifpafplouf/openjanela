package openjanela.model.entities.design;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 12-23-12
 *          Time: 03:30 PM
 */
@Entity
@Table(name = "design_glass")
@Cacheable
public class DesignGlassEntityObject implements Serializable {

    //Serializable version
    private static final long serialVersionUID = -1649735612505830358L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "level_id", nullable = false)
    private int levelId = 0;

    @Column(name = "sequence_id", nullable = false)
    private int sequenceId = 0;

    @Column(name = "assembly_level_id", nullable = false)
    private int assemblyLevelId = 0;

    @Column(name = "su_id", nullable = false)
    private int suID = 0;

    @Column(name = "stock_code", nullable = false)
    private String stockCode = "";

    @Column(name = "description", nullable = false)
    private String description = "";

    @Column(name = "abbrev", nullable = false)
    private String abbrev = "";

    @Column(name = "min_area", nullable = false)
    private double minArea = 0;

    @Column(name = "min_area_i", nullable = false)
    private double minAreaImp = 0;

    @Column(name = "max_area", nullable = false)
    private double maxArea = 0;

    @Column(name = "max_area_i", nullable = false)
    private double maxAreaImp = 0;

    @Column(name = "min_width", nullable = false)
    private int minWidth = 0;

    @Column(name = "min_width_i", nullable = false)
    private int minWidthImp = 0;

    @Column(name = "min_height", nullable = false)
    private int minHeight = 0;

    @Column(name = "min_height_i", nullable = false)
    private int minHeightImp = 0;

    @Column(name = "max_width", nullable = false)
    private int maxWidth = 0;

    @Column(name = "max_width_i", nullable = false)
    private int maxWidthImp = 0;

    @Column(name = "max_height", nullable = false)
    private int maxHeight = 0;

    @Column(name = "max_height_i", nullable = false)
    private int maxHeightImp = 0;

    @Column(name = "wh_ratio", nullable = false)
    private double whRatio = 0;

    @Column(name = "pricing_uom_id", nullable = false)
    private int pricingUOMId = 0;

    @Column(name = "price_actual_size", nullable = false)
    private boolean priceActualSize = false;

    @Column(name = "cost", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal cost = new BigDecimal("0");

    @Column(name = "cost_actual_size", nullable = false)
    private boolean costActualSize = false;

    @Column(name = "price_matrix_id", nullable = false)
    private int priceMatrixId = 0;

    @Column(name = "price", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal price = new BigDecimal("0");

    @Column(name = "price_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal priceUser = new BigDecimal("0");

    @Column(name = "min_pricing_area", nullable = false)
    private double minPricingArea = 0;

    @Column(name = "min_pricing_area_i", nullable = false)
    private double minPricingAreaImp = 0;

    @Column(name = "min_price", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal minPrice = new BigDecimal("0");

    @Column(name = "cost_group_id", nullable = false)
    private int costGroupId = 0;

    @Column(name = "price_group_id", nullable = false)
    private int priceGroupId = 0;

    @Column(name = "start_date", nullable = true)
    private Date startDate = new Date();

    @Column(name = "end_date", nullable = true)
    private Date endDate = new Date();

    @Column(name = "partner_group_id", nullable = false)
    private int partnerGroupId = 0;

    @Column(name = "next_item", nullable = false)
    private int nextItem = 0;

    @Column(name = "is_display", nullable = false)
    private boolean display = false;

    @Column(name = "is_waste", nullable = false)
    private double waste = 0;

    @Column(name = "is_made_in", nullable = false)
    private boolean madeIn = false;

    @Column(name = "supplier_id", nullable = false)
    private int supplierId = 0;

    @Column(name = "lead_time", nullable = false)
    private int leadTime = 0;

    @Column(name = "min_cost_area", nullable = false)
    private double minCostArea = 0;

    @Column(name = "min_cost_area_i", nullable = false)
    private double minCostAreaImp = 0;

    @Column(name = "production_line", nullable = false)
    private int productionLine = 0;

    @Column(name = "sort_seq", nullable = false)
    private int sortSeq = 0;

    @Column(name = "glazing_type", nullable = false)
    private int glazingType = 0;

    @Column(name = "is_custom", nullable = false)
    private boolean isCustom = false;

    @Column(name = "num_of_leaves", nullable = false)
    private int numOfLeaves = 0;

    @Column(name = "thickness", nullable = false)
    private double thickness = 0;

    @Column(name = "thickness_i", nullable = false)
    private double thicknessImp = 0;

    @Column(name = "leaf_1", nullable = false)
    private int leaf1 = 0;

    @Column(name = "leaf_2", nullable = false)
    private int leaf2 = 0;

    @Column(name = "leaf_3", nullable = false)
    private int leaf3 = 0;

    @Column(name = "leaf_4", nullable = false)
    private int leaf4 = 0;

    @Column(name = "spacer_1", nullable = false)
    private int spacer1 = 0;

    @Column(name = "spacer_2", nullable = false)
    private int spacer2 = 0;

    @Column(name = "spacer_3", nullable = false)
    private int spacer3 = 0;

    @Column(name = "glass_to_spacer", nullable = false)
    private double glassToSpacer = 0;

    @Column(name = "glass_to_spacer_i", nullable = false)
    private double glassToSpacerImp = 0;

    @Column(name = "gas_1", nullable = false)
    private int gas1 = 0;

    @Column(name = "gas_2", nullable = false)
    private int gas2 = 0;

    @Column(name = "gas_3", nullable = false)
    private int gas3 = 0;

    @Column(name = "film_1", nullable = false)
    private int film1 = 0;

    @Column(name = "film_2", nullable = false)
    private int film2 = 0;

    @Column(name = "film_3", nullable = false)
    private int film3 = 0;

    @Column(name = "film_4", nullable = false)
    private int film4 = 0;

    @Column(name = "process_1", nullable = false)
    private int process1 = 0;

    @Column(name = "process_2", nullable = false)
    private int process2 = 0;

    @Column(name = "process_3", nullable = false)
    private int process3 = 0;

    @Column(name = "process_4", nullable = false)
    private int process4 = 0;

    @Column(name = "cavity_process_1", nullable = false)
    private int cavityProcess1 = 0;

    @Column(name = "cavity_process_2", nullable = false)
    private int cavityProcess2 = 0;

    @Column(name = "cavity_process_3", nullable = false)
    private int cavityProcess3 = 0;

    @Column(name = "cavity_1_process_2", nullable = false)
    private int cavity1Process2 = 0;

    @Column(name = "cavity_2_process_2", nullable = false)
    private int cavity2Process2 = 0;

    @Column(name = "cavity_3_process_2", nullable = false)
    private int cavity3Process2 = 0;

    @Column(name = "cavity_1_process_3", nullable = false)
    private int cavity1Process3 = 0;

    @Column(name = "cavity_2_process_3", nullable = false)
    private int cavity2Process3 = 0;

    @Column(name = "cavity_3_process_3", nullable = false)
    private int cavity3Process3 = 0;

    @Column(name = "external_process_1", nullable = false)
    private int externalProcess1 = 0;

    @Column(name = "external_process_2", nullable = false)
    private int externalProcess2 = 0;

    @Column(name = "external_process_3", nullable = false)
    private int externalProcess3 = 0;

    @Column(name = "external_process_4", nullable = false)
    private int externalProcess4 = 0;

    @Column(name = "external_1_process_2", nullable = false)
    private int external1Process2 = 0;

    @Column(name = "external_2_process_2", nullable = false)
    private int external2Process2 = 0;

    @Column(name = "external_3_process_2", nullable = false)
    private int external3Process2 = 0;

    @Column(name = "external_4_process_2", nullable = false)
    private int external4Process2 = 0;

    @Column(name = "external_1_process_3", nullable = false)
    private int external1Process3 = 0;

    @Column(name = "external_2_process_3", nullable = false)
    private int external2Process3 = 0;

    @Column(name = "external_3_process_3", nullable = false)
    private int external3Process3 = 0;

    @Column(name = "external_4_process_3", nullable = false)
    private int external4Process3 = 0;

    @Column(name = "glass_1", nullable = false)
    private int glass1 = 0;

    @Column(name = "glass_2", nullable = false)
    private int glass2 = 0;

    @Column(name = "glass_3", nullable = false)
    private int glass3 = 0;

    @Column(name = "glass_4", nullable = false)
    private int glass4 = 0;

    @Column(name = "glass_1_process_2", nullable = false)
    private int glass1Process2 = 0;

    @Column(name = "glass_2_process_2", nullable = false)
    private int glass2Process2 = 0;

    @Column(name = "glass_3_process_2", nullable = false)
    private int glass3Process2 = 0;

    @Column(name = "glass_4_process_2", nullable = false)
    private int glass4Process2 = 0;

    @Column(name = "glass_1_process_3", nullable = false)
    private int glass1Process3 = 0;

    @Column(name = "glass_2_process_3", nullable = false)
    private int glass2Process3 = 0;

    @Column(name = "glass_3_process_3", nullable = false)
    private int glass3Process3 = 0;

    @Column(name = "glass_4_process_3", nullable = false)
    private int glass4Process3 = 0;

    @Column(name = "sealant_part_id", nullable = false)
    private int sealantPartId = 0;

    @Column(name = "family_id", nullable = false)
    private int familyId = 0;

    @Column(name = "insert_1_id", nullable = false)
    private int insert1Id = 0;

    @Column(name = "insert_2_id", nullable = false)
    private int insert2Id = 0;

    @Column(name = "insert_3_id", nullable = false)
    private int insert3Id = 0;

    @Column(name = "leaf_no", nullable = false)
    private int leafNo = 0;

    @Column(name = "leaf_in", nullable = false)
    private int leafIn = 0;

    @Column(name = "leaf_out", nullable = false)
    private int leafOut = 0;

    @Column(name = "spacer_thick_1", nullable = false)
    private double spacerThick1 = 0;

    @Column(name = "spacer_thick_2", nullable = false)
    private double spacerThick2 = 0;

    @Column(name = "spacer_thick_3", nullable = false)
    private double spacerThick3 = 0;

    @Column(name = "air_space_1", nullable = false)
    private double airSpace1 = 0;

    @Column(name = "air_space_2", nullable = false)
    private double airSpace2 = 0;

    @Column(name = "air_space_3", nullable = false)
    private double airSpace3 = 0;

    @Column(name = "spacer_thick_1_i", nullable = false)
    private double spacerThick1I = 0;

    @Column(name = "spacer_thick_2_i", nullable = false)
    private double spacerThick2I = 0;

    @Column(name = "spacer_thick_3_i", nullable = false)
    private double spacerThick3I = 0;

    @Column(name = "air_space_1_i", nullable = false)
    private double airSpace1I = 0;

    @Column(name = "air_space_2_i", nullable = false)
    private double airSpace2I = 0;

    @Column(name = "air_space_3_i", nullable = false)
    private double airSpace3I = 0;

    @Column(name = "measure", nullable = false)
    private int measure = 0;

    @Column(name = "ud_opening_id", nullable = false)
    private int udOpeningID = 0;

    @Column(name = "shape_id", nullable = false)
    private int shapeID = 0;

    @Column(name = "assembly_id", nullable = false)
    private int assemblyID = 0;

    @Column(name = "width_m", nullable = false)
    private int widthM = 0;

    @Column(name = "height_m", nullable = false)
    private int heightM = 0;

    @Column(name = "width_i", nullable = false)
    private int widthI = 0;

    @Column(name = "height_i", nullable = false)
    private int heightI = 0;

    @Column(name = "width_m_n", nullable = false)
    private int widthMN = 0;

    @Column(name = "height_m_n", nullable = false)
    private int heightMN = 0;

    @Column(name = "width_i_n", nullable = false)
    private int widthIN = 0;

    @Column(name = "height_i_n", nullable = false)
    private int heightIN = 0;

    @Column(name = "parent_col", nullable = false)
    private int parentCol = 0;

    @Column(name = "prod_line", nullable = false)
    private int prodLine = 0;

    @Column(name = "station", nullable = false)
    private int station = 0;

    @Column(name = "report", nullable = false)
    private int report = 0;

    @Column(name = "delivery", nullable = false)
    private int delivery = 0;

    @Column(name = "req_for_stage", nullable = false)
    private int reqforstage = 0;

    @Column(name = "part_family", nullable = false)
    private int partFamily = 0;

    @Column(name = "price_group", nullable = false)
    private int priceGroup = 0;

    @Column(name = "price_cat", nullable = false)
    private int priceCat = 0;

    @Column(name = "grid_id", nullable = false)
    private int gridID = 0;

    @Column(name = "grid_type", nullable = false)
    private int gridType = 0;

    @Column(name = "no_grids_v", nullable = false)
    private int noGridsV = 0;

    @Column(name = "no_grids_h", nullable = false)
    private int noGridsH = 0;

    @Column(name = "no_grids_s", nullable = false)
    private int noGridsS = 0;

    @Column(name = "no_grids_r", nullable = false)
    private int noGridsR = 0;

    @Column(name = "supplier_remote_id", nullable = false)
    private int supplierRemoteId = 0;

    @Column(name = "supplier_series_id", nullable = false)
    private int supplierSeriesId = 0;

    @Column(name = "remote", nullable = false)
    private boolean remote = false;

    @Transient
    private int glassBomId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "map_id", referencedColumnName = "id")
    private ConstructionMap constructionMap;

    public DesignGlassEntityObject() {}

    public DesignGlassEntityObject(int levelId, int sequenceId, int assemblyLevelId, int suID, String stockCode,
                                   String description, String abbrev, double minArea, double minAreaImp, double maxArea,
                                   double maxAreaImp, int minWidth, int minWidthImp, int minHeight, int minHeightImp,
                                   int maxWidth, int maxWidthImp, int maxHeight, int maxHeightImp, double whRatio,
                                   int pricingUOMId, boolean priceActualSize, BigDecimal cost, boolean costActualSize,
                                   int priceMatrixId, BigDecimal price, BigDecimal priceUser, double minPricingArea,
                                   double minPricingAreaImp, BigDecimal minPrice, int costGroupId, int priceGroupId,
                                   Date startDate, Date endDate, int partnerGroupId, int nextItem, boolean display,
                                   double waste, boolean madeIn, int supplierId, int leadTime, double minCostArea,
                                   double minCostAreaImp, int productionLine, int sortSeq, int glazingType, boolean isCustom,
                                   int numOfLeaves, double thickness, double thicknessImp, int leaf1, int leaf2, int leaf3,
                                   int leaf4, int spacer1, int spacer2, int spacer3, double glassToSpacer, double glassToSpacerImp,
                                   int gas1, int gas2, int gas3, int film1, int film2, int film3, int film4, int process1,
                                   int process2, int process3, int process4, int cavityProcess1, int cavityProcess2,
                                   int cavityProcess3, int cavity1Process2, int cavity2Process2, int cavity3Process2,
                                   int cavity1Process3, int cavity2Process3, int cavity3Process3, int externalProcess1,
                                   int externalProcess2, int externalProcess3, int externalProcess4, int external1Process2,
                                   int external2Process2, int external3Process2, int external4Process2, int external1Process3,
                                   int external2Process3, int external3Process3, int external4Process3, int glass1, int glass2,
                                   int glass3, int glass4, int glass1Process2, int glass2Process2, int glass3Process2,
                                   int glass4Process2, int glass1Process3, int glass2Process3, int glass3Process3,
                                   int glass4Process3, int sealantPartId, int familyId, int insert1Id, int insert2Id,
                                   int insert3Id, int leafNo, int leafIn, int leafOut, double spacerThick1, double spacerThick2,
                                   double spacerThick3, double airSpace1, double airSpace2, double airSpace3, double spacerThick1I,
                                   double spacerThick2I, double spacerThick3I, double airSpace1I, double airSpace2I, double airSpace3I,
                                   int measure, int udOpeningID, int shapeID, int assemblyID, int widthM, int heightM, int widthI,
                                   int heightI, int widthMN, int heightMN, int widthIN, int heightIN, int parentCol, int prodLine,
                                   int station, int report, int delivery, int reqforstage, int partFamily, int priceGroup,
                                   int priceCat, int gridID, int gridType, int noGridsV, int noGridsH, int noGridsS,
                                   int noGridsR, int supplierRemoteId, int supplierSeriesId, boolean remote,
                                   ConstructionMap constructionMap) {

        this.levelId = levelId;
        this.sequenceId = sequenceId;
        this.assemblyLevelId = assemblyLevelId;
        this.suID = suID;
        this.stockCode = stockCode;
        this.description = description;
        this.abbrev = abbrev;
        this.minArea = minArea;
        this.minAreaImp = minAreaImp;
        this.maxArea = maxArea;
        this.maxAreaImp = maxAreaImp;
        this.minWidth = minWidth;
        this.minWidthImp = minWidthImp;
        this.minHeight = minHeight;
        this.minHeightImp = minHeightImp;
        this.maxWidth = maxWidth;
        this.maxWidthImp = maxWidthImp;
        this.maxHeight = maxHeight;
        this.maxHeightImp = maxHeightImp;
        this.whRatio = whRatio;
        this.pricingUOMId = pricingUOMId;
        this.priceActualSize = priceActualSize;
        this.cost = cost;
        this.costActualSize = costActualSize;
        this.priceMatrixId = priceMatrixId;
        this.price = price;
        this.priceUser = priceUser;
        this.minPricingArea = minPricingArea;
        this.minPricingAreaImp = minPricingAreaImp;
        this.minPrice = minPrice;
        this.costGroupId = costGroupId;
        this.priceGroupId = priceGroupId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.partnerGroupId = partnerGroupId;
        this.nextItem = nextItem;
        this.display = display;
        this.waste = waste;
        this.madeIn = madeIn;
        this.supplierId = supplierId;
        this.leadTime = leadTime;
        this.minCostArea = minCostArea;
        this.minCostAreaImp = minCostAreaImp;
        this.productionLine = productionLine;
        this.sortSeq = sortSeq;
        this.glazingType = glazingType;
        this.isCustom = isCustom;
        this.numOfLeaves = numOfLeaves;
        this.thickness = thickness;
        this.thicknessImp = thicknessImp;
        this.leaf1 = leaf1;
        this.leaf2 = leaf2;
        this.leaf3 = leaf3;
        this.leaf4 = leaf4;
        this.spacer1 = spacer1;
        this.spacer2 = spacer2;
        this.spacer3 = spacer3;
        this.glassToSpacer = glassToSpacer;
        this.glassToSpacerImp = glassToSpacerImp;
        this.gas1 = gas1;
        this.gas2 = gas2;
        this.gas3 = gas3;
        this.film1 = film1;
        this.film2 = film2;
        this.film3 = film3;
        this.film4 = film4;
        this.process1 = process1;
        this.process2 = process2;
        this.process3 = process3;
        this.process4 = process4;
        this.cavityProcess1 = cavityProcess1;
        this.cavityProcess2 = cavityProcess2;
        this.cavityProcess3 = cavityProcess3;
        this.cavity1Process2 = cavity1Process2;
        this.cavity2Process2 = cavity2Process2;
        this.cavity3Process2 = cavity3Process2;
        this.cavity1Process3 = cavity1Process3;
        this.cavity2Process3 = cavity2Process3;
        this.cavity3Process3 = cavity3Process3;
        this.externalProcess1 = externalProcess1;
        this.externalProcess2 = externalProcess2;
        this.externalProcess3 = externalProcess3;
        this.externalProcess4 = externalProcess4;
        this.external1Process2 = external1Process2;
        this.external2Process2 = external2Process2;
        this.external3Process2 = external3Process2;
        this.external4Process2 = external4Process2;
        this.external1Process3 = external1Process3;
        this.external2Process3 = external2Process3;
        this.external3Process3 = external3Process3;
        this.external4Process3 = external4Process3;
        this.glass1 = glass1;
        this.glass2 = glass2;
        this.glass3 = glass3;
        this.glass4 = glass4;
        this.glass1Process2 = glass1Process2;
        this.glass2Process2 = glass2Process2;
        this.glass3Process2 = glass3Process2;
        this.glass4Process2 = glass4Process2;
        this.glass1Process3 = glass1Process3;
        this.glass2Process3 = glass2Process3;
        this.glass3Process3 = glass3Process3;
        this.glass4Process3 = glass4Process3;
        this.sealantPartId = sealantPartId;
        this.familyId = familyId;
        this.insert1Id = insert1Id;
        this.insert2Id = insert2Id;
        this.insert3Id = insert3Id;
        this.leafNo = leafNo;
        this.leafIn = leafIn;
        this.leafOut = leafOut;
        this.spacerThick1 = spacerThick1;
        this.spacerThick2 = spacerThick2;
        this.spacerThick3 = spacerThick3;
        this.airSpace1 = airSpace1;
        this.airSpace2 = airSpace2;
        this.airSpace3 = airSpace3;
        this.spacerThick1I = spacerThick1I;
        this.spacerThick2I = spacerThick2I;
        this.spacerThick3I = spacerThick3I;
        this.airSpace1I = airSpace1I;
        this.airSpace2I = airSpace2I;
        this.airSpace3I = airSpace3I;
        this.measure = measure;
        this.udOpeningID = udOpeningID;
        this.shapeID = shapeID;
        this.assemblyID = assemblyID;
        this.widthM = widthM;
        this.heightM = heightM;
        this.widthI = widthI;
        this.heightI = heightI;
        this.widthMN = widthMN;
        this.heightMN = heightMN;
        this.widthIN = widthIN;
        this.heightIN = heightIN;
        this.parentCol = parentCol;
        this.prodLine = prodLine;
        this.station = station;
        this.report = report;
        this.delivery = delivery;
        this.reqforstage = reqforstage;
        this.partFamily = partFamily;
        this.priceGroup = priceGroup;
        this.priceCat = priceCat;
        this.gridID = gridID;
        this.gridType = gridType;
        this.noGridsV = noGridsV;
        this.noGridsH = noGridsH;
        this.noGridsS = noGridsS;
        this.noGridsR = noGridsR;
        this.supplierRemoteId = supplierRemoteId;
        this.supplierSeriesId = supplierSeriesId;
        this.remote = remote;
        this.constructionMap = constructionMap;
    }

    // ==================================<GETTTER AND SETTERS>=================================================


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public int getAssemblyLevelId() {
        return assemblyLevelId;
    }

    public void setAssemblyLevelId(int assemblyLevelId) {
        this.assemblyLevelId = assemblyLevelId;
    }

    public int getSuID() {
        return suID;
    }

    public void setSuID(int suID) {
        this.suID = suID;
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

    public double getMinArea() {
        return minArea;
    }

    public void setMinArea(double minArea) {
        this.minArea = minArea;
    }

    public double getMinAreaImp() {
        return minAreaImp;
    }

    public void setMinAreaImp(double minAreaImp) {
        this.minAreaImp = minAreaImp;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(double maxArea) {
        this.maxArea = maxArea;
    }

    public double getMaxAreaImp() {
        return maxAreaImp;
    }

    public void setMaxAreaImp(double maxAreaImp) {
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

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxWidthImp() {
        return maxWidthImp;
    }

    public void setMaxWidthImp(int maxWidthImp) {
        this.maxWidthImp = maxWidthImp;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMaxHeightImp() {
        return maxHeightImp;
    }

    public void setMaxHeightImp(int maxHeightImp) {
        this.maxHeightImp = maxHeightImp;
    }

    public double getWhRatio() {
        return whRatio;
    }

    public void setWhRatio(double whRatio) {
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

    public BigDecimal getPriceUser() {
        return priceUser;
    }

    public void setPriceUser(BigDecimal priceUser) {
        this.priceUser = priceUser;
    }

    public double getMinPricingArea() {
        return minPricingArea;
    }

    public void setMinPricingArea(double minPricingArea) {
        this.minPricingArea = minPricingArea;
    }

    public double getMinPricingAreaImp() {
        return minPricingAreaImp;
    }

    public void setMinPricingAreaImp(double minPricingAreaImp) {
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

    public double getWaste() {
        return waste;
    }

    public void setWaste(double waste) {
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

    public double getMinCostArea() {
        return minCostArea;
    }

    public void setMinCostArea(double minCostArea) {
        this.minCostArea = minCostArea;
    }

    public double getMinCostAreaImp() {
        return minCostAreaImp;
    }

    public void setMinCostAreaImp(double minCostAreaImp) {
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

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double getThicknessImp() {
        return thicknessImp;
    }

    public void setThicknessImp(double thicknessImp) {
        this.thicknessImp = thicknessImp;
    }

    public int getLeaf1() {
        return leaf1;
    }

    public void setLeaf1(int leaf1) {
        this.leaf1 = leaf1;
    }

    public int getLeaf2() {
        return leaf2;
    }

    public void setLeaf2(int leaf2) {
        this.leaf2 = leaf2;
    }

    public int getLeaf3() {
        return leaf3;
    }

    public void setLeaf3(int leaf3) {
        this.leaf3 = leaf3;
    }

    public int getLeaf4() {
        return leaf4;
    }

    public void setLeaf4(int leaf4) {
        this.leaf4 = leaf4;
    }

    public int getSpacer1() {
        return spacer1;
    }

    public void setSpacer1(int spacer1) {
        this.spacer1 = spacer1;
    }

    public int getSpacer2() {
        return spacer2;
    }

    public void setSpacer2(int spacer2) {
        this.spacer2 = spacer2;
    }

    public int getSpacer3() {
        return spacer3;
    }

    public void setSpacer3(int spacer3) {
        this.spacer3 = spacer3;
    }

    public double getGlassToSpacer() {
        return glassToSpacer;
    }

    public void setGlassToSpacer(double glassToSpacer) {
        this.glassToSpacer = glassToSpacer;
    }

    public double getGlassToSpacerImp() {
        return glassToSpacerImp;
    }

    public void setGlassToSpacerImp(double glassToSpacerImp) {
        this.glassToSpacerImp = glassToSpacerImp;
    }

    public int getGas1() {
        return gas1;
    }

    public void setGas1(int gas1) {
        this.gas1 = gas1;
    }

    public int getGas2() {
        return gas2;
    }

    public void setGas2(int gas2) {
        this.gas2 = gas2;
    }

    public int getGas3() {
        return gas3;
    }

    public void setGas3(int gas3) {
        this.gas3 = gas3;
    }

    public int getFilm1() {
        return film1;
    }

    public void setFilm1(int film1) {
        this.film1 = film1;
    }

    public int getFilm2() {
        return film2;
    }

    public void setFilm2(int film2) {
        this.film2 = film2;
    }

    public int getFilm3() {
        return film3;
    }

    public void setFilm3(int film3) {
        this.film3 = film3;
    }

    public int getFilm4() {
        return film4;
    }

    public void setFilm4(int film4) {
        this.film4 = film4;
    }

    public int getProcess1() {
        return process1;
    }

    public void setProcess1(int process1) {
        this.process1 = process1;
    }

    public int getProcess2() {
        return process2;
    }

    public void setProcess2(int process2) {
        this.process2 = process2;
    }

    public int getProcess3() {
        return process3;
    }

    public void setProcess3(int process3) {
        this.process3 = process3;
    }

    public int getProcess4() {
        return process4;
    }

    public void setProcess4(int process4) {
        this.process4 = process4;
    }

    public int getCavityProcess1() {
        return cavityProcess1;
    }

    public void setCavityProcess1(int cavityProcess1) {
        this.cavityProcess1 = cavityProcess1;
    }

    public int getCavityProcess2() {
        return cavityProcess2;
    }

    public void setCavityProcess2(int cavityProcess2) {
        this.cavityProcess2 = cavityProcess2;
    }

    public int getCavityProcess3() {
        return cavityProcess3;
    }

    public void setCavityProcess3(int cavityProcess3) {
        this.cavityProcess3 = cavityProcess3;
    }

    public int getCavity1Process2() {
        return cavity1Process2;
    }

    public void setCavity1Process2(int cavity1Process2) {
        this.cavity1Process2 = cavity1Process2;
    }

    public int getCavity2Process2() {
        return cavity2Process2;
    }

    public void setCavity2Process2(int cavity2Process2) {
        this.cavity2Process2 = cavity2Process2;
    }

    public int getCavity3Process2() {
        return cavity3Process2;
    }

    public void setCavity3Process2(int cavity3Process2) {
        this.cavity3Process2 = cavity3Process2;
    }

    public int getCavity1Process3() {
        return cavity1Process3;
    }

    public void setCavity1Process3(int cavity1Process3) {
        this.cavity1Process3 = cavity1Process3;
    }

    public int getCavity2Process3() {
        return cavity2Process3;
    }

    public void setCavity2Process3(int cavity2Process3) {
        this.cavity2Process3 = cavity2Process3;
    }

    public int getCavity3Process3() {
        return cavity3Process3;
    }

    public void setCavity3Process3(int cavity3Process3) {
        this.cavity3Process3 = cavity3Process3;
    }

    public int getExternalProcess1() {
        return externalProcess1;
    }

    public void setExternalProcess1(int externalProcess1) {
        this.externalProcess1 = externalProcess1;
    }

    public int getExternalProcess2() {
        return externalProcess2;
    }

    public void setExternalProcess2(int externalProcess2) {
        this.externalProcess2 = externalProcess2;
    }

    public int getExternalProcess3() {
        return externalProcess3;
    }

    public void setExternalProcess3(int externalProcess3) {
        this.externalProcess3 = externalProcess3;
    }

    public int getExternalProcess4() {
        return externalProcess4;
    }

    public void setExternalProcess4(int externalProcess4) {
        this.externalProcess4 = externalProcess4;
    }

    public int getExternal1Process2() {
        return external1Process2;
    }

    public void setExternal1Process2(int external1Process2) {
        this.external1Process2 = external1Process2;
    }

    public int getExternal2Process2() {
        return external2Process2;
    }

    public void setExternal2Process2(int external2Process2) {
        this.external2Process2 = external2Process2;
    }

    public int getExternal3Process2() {
        return external3Process2;
    }

    public void setExternal3Process2(int external3Process2) {
        this.external3Process2 = external3Process2;
    }

    public int getExternal4Process2() {
        return external4Process2;
    }

    public void setExternal4Process2(int external4Process2) {
        this.external4Process2 = external4Process2;
    }

    public int getExternal1Process3() {
        return external1Process3;
    }

    public void setExternal1Process3(int external1Process3) {
        this.external1Process3 = external1Process3;
    }

    public int getExternal2Process3() {
        return external2Process3;
    }

    public void setExternal2Process3(int external2Process3) {
        this.external2Process3 = external2Process3;
    }

    public int getExternal3Process3() {
        return external3Process3;
    }

    public void setExternal3Process3(int external3Process3) {
        this.external3Process3 = external3Process3;
    }

    public int getExternal4Process3() {
        return external4Process3;
    }

    public void setExternal4Process3(int external4Process3) {
        this.external4Process3 = external4Process3;
    }

    public int getGlass1() {
        return glass1;
    }

    public void setGlass1(int glass1) {
        this.glass1 = glass1;
    }

    public int getGlass2() {
        return glass2;
    }

    public void setGlass2(int glass2) {
        this.glass2 = glass2;
    }

    public int getGlass3() {
        return glass3;
    }

    public void setGlass3(int glass3) {
        this.glass3 = glass3;
    }

    public int getGlass4() {
        return glass4;
    }

    public void setGlass4(int glass4) {
        this.glass4 = glass4;
    }

    public int getGlass1Process2() {
        return glass1Process2;
    }

    public void setGlass1Process2(int glass1Process2) {
        this.glass1Process2 = glass1Process2;
    }

    public int getGlass2Process2() {
        return glass2Process2;
    }

    public void setGlass2Process2(int glass2Process2) {
        this.glass2Process2 = glass2Process2;
    }

    public int getGlass3Process2() {
        return glass3Process2;
    }

    public void setGlass3Process2(int glass3Process2) {
        this.glass3Process2 = glass3Process2;
    }

    public int getGlass4Process2() {
        return glass4Process2;
    }

    public void setGlass4Process2(int glass4Process2) {
        this.glass4Process2 = glass4Process2;
    }

    public int getGlass1Process3() {
        return glass1Process3;
    }

    public void setGlass1Process3(int glass1Process3) {
        this.glass1Process3 = glass1Process3;
    }

    public int getGlass2Process3() {
        return glass2Process3;
    }

    public void setGlass2Process3(int glass2Process3) {
        this.glass2Process3 = glass2Process3;
    }

    public int getGlass3Process3() {
        return glass3Process3;
    }

    public void setGlass3Process3(int glass3Process3) {
        this.glass3Process3 = glass3Process3;
    }

    public int getGlass4Process3() {
        return glass4Process3;
    }

    public void setGlass4Process3(int glass4Process3) {
        this.glass4Process3 = glass4Process3;
    }

    public int getSealantPartId() {
        return sealantPartId;
    }

    public void setSealantPartId(int sealantPartId) {
        this.sealantPartId = sealantPartId;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public int getInsert1Id() {
        return insert1Id;
    }

    public void setInsert1Id(int insert1Id) {
        this.insert1Id = insert1Id;
    }

    public int getInsert2Id() {
        return insert2Id;
    }

    public void setInsert2Id(int insert2Id) {
        this.insert2Id = insert2Id;
    }

    public int getInsert3Id() {
        return insert3Id;
    }

    public void setInsert3Id(int insert3Id) {
        this.insert3Id = insert3Id;
    }

    public int getLeafNo() {
        return leafNo;
    }

    public void setLeafNo(int leafNo) {
        this.leafNo = leafNo;
    }

    public int getLeafIn() {
        return leafIn;
    }

    public void setLeafIn(int leafIn) {
        this.leafIn = leafIn;
    }

    public int getLeafOut() {
        return leafOut;
    }

    public void setLeafOut(int leafOut) {
        this.leafOut = leafOut;
    }

    public double getSpacerThick1() {
        return spacerThick1;
    }

    public void setSpacerThick1(double spacerThick1) {
        this.spacerThick1 = spacerThick1;
    }

    public double getSpacerThick2() {
        return spacerThick2;
    }

    public void setSpacerThick2(double spacerThick2) {
        this.spacerThick2 = spacerThick2;
    }

    public double getSpacerThick3() {
        return spacerThick3;
    }

    public void setSpacerThick3(double spacerThick3) {
        this.spacerThick3 = spacerThick3;
    }

    public double getAirSpace1() {
        return airSpace1;
    }

    public void setAirSpace1(double airSpace1) {
        this.airSpace1 = airSpace1;
    }

    public double getAirSpace2() {
        return airSpace2;
    }

    public void setAirSpace2(double airSpace2) {
        this.airSpace2 = airSpace2;
    }

    public double getAirSpace3() {
        return airSpace3;
    }

    public void setAirSpace3(double airSpace3) {
        this.airSpace3 = airSpace3;
    }

    public double getSpacerThick1I() {
        return spacerThick1I;
    }

    public void setSpacerThick1I(double spacerThick1I) {
        this.spacerThick1I = spacerThick1I;
    }

    public double getSpacerThick2I() {
        return spacerThick2I;
    }

    public void setSpacerThick2I(double spacerThick2I) {
        this.spacerThick2I = spacerThick2I;
    }

    public double getSpacerThick3I() {
        return spacerThick3I;
    }

    public void setSpacerThick3I(double spacerThick3I) {
        this.spacerThick3I = spacerThick3I;
    }

    public double getAirSpace1I() {
        return airSpace1I;
    }

    public void setAirSpace1I(double airSpace1I) {
        this.airSpace1I = airSpace1I;
    }

    public double getAirSpace2I() {
        return airSpace2I;
    }

    public void setAirSpace2I(double airSpace2I) {
        this.airSpace2I = airSpace2I;
    }

    public double getAirSpace3I() {
        return airSpace3I;
    }

    public void setAirSpace3I(double airSpace3I) {
        this.airSpace3I = airSpace3I;
    }

    public int getMeasure() {
        return measure;
    }

    public void setMeasure(int measure) {
        this.measure = measure;
    }

    public int getUdOpeningID() {
        return udOpeningID;
    }

    public void setUdOpeningID(int udOpeningID) {
        this.udOpeningID = udOpeningID;
    }

    public int getShapeID() {
        return shapeID;
    }

    public void setShapeID(int shapeID) {
        this.shapeID = shapeID;
    }

    public int getAssemblyID() {
        return assemblyID;
    }

    public void setAssemblyID(int assemblyID) {
        this.assemblyID = assemblyID;
    }

    public int getWidthM() {
        return widthM;
    }

    public void setWidthM(int widthM) {
        this.widthM = widthM;
    }

    public int getHeightM() {
        return heightM;
    }

    public void setHeightM(int heightM) {
        this.heightM = heightM;
    }

    public int getWidthI() {
        return widthI;
    }

    public void setWidthI(int widthI) {
        this.widthI = widthI;
    }

    public int getHeightI() {
        return heightI;
    }

    public void setHeightI(int heightI) {
        this.heightI = heightI;
    }

    public int getWidthMN() {
        return widthMN;
    }

    public void setWidthMN(int widthMN) {
        this.widthMN = widthMN;
    }

    public int getHeightMN() {
        return heightMN;
    }

    public void setHeightMN(int heightMN) {
        this.heightMN = heightMN;
    }

    public int getWidthIN() {
        return widthIN;
    }

    public void setWidthIN(int widthIN) {
        this.widthIN = widthIN;
    }

    public int getHeightIN() {
        return heightIN;
    }

    public void setHeightIN(int heightIN) {
        this.heightIN = heightIN;
    }

    public int getParentCol() {
        return parentCol;
    }

    public void setParentCol(int parentCol) {
        this.parentCol = parentCol;
    }

    public int getProdLine() {
        return prodLine;
    }

    public void setProdLine(int prodLine) {
        this.prodLine = prodLine;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public int getReport() {
        return report;
    }

    public void setReport(int report) {
        this.report = report;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public int getReqforstage() {
        return reqforstage;
    }

    public void setReqforstage(int reqforstage) {
        this.reqforstage = reqforstage;
    }

    public int getPartFamily() {
        return partFamily;
    }

    public void setPartFamily(int partFamily) {
        this.partFamily = partFamily;
    }

    public int getPriceGroup() {
        return priceGroup;
    }

    public void setPriceGroup(int priceGroup) {
        this.priceGroup = priceGroup;
    }

    public int getPriceCat() {
        return priceCat;
    }

    public void setPriceCat(int priceCat) {
        this.priceCat = priceCat;
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

    public int getSupplierRemoteId() {
        return supplierRemoteId;
    }

    public void setSupplierRemoteId(int supplierRemoteId) {
        this.supplierRemoteId = supplierRemoteId;
    }

    public int getSupplierSeriesId() {
        return supplierSeriesId;
    }

    public void setSupplierSeriesId(int supplierSeriesId) {
        this.supplierSeriesId = supplierSeriesId;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public int getGlassBomId() {
        return glassBomId;
    }

    public void setGlassBomId(int glassBomId) {
        this.glassBomId = glassBomId;
    }

    public ConstructionMap getConstructionMap() {
        return constructionMap;
    }

    public void setConstructionMap(ConstructionMap constructionMap) {
        this.constructionMap = constructionMap;
    }

}

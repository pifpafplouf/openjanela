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
 *          Date: 12-14-12
 *          Time: 01:25 AM
 */
@Entity
@Table(name = "design_bill_of_materials")
@Cacheable
public class BillOfMaterialEntityObject implements Serializable, Cloneable {

    //Serializable version
    private static final long serialVersionUID = -2714185451722332491L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer Id;

    @Column(name = "stock_code", nullable = false)
    private String stockCode = "";

    @Column(name = "description", nullable = false)
    private String description = "";

    @Column(name = "level_id", nullable = false)
    private int levelId = 0;

    @Column(name = "sequence_id", nullable = false)
    private int sequenceId = 0;

    @Column(name = "assembly_level_id", nullable = false)
    private int assemblyLevelId = 0;

    @Column(name = "assembly_id", nullable = false)
    private int assemblyId = 0;

    @Column(name = "order_id", nullable = false)
    private int orderId = 0;

    @Column(name = "item_no", nullable = false)
    private int itemNo = 0;

    @Column(name = "version_id", nullable = false)
    private int versionId = 0;

    @Column(name = "is_addon", nullable = false)
    private boolean addon = false;

    @Column(name = "rule_no", nullable = false)
    private int ruleNo = 0;

    @Column(name = "part_id", nullable = false)
    private int partId = 0;

    @Column(name = "seg_id", nullable = false)
    private int segId = 0;

    @Column(name = "supplier_id", nullable = false)
    private int supplierId = 0;

    @Column(name = "leaf_no", nullable = false)
    private int leafNo = 0;

    @Column(name = "qty", nullable = false)
    private int qty = 0;

    @Column(name = "cut_length", nullable = false)
    private int cutLength = 0;

    @Column(name = "cut_length_i", nullable = false)
    private int cutLengthI = 0;

    @Column(name = "width", nullable = false)
    private int width = 0;

    @Column(name = "width_i", nullable = false)
    private int widthI = 0;

    @Column(name = "height", nullable = false)
    private int height = 0;

    @Column(name = "height_i", nullable = false)
    private int heightI = 0;

    @Column(name = "level", nullable = false)
    private int level = 0;

    @Column(name = "position", nullable = false)
    private int position = 0;

    @Column(name = "orientation", nullable = false)
    private int orientation = 0;

    @Column(name = "start_pos", nullable = false)
    private int startPos = 0;

    @Column(name = "end_pos", nullable = false)
    private int endPos = 0;

    @Column(name = "opening_id", nullable = false)
    private int openingId = 0;

    @Column(name = "sash", nullable = false)
    private int sash = 0;

    @Column(name = "radius_1", nullable = false)
    private int radius1 = 0;

    @Column(name = "radius_1_i", nullable = false)
    private int radius1I = 0;

    @Column(name = "radius_2", nullable = false)
    private int radius2 = 0;

    @Column(name = "radius_2_i", nullable = false)
    private int radius2I = 0;

    @Column(name = "left_angle", nullable = false)
    private double leftAngle = 0;

    @Column(name = "right_angle", nullable = false)
    private double rightAngle = 0;

    @Column(name = "row", nullable = false)
    private int row = 0;

    @Column(name = "col", nullable = false)
    private int col = 0;

    @Column(name = "parent_row", nullable = false)
    private int parentRow = 0;

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

    @Column(name = "is_buy", nullable = false)
    private boolean buy = false;

    @Column(name = "lead_time", nullable = false)
    private int leadtime = 0;

    @Column(name = "is_track", nullable = false)
    private boolean track = false;

    @Column(name = "parent_assembly_id", nullable = false)
    private int parentAssemblyId = 0;

    @Column(name = "req_for_stage", nullable = false)
    private int reqForStage = 0;

    @Column(name = "sys_assembly_id", nullable = false)
    private int sysAssemblyId = 0;

    @Column(name = "cost", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal cost = new BigDecimal("0");

    @Column(name = "price", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal price = new BigDecimal("0");

    @Column(name = "total_price", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal totalPrice = new BigDecimal("0");

    @Column(name = "total_cost", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal totalCost = new BigDecimal("0");

    @Column(name = "price_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceUser = new BigDecimal("0");

    @Column(name = "total_price_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal totalPriceUser = new BigDecimal("0");

    @Column(name = "stock_code_user", nullable = true)
    private String stockcodeUser = "";

    @Column(name = "description_user", nullable = true)
    private String descriptionUser = "";

    @Column(name = "qty_user", nullable = false)
    private double qtyUser = 0;

    @Column(name = "cut_length_user", nullable = false)
    private int cutLengthUser = 0;

    @Column(name = "cut_length_i_user", nullable = false)
    private int cutLengthIUser = 0;

    @Column(name = "width_user", nullable = false)
    private int widthUser = 0;

    @Column(name = "width_i_user", nullable = false)
    private int widthIUser = 0;

    @Column(name = "height_user", nullable = false)
    private int heightUser = 0;

    @Column(name = "height_i_user", nullable = false)
    private int heightIUser = 0;

    @Column(name = "depth", nullable = false)
    private int depth = 0;

    @Column(name = "depth_i", nullable = false)
    private int depthI = 0;

    @Column(name = "depth_user", nullable = false)
    private int depthUser = 0;

    @Column(name = "depth_i_user", nullable = false)
    private int depthIUser = 0;

    @Column(name = "area", nullable = false)
    private double area = 0;

    @Column(name = "area_i", nullable = false)
    private double areaI = 0;

    @Column(name = "area_user", nullable = false)
    private double areaUser = 0;

    @Column(name = "area_i_user", nullable = false)
    private double areaIUser = 0;

    @Column(name = "volume", nullable = false)
    private double volume = 0;

    @Column(name = "volume_i", nullable = false)
    private double volumeI = 0;

    @Column(name = "volume_user", nullable = false)
    private double volumeUser = 0;

    @Column(name = "volume_i_user", nullable = false)
    private double volumeIUser = 0;

    @Column(name = "lengthw2", nullable = false)
    private double lengthw2;

    @Column(name = "lengthh2", nullable = false)
    private double lengthh2;

    @Column(name = "lengthf12", nullable = false)
    private double lengthf12;

    @Column(name = "lengthf22", nullable = false)
    private double lengthf22;

    @Column(name = "weld", nullable = false)
    private int weld = 0;

    @Column(name = "weld_i", nullable = false)
    private int weldI = 0;

    @Column(name = "weld_r", nullable = false)
    private int weldR = 0;

    @Column(name = "weld_r_i", nullable = false)
    private int weldRI = 0;

    @Column(name = "left_cut", nullable = false)
    private int leftCut = 0;

    @Column(name = "right_cut", nullable = false)
    private int rightCut = 0;

    @Column(name = "is_wild_size", nullable = false)
    private boolean isWildSize = false;

    @Column(name = "is_wild_depth", nullable = false)
    private boolean isWildDepth = false;

    @Column(name = "is_wild_color", nullable = false)
    private boolean isWildColor = false;

    @Column(name = "parent_rule", nullable = false)
    private int parentRule = 0;

    @Column(name = "part_family", nullable = false)
    private int partFamily = 0;

    @Column(name = "price_group", nullable = false)
    private int priceGroup = 0;

    @Column(name = "price_cat", nullable = false)
    private int priceCat = 0;

    @Column(name = "shape_id", nullable = false)
    private int shapeId = 0;

    @Column(name = "process_id", nullable = false)
    private int processId = 0;

    @Column(name = "is_assembly_bom", nullable = false)
    private boolean assemblyBom = false;

    @Column(name = "ships", nullable = false)
    private boolean ships = false;

    @Column(name = "notches", nullable = true)
    private String notchesM = "";

    @Column(name = "notches_i", nullable = true)
    private String notchesI = "";

    @Column(name = "notches_i_y", nullable = true)
    private String notchesIY = "";

    @Column(name = "supplier_rule_no", nullable = false)
    private int supplierRuleNo = 0;

    @Column(name = "supplier_part_id", nullable = false)
    private int supplierPartId = 0;

    @Column(name = "glass_made_in", nullable = false)
    private boolean glass_made_in = false;

    @Column(name = "bought_glazed")
    private boolean bought_glazed = false;

    @Column(name = "supplier_remote_id", nullable = false)
    private int supplierRemoteId;

    @Column(name = "supplier_series_id", nullable = false)
    private int supplierSeriesId;

    @Column(name = "remote", nullable = false)
    private boolean remote;

    @Lob
    @Column(name = "job_item_model", nullable = true)
    private byte[] job_item_model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_bom_id", referencedColumnName = "id", nullable = true)
    private BillOfMaterialEntityObject parentBom;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "glass_bom_id", referencedColumnName = "id", nullable = true)
    private DesignGlassEntityObject designGlass;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bom")
    private AssemblyEntityObject assembly;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "map_id", referencedColumnName = "id")
    private ConstructionMap constructionMap;

    //*************************************************
    // Properties not save only for model design
    //*************************************************
    @Transient
    private int bomId = 0;

    @Transient
    private int parentBomId = 0;

    @Transient
    private int glassBomId = 0;

    @Transient
    private int processLT = 0;

    @Transient
    private String masterStockCode = "";

    @Transient
    private int batchId = 0;

    @Transient
    private int subBatchId = 0;

    @Transient
    private int cartNo = 0;

    @Transient
    private int slotNo = 0;

    @Transient
    private int orderNo = 0;

    @Transient
    private int qtyNo = 0;

    @Transient
    private int ofQty = 0;

    @Transient
    private int stockUOM = 0;

    @Transient
    private int usageUOM = 0;

    @Transient
    private double usageUOMConvert = 0;

    @Transient
    private double usageUOMConvertI = 0;

    @Transient
    private int orderUOM;

    @Transient
    private double uomConvert;

    @Transient
    private double orderProbability;

    @Transient
    private int trimcut = 0;

    @Transient
    private int trimcutImp = 0;

    @Transient
    private boolean used = false;

    @Transient
    private int patternNo = 0;

    @Transient
    private int pieceId = 0;

    @Transient
    private String barcode = "";

    @Transient
    private Date prodStartDate = new Date(System.currentTimeMillis());

    @Transient
    private int numOfLeaves;

    @Transient
    private int leafNo1;

    @Transient
    private int leafNo2;

    @Transient
    private int leafNo3;

    @Transient
    private int leafNo4;

    @Transient
    private String leafNo1_stockCode;

    @Transient
    private String leafNo2_stockCode;

    @Transient
    private String leafNo3_stockCode;

    @Transient
    private String leafNo4_stockCode;

    @Transient
    private String leafNo1_description;

    @Transient
    private String leafNo2_description;

    @Transient
    private String leafNo3_description;

    @Transient
    private String leafNo4_description;

    @Transient
    private boolean leafNo1_madein;

    @Transient
    private boolean leafNo2_madein;

    @Transient
    private boolean leafNo3_madein;

    @Transient
    private boolean leafNo4_madein;

    @Transient
    private Object shapeObject;

    @Transient
    private Object profiles;

    @Transient
    private int pairity = 0;

    @Transient
    private int radius_1_s = 0;

    @Transient
    private int radius_1_i_s = 0;

    @Transient
    private int radius_2_s = 0;

    @Transient
    private int radius_2_i_s = 0;

    @Transient
    private int minLeg = 0;

    @Transient
    private int minLeg_i = 0;

    @Transient
    private double dimA_0 = 0;

    @Transient
    private double dimA_1 = 0;

    @Transient
    private double dimA_2 = 0;

    @Transient
    private double dimA_3 = 0;

    @Transient
    private double dimA_4 = 0;

    @Transient
    private double dimA_5 = 0;

    @Transient
    private double dimB_0 = 0;

    @Transient
    private double dimB_1 = 0;

    @Transient
    private double dimB_2 = 0;

    @Transient
    private double dimB_3 = 0;

    @Transient
    private double dimB_4 = 0;

    @Transient
    private double dimB_5 = 0;

    @Transient
    private double dimC_0 = 0;

    @Transient
    private double dimC_1 = 0;

    @Transient
    private double dimC_2 = 0;

    @Transient
    private double dimC_3 = 0;

    @Transient
    private double dimC_4 = 0;

    @Transient
    private double dimC_5 = 0;

    @Transient
    private double dimD_0 = 0;

    @Transient
    private double dimD_1 = 0;

    @Transient
    private double dimD_2 = 0;

    @Transient
    private double dimD_3 = 0;

    @Transient
    private double dimD_4 = 0;

    @Transient
    private double dimD_5 = 0;

    @Transient
    private double dimA_0_i = 0;

    @Transient
    private double dimA_1_i = 0;

    @Transient
    private double dimA_2_i = 0;

    @Transient
    private double dimA_3_i = 0;

    @Transient
    private double dimA_4_i = 0;

    @Transient
    private double dimA_5_i = 0;

    @Transient
    private double dimB_0_i = 0;

    @Transient
    private double dimB_1_i = 0;

    @Transient
    private double dimB_2_i = 0;

    @Transient
    private double dimB_3_i = 0;

    @Transient
    private double dimB_4_i = 0;

    @Transient
    private double dimB_5_i = 0;

    @Transient
    private double dimC_0_i = 0;

    @Transient
    private double dimC_1_i = 0;

    @Transient
    private double dimC_2_i = 0;

    @Transient
    private double dimC_3_i = 0;

    @Transient
    private double dimC_4_i = 0;

    @Transient
    private double dimC_5_i = 0;

    @Transient
    private double dimD_0_i = 0;

    @Transient
    private double dimD_1_i = 0;

    @Transient
    private double dimD_2_i = 0;

    @Transient
    private double dimD_3_i = 0;

    @Transient
    private double dimD_4_i = 0;

    @Transient
    private double dimD_5_i = 0;

    //*********************************************************************
    // Glass RGB Color
    //*********************************************************************

    @Transient
    private int glass_a = 0;

    @Transient
    private int glass_r = 0;

    @Transient
    private int glass_g = 0;

    @Transient
    private int glass_b = 0;

    // ==================================<METODOS GETTTER AND SETTERS>=================================================

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public int getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(int assemblyId) {
        this.assemblyId = assemblyId;
    }

    public int getBomId() {
        return bomId;
    }

    public void setBomId(int bomId) {
        this.bomId = bomId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public boolean isAddon() {
        return addon;
    }

    public void setAddon(boolean addon) {
        this.addon = addon;
    }

    public int getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(int ruleNo) {
        this.ruleNo = ruleNo;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public int getSegId() {
        return segId;
    }

    public void setSegId(int segId) {
        this.segId = segId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getLeafNo() {
        return leafNo;
    }

    public void setLeafNo(int leafNo) {
        this.leafNo = leafNo;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getCutLength() {
        return cutLength;
    }

    public void setCutLength(int cutLength) {
        this.cutLength = cutLength;
    }

    public int getCutLengthI() {
        return cutLengthI;
    }

    public void setCutLengthI(int cutLengthI) {
        this.cutLengthI = cutLengthI;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidthI() {
        return widthI;
    }

    public void setWidthI(int widthI) {
        this.widthI = widthI;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeightI() {
        return heightI;
    }

    public void setHeightI(int heightI) {
        this.heightI = heightI;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }

    public int getOpeningId() {
        return openingId;
    }

    public void setOpeningId(int openingId) {
        this.openingId = openingId;
    }

    public int getSash() {
        return sash;
    }

    public void setSash(int sash) {
        this.sash = sash;
    }

    public int getRadius1() {
        return radius1;
    }

    public void setRadius1(int radius1) {
        this.radius1 = radius1;
    }

    public int getRadius1I() {
        return radius1I;
    }

    public void setRadius1I(int radius1I) {
        this.radius1I = radius1I;
    }

    public int getRadius2() {
        return radius2;
    }

    public void setRadius2(int radius2) {
        this.radius2 = radius2;
    }

    public int getRadius2I() {
        return radius2I;
    }

    public void setRadius2I(int radius2I) {
        this.radius2I = radius2I;
    }

    public double getLeftAngle() {
        return leftAngle;
    }

    public void setLeftAngle(double leftAngle) {
        this.leftAngle = leftAngle;
    }

    public double getRightAngle() {
        return rightAngle;
    }

    public void setRightAngle(double rightAngle) {
        this.rightAngle = rightAngle;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getParentRow() {
        return parentRow;
    }

    public void setParentRow(int parentRow) {
        this.parentRow = parentRow;
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

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public int getLeadtime() {
        return leadtime;
    }

    public void setLeadtime(int leadtime) {
        this.leadtime = leadtime;
    }

    public boolean isTrack() {
        return track;
    }

    public void setTrack(boolean track) {
        this.track = track;
    }

    public int getParentAssemblyId() {
        return parentAssemblyId;
    }

    public void setParentAssemblyId(int parentAssemblyId) {
        this.parentAssemblyId = parentAssemblyId;
    }

    public int getReqForStage() {
        return reqForStage;
    }

    public void setReqForStage(int reqForStage) {
        this.reqForStage = reqForStage;
    }

    public int getSysAssemblyId() {
        return sysAssemblyId;
    }

    public void setSysAssemblyId(int sysAssemblyId) {
        this.sysAssemblyId = sysAssemblyId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getPriceUser() {
        return priceUser;
    }

    public void setPriceUser(BigDecimal priceUser) {
        this.priceUser = priceUser;
    }

    public BigDecimal getTotalPriceUser() {
        return totalPriceUser;
    }

    public void setTotalPriceUser(BigDecimal totalPriceUser) {
        this.totalPriceUser = totalPriceUser;
    }

    public String getStockcodeUser() {
        return stockcodeUser;
    }

    public void setStockcodeUser(String stockcodeUser) {
        this.stockcodeUser = stockcodeUser;
    }

    public String getDescriptionUser() {
        return descriptionUser;
    }

    public void setDescriptionUser(String descriptionUser) {
        this.descriptionUser = descriptionUser;
    }

    public double getQtyUser() {
        return qtyUser;
    }

    public void setQtyUser(double qtyUser) {
        this.qtyUser = qtyUser;
    }

    public int getCutLengthUser() {
        return cutLengthUser;
    }

    public void setCutLengthUser(int cutLengthUser) {
        this.cutLengthUser = cutLengthUser;
    }

    public int getCutLengthIUser() {
        return cutLengthIUser;
    }

    public void setCutLengthIUser(int cutLengthIUser) {
        this.cutLengthIUser = cutLengthIUser;
    }

    public int getWidthUser() {
        return widthUser;
    }

    public void setWidthUser(int widthUser) {
        this.widthUser = widthUser;
    }

    public int getWidthIUser() {
        return widthIUser;
    }

    public void setWidthIUser(int widthIUser) {
        this.widthIUser = widthIUser;
    }

    public int getHeightUser() {
        return heightUser;
    }

    public void setHeightUser(int heightUser) {
        this.heightUser = heightUser;
    }

    public int getHeightIUser() {
        return heightIUser;
    }

    public void setHeightIUser(int heightIUser) {
        this.heightIUser = heightIUser;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepthI() {
        return depthI;
    }

    public void setDepthI(int depthI) {
        this.depthI = depthI;
    }

    public int getDepthUser() {
        return depthUser;
    }

    public void setDepthUser(int depthUser) {
        this.depthUser = depthUser;
    }

    public int getDepthIUser() {
        return depthIUser;
    }

    public void setDepthIUser(int depthIUser) {
        this.depthIUser = depthIUser;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getAreaI() {
        return areaI;
    }

    public void setAreaI(double areaI) {
        this.areaI = areaI;
    }

    public double getAreaUser() {
        return areaUser;
    }

    public void setAreaUser(double areaUser) {
        this.areaUser = areaUser;
    }

    public double getAreaIUser() {
        return areaIUser;
    }

    public void setAreaIUser(double areaIUser) {
        this.areaIUser = areaIUser;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolumeI() {
        return volumeI;
    }

    public void setVolumeI(double volumeI) {
        this.volumeI = volumeI;
    }

    public double getVolumeUser() {
        return volumeUser;
    }

    public void setVolumeUser(double volumeUser) {
        this.volumeUser = volumeUser;
    }

    public double getVolumeIUser() {
        return volumeIUser;
    }

    public void setVolumeIUser(double volumeIUser) {
        this.volumeIUser = volumeIUser;
    }

    public double getLengthw2() {
        return lengthw2;
    }

    public void setLengthw2(double lengthw2) {
        this.lengthw2 = lengthw2;
    }

    public double getLengthh2() {
        return lengthh2;
    }

    public void setLengthh2(double lengthh2) {
        this.lengthh2 = lengthh2;
    }

    public double getLengthf12() {
        return lengthf12;
    }

    public void setLengthf12(double lengthf12) {
        this.lengthf12 = lengthf12;
    }

    public double getLengthf22() {
        return lengthf22;
    }

    public void setLengthf22(double lengthf22) {
        this.lengthf22 = lengthf22;
    }

    public int getWeld() {
        return weld;
    }

    public void setWeld(int weld) {
        this.weld = weld;
    }

    public int getWeldI() {
        return weldI;
    }

    public void setWeldI(int weldI) {
        this.weldI = weldI;
    }

    public int getWeldR() {
        return weldR;
    }

    public void setWeldR(int weldR) {
        this.weldR = weldR;
    }

    public int getWeldRI() {
        return weldRI;
    }

    public void setWeldRI(int weldRI) {
        this.weldRI = weldRI;
    }

    public int getLeftCut() {
        return leftCut;
    }

    public void setLeftCut(int leftCut) {
        this.leftCut = leftCut;
    }

    public int getRightCut() {
        return rightCut;
    }

    public void setRightCut(int rightCut) {
        this.rightCut = rightCut;
    }

    public boolean isWildSize() {
        return isWildSize;
    }

    public void setWildSize(boolean wildSize) {
        isWildSize = wildSize;
    }

    public boolean isWildDepth() {
        return isWildDepth;
    }

    public void setWildDepth(boolean wildDepth) {
        isWildDepth = wildDepth;
    }

    public boolean isWildColor() {
        return isWildColor;
    }

    public void setWildColor(boolean wildColor) {
        isWildColor = wildColor;
    }

    public int getParentRule() {
        return parentRule;
    }

    public void setParentRule(int parentRule) {
        this.parentRule = parentRule;
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

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public boolean isAssemblyBom() {
        return assemblyBom;
    }

    public void setAssemblyBom(boolean assemblyBom) {
        this.assemblyBom = assemblyBom;
    }

    public boolean isShips() {
        return ships;
    }

    public void setShips(boolean ships) {
        this.ships = ships;
    }

    public String getNotchesM() {
        return notchesM;
    }

    public void setNotchesM(String notchesM) {
        this.notchesM = notchesM;
    }

    public String getNotchesI() {
        return notchesI;
    }

    public void setNotchesI(String notchesI) {
        this.notchesI = notchesI;
    }

    public String getNotchesIY() {
        return notchesIY;
    }

    public void setNotchesIY(String notchesIY) {
        this.notchesIY = notchesIY;
    }

    public int getShapeId() {
        return shapeId;
    }

    public void setShapeId(int shapeId) {
        this.shapeId = shapeId;
    }

    public int getParentBomId() {
        return parentBomId;
    }

    public void setParentBomId(int parentBomId) {
        this.parentBomId = parentBomId;
    }

    public int getGlassBomId() {
        return glassBomId;
    }

    public void setGlassBomId(int glassBomId) {
        this.glassBomId = glassBomId;
    }

    public int getProcessLT() {
        return processLT;
    }

    public void setProcessLT(int processLT) {
        this.processLT = processLT;
    }

    public String getMasterStockCode() {
        return masterStockCode;
    }

    public void setMasterStockCode(String masterStockCode) {
        this.masterStockCode = masterStockCode;
    }

    public int getSupplierRuleNo() {
        return supplierRuleNo;
    }

    public void setSupplierRuleNo(int supplierRuleNo) {
        this.supplierRuleNo = supplierRuleNo;
    }

    public int getSupplierPartId() {
        return supplierPartId;
    }

    public void setSupplierPartId(int supplierPartId) {
        this.supplierPartId = supplierPartId;
    }

    public boolean isGlass_made_in() {
        return glass_made_in;
    }

    public void setGlass_made_in(boolean glass_made_in) {
        this.glass_made_in = glass_made_in;
    }

    public boolean isBought_glazed() {
        return bought_glazed;
    }

    public void setBought_glazed(boolean bought_glazed) {
        this.bought_glazed = bought_glazed;
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

    public byte[] getJob_item_model() {
        return job_item_model;
    }

    public void setJob_item_model(byte[] job_item_model) {
        this.job_item_model = job_item_model;
    }

    public double getDimA_0() {
        return dimA_0;
    }

    public void setDimA_0(double dimA_0) {
        this.dimA_0 = dimA_0;
    }

    public double getDimA_1() {
        return dimA_1;
    }

    public void setDimA_1(double dimA_1) {
        this.dimA_1 = dimA_1;
    }

    public double getDimA_2() {
        return dimA_2;
    }

    public void setDimA_2(double dimA_2) {
        this.dimA_2 = dimA_2;
    }

    public double getDimA_3() {
        return dimA_3;
    }

    public void setDimA_3(double dimA_3) {
        this.dimA_3 = dimA_3;
    }

    public double getDimA_4() {
        return dimA_4;
    }

    public void setDimA_4(double dimA_4) {
        this.dimA_4 = dimA_4;
    }

    public double getDimA_5() {
        return dimA_5;
    }

    public void setDimA_5(double dimA_5) {
        this.dimA_5 = dimA_5;
    }

    public double getDimB_0() {
        return dimB_0;
    }

    public void setDimB_0(double dimB_0) {
        this.dimB_0 = dimB_0;
    }

    public double getDimB_1() {
        return dimB_1;
    }

    public void setDimB_1(double dimB_1) {
        this.dimB_1 = dimB_1;
    }

    public double getDimB_2() {
        return dimB_2;
    }

    public void setDimB_2(double dimB_2) {
        this.dimB_2 = dimB_2;
    }

    public double getDimB_3() {
        return dimB_3;
    }

    public void setDimB_3(double dimB_3) {
        this.dimB_3 = dimB_3;
    }

    public double getDimB_4() {
        return dimB_4;
    }

    public void setDimB_4(double dimB_4) {
        this.dimB_4 = dimB_4;
    }

    public double getDimB_5() {
        return dimB_5;
    }

    public void setDimB_5(double dimB_5) {
        this.dimB_5 = dimB_5;
    }

    public double getDimC_0() {
        return dimC_0;
    }

    public void setDimC_0(double dimC_0) {
        this.dimC_0 = dimC_0;
    }

    public double getDimC_1() {
        return dimC_1;
    }

    public void setDimC_1(double dimC_1) {
        this.dimC_1 = dimC_1;
    }

    public double getDimC_2() {
        return dimC_2;
    }

    public void setDimC_2(double dimC_2) {
        this.dimC_2 = dimC_2;
    }

    public double getDimC_3() {
        return dimC_3;
    }

    public void setDimC_3(double dimC_3) {
        this.dimC_3 = dimC_3;
    }

    public double getDimC_4() {
        return dimC_4;
    }

    public void setDimC_4(double dimC_4) {
        this.dimC_4 = dimC_4;
    }

    public double getDimC_5() {
        return dimC_5;
    }

    public void setDimC_5(double dimC_5) {
        this.dimC_5 = dimC_5;
    }

    public BillOfMaterialEntityObject getParentBom() {
        return parentBom;
    }

    public void setParentBom(BillOfMaterialEntityObject parentBom) {
        this.parentBom = parentBom;
    }

    public AssemblyEntityObject getAssembly() {
        return assembly;
    }

    public void setAssembly(AssemblyEntityObject assembly) {
        this.assembly = assembly;
    }

    public DesignGlassEntityObject getDesignGlass() {
        return designGlass;
    }

    public void setDesignGlass(DesignGlassEntityObject designGlass) {
        this.designGlass = designGlass;
    }

    public ConstructionMap getConstructionMap() {
        return constructionMap;
    }

    public void setConstructionMap(ConstructionMap constructionMap) {
        this.constructionMap = constructionMap;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getSubBatchId() {
        return subBatchId;
    }

    public void setSubBatchId(int subBatchId) {
        this.subBatchId = subBatchId;
    }

    public int getCartNo() {
        return cartNo;
    }

    public void setCartNo(int cartNo) {
        this.cartNo = cartNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public int getStockUOM() {
        return stockUOM;
    }

    public void setStockUOM(int stockUOM) {
        this.stockUOM = stockUOM;
    }

    public int getUsageUOM() {
        return usageUOM;
    }

    public void setUsageUOM(int usageUOM) {
        this.usageUOM = usageUOM;
    }

    public double getUsageUOMConvert() {
        return usageUOMConvert;
    }

    public void setUsageUOMConvert(double usageUOMConvert) {
        this.usageUOMConvert = usageUOMConvert;
    }

    public double getUsageUOMConvertI() {
        return usageUOMConvertI;
    }

    public void setUsageUOMConvertI(double usageUOMConvertI) {
        this.usageUOMConvertI = usageUOMConvertI;
    }

    public int getTrimcut() {
        return trimcut;
    }

    public void setTrimcut(int trimcut) {
        this.trimcut = trimcut;
    }

    public int getTrimcutImp() {
        return trimcutImp;
    }

    public void setTrimcutImp(int trimcutImp) {
        this.trimcutImp = trimcutImp;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getPatternNo() {
        return patternNo;
    }

    public void setPatternNo(int patternNo) {
        this.patternNo = patternNo;
    }

    public int getPieceId() {
        return pieceId;
    }

    public void setPieceId(int pieceId) {
        this.pieceId = pieceId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getProdStartDate() {
        return prodStartDate;
    }

    public void setProdStartDate(Date prodStartDate) {
        this.prodStartDate = prodStartDate;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getQtyNo() {
        return qtyNo;
    }

    public void setQtyNo(int qtyNo) {
        this.qtyNo = qtyNo;
    }

    public int getOfQty() {
        return ofQty;
    }

    public void setOfQty(int ofQty) {
        this.ofQty = ofQty;
    }

    public int getOrderUOM() {
        return orderUOM;
    }

    public void setOrderUOM(int orderUOM) {
        this.orderUOM = orderUOM;
    }

    public double getUomConvert() {
        return uomConvert;
    }

    public void setUomConvert(double uomConvert) {
        this.uomConvert = uomConvert;
    }

    public double getOrderProbability() {
        return orderProbability;
    }

    public void setOrderProbability(double orderProbability) {
        this.orderProbability = orderProbability;
    }

    public Object getShapeObject() {
        return shapeObject;
    }

    public void setShapeObject(Object shapeObject) {
        this.shapeObject = shapeObject;
    }

    public Object getProfiles() {
        return profiles;
    }

    public void setProfiles(Object profiles) {
        this.profiles = profiles;
    }

    public int getNumOfLeaves() {
        return numOfLeaves;
    }

    public void setNumOfLeaves(int numOfLeaves) {
        this.numOfLeaves = numOfLeaves;
    }

    public int getLeafNo1() {
        return leafNo1;
    }

    public void setLeafNo1(int leafNo1) {
        this.leafNo1 = leafNo1;
    }

    public int getLeafNo2() {
        return leafNo2;
    }

    public void setLeafNo2(int leafNo2) {
        this.leafNo2 = leafNo2;
    }

    public int getLeafNo3() {
        return leafNo3;
    }

    public void setLeafNo3(int leafNo3) {
        this.leafNo3 = leafNo3;
    }

    public int getLeafNo4() {
        return leafNo4;
    }

    public void setLeafNo4(int leafNo4) {
        this.leafNo4 = leafNo4;
    }

    public String getLeafNo1_stockCode() {
        return leafNo1_stockCode;
    }

    public void setLeafNo1_stockCode(String leafNo1_stockCode) {
        this.leafNo1_stockCode = leafNo1_stockCode;
    }

    public String getLeafNo2_stockCode() {
        return leafNo2_stockCode;
    }

    public void setLeafNo2_stockCode(String leafNo2_stockCode) {
        this.leafNo2_stockCode = leafNo2_stockCode;
    }

    public String getLeafNo3_stockCode() {
        return leafNo3_stockCode;
    }

    public void setLeafNo3_stockCode(String leafNo3_stockCode) {
        this.leafNo3_stockCode = leafNo3_stockCode;
    }

    public String getLeafNo4_stockCode() {
        return leafNo4_stockCode;
    }

    public void setLeafNo4_stockCode(String leafNo4_stockCode) {
        this.leafNo4_stockCode = leafNo4_stockCode;
    }

    public String getLeafNo1_description() {
        return leafNo1_description;
    }

    public void setLeafNo1_description(String leafNo1_description) {
        this.leafNo1_description = leafNo1_description;
    }

    public String getLeafNo2_description() {
        return leafNo2_description;
    }

    public void setLeafNo2_description(String leafNo2_description) {
        this.leafNo2_description = leafNo2_description;
    }

    public String getLeafNo3_description() {
        return leafNo3_description;
    }

    public void setLeafNo3_description(String leafNo3_description) {
        this.leafNo3_description = leafNo3_description;
    }

    public String getLeafNo4_description() {
        return leafNo4_description;
    }

    public void setLeafNo4_description(String leafNo4_description) {
        this.leafNo4_description = leafNo4_description;
    }

    public boolean isLeafNo1_madein() {
        return leafNo1_madein;
    }

    public void setLeafNo1_madein(boolean leafNo1_madein) {
        this.leafNo1_madein = leafNo1_madein;
    }

    public boolean isLeafNo2_madein() {
        return leafNo2_madein;
    }

    public void setLeafNo2_madein(boolean leafNo2_madein) {
        this.leafNo2_madein = leafNo2_madein;
    }

    public boolean isLeafNo3_madein() {
        return leafNo3_madein;
    }

    public void setLeafNo3_madein(boolean leafNo3_madein) {
        this.leafNo3_madein = leafNo3_madein;
    }

    public boolean isLeafNo4_madein() {
        return leafNo4_madein;
    }

    public void setLeafNo4_madein(boolean leafNo4_madein) {
        this.leafNo4_madein = leafNo4_madein;
    }

    public int getRadius_1_s() {
        return radius_1_s;
    }

    public void setRadius_1_s(int radius_1_s) {
        this.radius_1_s = radius_1_s;
    }

    public int getRadius_1_i_s() {
        return radius_1_i_s;
    }

    public void setRadius_1_i_s(int radius_1_i_s) {
        this.radius_1_i_s = radius_1_i_s;
    }

    public int getRadius_2_s() {
        return radius_2_s;
    }

    public void setRadius_2_s(int radius_2_s) {
        this.radius_2_s = radius_2_s;
    }

    public int getRadius_2_i_s() {
        return radius_2_i_s;
    }

    public void setRadius_2_i_s(int radius_2_i_s) {
        this.radius_2_i_s = radius_2_i_s;
    }

    public int getMinLeg() {
        return minLeg;
    }

    public void setMinLeg(int minLeg) {
        this.minLeg = minLeg;
    }

    public int getMinLeg_i() {
        return minLeg_i;
    }

    public void setMinLeg_i(int minLeg_i) {
        this.minLeg_i = minLeg_i;
    }

    public double getDimD_0() {
        return dimD_0;
    }

    public void setDimD_0(double dimD_0) {
        this.dimD_0 = dimD_0;
    }

    public double getDimD_1() {
        return dimD_1;
    }

    public void setDimD_1(double dimD_1) {
        this.dimD_1 = dimD_1;
    }

    public double getDimD_2() {
        return dimD_2;
    }

    public void setDimD_2(double dimD_2) {
        this.dimD_2 = dimD_2;
    }

    public double getDimD_3() {
        return dimD_3;
    }

    public void setDimD_3(double dimD_3) {
        this.dimD_3 = dimD_3;
    }

    public double getDimD_4() {
        return dimD_4;
    }

    public void setDimD_4(double dimD_4) {
        this.dimD_4 = dimD_4;
    }

    public double getDimD_5() {
        return dimD_5;
    }

    public void setDimD_5(double dimD_5) {
        this.dimD_5 = dimD_5;
    }

    public double getDimA_0_i() {
        return dimA_0_i;
    }

    public void setDimA_0_i(double dimA_0_i) {
        this.dimA_0_i = dimA_0_i;
    }

    public double getDimA_1_i() {
        return dimA_1_i;
    }

    public void setDimA_1_i(double dimA_1_i) {
        this.dimA_1_i = dimA_1_i;
    }

    public double getDimA_2_i() {
        return dimA_2_i;
    }

    public void setDimA_2_i(double dimA_2_i) {
        this.dimA_2_i = dimA_2_i;
    }

    public double getDimA_3_i() {
        return dimA_3_i;
    }

    public void setDimA_3_i(double dimA_3_i) {
        this.dimA_3_i = dimA_3_i;
    }

    public double getDimA_4_i() {
        return dimA_4_i;
    }

    public void setDimA_4_i(double dimA_4_i) {
        this.dimA_4_i = dimA_4_i;
    }

    public double getDimA_5_i() {
        return dimA_5_i;
    }

    public void setDimA_5_i(double dimA_5_i) {
        this.dimA_5_i = dimA_5_i;
    }

    public double getDimB_0_i() {
        return dimB_0_i;
    }

    public void setDimB_0_i(double dimB_0_i) {
        this.dimB_0_i = dimB_0_i;
    }

    public double getDimB_1_i() {
        return dimB_1_i;
    }

    public void setDimB_1_i(double dimB_1_i) {
        this.dimB_1_i = dimB_1_i;
    }

    public double getDimB_2_i() {
        return dimB_2_i;
    }

    public void setDimB_2_i(double dimB_2_i) {
        this.dimB_2_i = dimB_2_i;
    }

    public double getDimB_3_i() {
        return dimB_3_i;
    }

    public void setDimB_3_i(double dimB_3_i) {
        this.dimB_3_i = dimB_3_i;
    }

    public double getDimB_4_i() {
        return dimB_4_i;
    }

    public void setDimB_4_i(double dimB_4_i) {
        this.dimB_4_i = dimB_4_i;
    }

    public double getDimB_5_i() {
        return dimB_5_i;
    }

    public void setDimB_5_i(double dimB_5_i) {
        this.dimB_5_i = dimB_5_i;
    }

    public double getDimC_0_i() {
        return dimC_0_i;
    }

    public void setDimC_0_i(double dimC_0_i) {
        this.dimC_0_i = dimC_0_i;
    }

    public double getDimC_1_i() {
        return dimC_1_i;
    }

    public void setDimC_1_i(double dimC_1_i) {
        this.dimC_1_i = dimC_1_i;
    }

    public double getDimC_2_i() {
        return dimC_2_i;
    }

    public void setDimC_2_i(double dimC_2_i) {
        this.dimC_2_i = dimC_2_i;
    }

    public double getDimC_3_i() {
        return dimC_3_i;
    }

    public void setDimC_3_i(double dimC_3_i) {
        this.dimC_3_i = dimC_3_i;
    }

    public double getDimC_4_i() {
        return dimC_4_i;
    }

    public void setDimC_4_i(double dimC_4_i) {
        this.dimC_4_i = dimC_4_i;
    }

    public double getDimC_5_i() {
        return dimC_5_i;
    }

    public void setDimC_5_i(double dimC_5_i) {
        this.dimC_5_i = dimC_5_i;
    }

    public double getDimD_0_i() {
        return dimD_0_i;
    }

    public void setDimD_0_i(double dimD_0_i) {
        this.dimD_0_i = dimD_0_i;
    }

    public double getDimD_1_i() {
        return dimD_1_i;
    }

    public void setDimD_1_i(double dimD_1_i) {
        this.dimD_1_i = dimD_1_i;
    }

    public double getDimD_2_i() {
        return dimD_2_i;
    }

    public void setDimD_2_i(double dimD_2_i) {
        this.dimD_2_i = dimD_2_i;
    }

    public double getDimD_3_i() {
        return dimD_3_i;
    }

    public void setDimD_3_i(double dimD_3_i) {
        this.dimD_3_i = dimD_3_i;
    }

    public double getDimD_4_i() {
        return dimD_4_i;
    }

    public void setDimD_4_i(double dimD_4_i) {
        this.dimD_4_i = dimD_4_i;
    }

    public double getDimD_5_i() {
        return dimD_5_i;
    }

    public void setDimD_5_i(double dimD_5_i) {
        this.dimD_5_i = dimD_5_i;
    }

    public int getPairity() {
        return pairity;
    }

    public void setPairity(int pairity) {
        this.pairity = pairity;
    }

    public int getGlass_a() {
        return glass_a;
    }

    public void setGlass_a(int glass_a) {
        this.glass_a = glass_a;
    }

    public int getGlass_r() {
        return glass_r;
    }

    public void setGlass_r(int glass_r) {
        this.glass_r = glass_r;
    }

    public int getGlass_g() {
        return glass_g;
    }

    public void setGlass_g(int glass_g) {
        this.glass_g = glass_g;
    }

    public int getGlass_b() {
        return glass_b;
    }

    public void setGlass_b(int glass_b) {
        this.glass_b = glass_b;
    }

    //***************************************************************************
    @Override
    public BillOfMaterialEntityObject clone() {
        try {
            BillOfMaterialEntityObject object = (BillOfMaterialEntityObject)super.clone();
            return object;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return null;
    }
}

package openjanela.model.entities.design;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-29-13
 *          Time: 01:00 PM
 */
@Entity
@Table(name = "design_confirm_assemblies")
public class ConfirmAssemblyEntityObject implements Serializable {

    //Serializable version
    private static final long serialVersionUID = 9215275878884992873L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order_id", nullable = false)
    private Integer orderId = 0;

    @Column(name = "item_no", nullable = false)
    private Integer itemNo = 0;

    @Column(name = "version_no", nullable = false)
    private Integer versionNo = 0;

    @Column(name = "assembly_id", nullable = false)
    private int assemblyId = 0;

    @Column(name = "qty_no", nullable = false)
    private int qtyNo = 0;

    @Column(name = "of_qty", nullable = false)
    private int ofQty = 0;

    @Column(name = "row", nullable = false)
    private int row = 0;

    @Column(name = "col", nullable = false)
    private int col = 0;

    @Column(name = "barcode", nullable = false)
    private String barCode = "";

    @Column(name = "stage", nullable = false)
    private int stage = 0;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "place_po", nullable = true)
    private Date placePO = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prod_start", nullable = true)
    private Date prodStart = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prod_end", nullable = true)
    private Date prodEnd = new Date();

    @Column(name = "batched", nullable = false)
    private int batched = 0;

    @Column(name = "sub_batched", nullable = false)
    private int subBatched = 0;

    @Column(name = "shift", nullable = false)
    private int shift = 0;

    @Column(name = "item_bc_id", nullable = true)
    private String itemBarcode = null;

    @Column(name = "slot_no", nullable = false)
    private int slotNumber = 0;

    @Column(name = "cart_no", nullable = false)
    private int cartNumber = 0;

    @Column(name = "assembly_shipped_id", nullable = false)
    private int assemblyShippedId = 0;

    @Column(name = "reject_code_id", nullable = false)
    private int rejectCodeId = 0;

    @Column(name = "rush", nullable = false)
    private boolean rush = false;

    @Column(name = "is_repair", nullable = false)
    private boolean repair = false;

    @Column(name = "shape", nullable = true)
    @Basic(fetch = FetchType.LAZY)
    private byte[] shape;

    @Column(name = "options", nullable = true)
    @Basic(fetch = FetchType.LAZY)
    private byte[] options;

    @Column(name = "image", nullable = true)
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bom_id", referencedColumnName = "id")
    private BillOfMaterialEntityObject bom;

    //*********************************************************
    //Transient temporal values
    //*********************************************************

    @Transient
    private int ruleNo = 0;

    @Transient
    private int batchId = 0;

    @Transient
    private int jobItemId = 0;

    @Transient
    private int bomId = 0;

    @Transient
    private int glassBomId = 0;

    @Transient
    private int parentBomId = 0;

    @Transient
    private int assemblyLevelId = 0;

    @Transient
    private String stockCodeParts = "";

    @Transient
    private String descriptionParts = "";

    @Transient
    private int prodLine = 0;

    @Transient
    private int station = 0;

    @Transient
    private int orderNo = 0;

    @Transient
    private int partId = 0;

    @Transient
    private String prodLineDesc = "";

    @Transient
    private String stationDesc = "";

    @Transient
    private Date stationUsageSchedule = new Date();

    @Transient
    private int usedCapacity = 0;

    @Transient
    private boolean finalized = false;

    @Transient
    private boolean released = false;

    @Transient
    private boolean inProduction = false;

    @Transient
    private int leafNo = 0;

    @Transient
    private double width = 0;

    @Transient
    private double height = 0;

    @Transient
    private double width_i = 0;

    @Transient
    private double height_i = 0;

    @Transient
    private double cut_length = 0;

    @Transient
    private double cut_length_i = 0;

    @Transient
    private String notches;

    @Transient
    private String notches_i;

    @Transient
    private String notches_i_y;

    @Transient
    private double area = 0;

    @Transient
    private double area_i = 0;

    @Transient
    private double depth = 0;

    @Transient
    private double depth_i = 0;

    public ConfirmAssemblyEntityObject() {
    }

    public ConfirmAssemblyEntityObject(Integer orderId, Integer itemNo, Integer versionNo, int assemblyId, int qtyNo,
                                       int ofQty, int row, int col, String barCode, int stage, Date placePO, Date prodStart,
                                       Date prodEnd, int batched, int subBatched, int shift, String itemBarcode, int slotNumber,
                                       int cartNumber, int assemblyShippedId, int rejectCodeId, boolean rush, boolean repair,
                                       byte[] shape, byte[] options, byte[] image, BillOfMaterialEntityObject bom) {
        this.orderId = orderId;
        this.itemNo = itemNo;
        this.versionNo = versionNo;
        this.assemblyId = assemblyId;
        this.qtyNo = qtyNo;
        this.ofQty = ofQty;
        this.row = row;
        this.col = col;
        this.barCode = barCode;
        this.stage = stage;
        this.placePO = placePO;
        this.prodStart = prodStart;
        this.prodEnd = prodEnd;
        this.batched = batched;
        this.subBatched = subBatched;
        this.shift = shift;
        this.itemBarcode = itemBarcode;
        this.slotNumber = slotNumber;
        this.cartNumber = cartNumber;
        this.assemblyShippedId = assemblyShippedId;
        this.rejectCodeId = rejectCodeId;
        this.rush = rush;
        this.repair = repair;
        this.shape = shape;
        this.options = options;
        this.image = image;
        this.bom = bom;
    }

    // ========================================<GETTTER AND SETTERS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    public int getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(int assemblyId) {
        this.assemblyId = assemblyId;
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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public Date getPlacePO() {
        return placePO;
    }

    public void setPlacePO(Date placePO) {
        this.placePO = placePO;
    }

    public Date getProdStart() {
        return prodStart;
    }

    public void setProdStart(Date prodStart) {
        this.prodStart = prodStart;
    }

    public Date getProdEnd() {
        return prodEnd;
    }

    public void setProdEnd(Date prodEnd) {
        this.prodEnd = prodEnd;
    }

    public int getBatched() {
        return batched;
    }

    public void setBatched(int batched) {
        this.batched = batched;
    }

    public int getSubBatched() {
        return subBatched;
    }

    public void setSubBatched(int subBatched) {
        this.subBatched = subBatched;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    public int getAssemblyShippedId() {
        return assemblyShippedId;
    }

    public void setAssemblyShippedId(int assemblyShippedId) {
        this.assemblyShippedId = assemblyShippedId;
    }

    public int getRejectCodeId() {
        return rejectCodeId;
    }

    public void setRejectCodeId(int rejectCodeId) {
        this.rejectCodeId = rejectCodeId;
    }

    public boolean isRush() {
        return rush;
    }

    public boolean isRepair() {
        return repair;
    }

    public void setRepair(boolean repair) {
        this.repair = repair;
    }

    public void setRush(boolean rush) {
        this.rush = rush;
    }

    public byte[] getShape() {
        return shape;
    }

    public void setShape(byte[] shape) {
        this.shape = shape;
    }

    public byte[] getOptions() {
        return options;
    }

    public void setOptions(byte[] options) {
        this.options = options;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public BillOfMaterialEntityObject getBom() {
        return bom;
    }

    public void setBom(BillOfMaterialEntityObject bom) {
        this.bom = bom;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getJobItemId() {
        return jobItemId;
    }

    public void setJobItemId(int jobItemId) {
        this.jobItemId = jobItemId;
    }

    public int getBomId() {
        return bomId;
    }

    public void setBomId(int bomId) {
        this.bomId = bomId;
    }

    public int getGlassBomId() {
        return glassBomId;
    }

    public void setGlassBomId(int glassBomId) {
        this.glassBomId = glassBomId;
    }

    public int getParentBomId() {
        return parentBomId;
    }

    public void setParentBomId(int parentBomId) {
        this.parentBomId = parentBomId;
    }

    public int getAssemblyLevelId() {
        return assemblyLevelId;
    }

    public void setAssemblyLevelId(int assemblyLevelId) {
        this.assemblyLevelId = assemblyLevelId;
    }

    public String getStockCodeParts() {
        return stockCodeParts;
    }

    public void setStockCodeParts(String stockCodeParts) {
        this.stockCodeParts = stockCodeParts;
    }

    public String getDescriptionParts() {
        return descriptionParts;
    }

    public void setDescriptionParts(String descriptionParts) {
        this.descriptionParts = descriptionParts;
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

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public String getProdLineDesc() {
        return prodLineDesc;
    }

    public void setProdLineDesc(String prodLineDesc) {
        this.prodLineDesc = prodLineDesc;
    }

    public String getStationDesc() {
        return stationDesc;
    }

    public void setStationDesc(String stationDesc) {
        this.stationDesc = stationDesc;
    }

    public Date getStationUsageSchedule() {
        return stationUsageSchedule;
    }

    public void setStationUsageSchedule(Date stationUsageSchedule) {
        this.stationUsageSchedule = stationUsageSchedule;
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public void setUsedCapacity(int usedCapacity) {
        this.usedCapacity = usedCapacity;
    }

    public boolean isFinalized() {
        return finalized;
    }

    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }

    public boolean isReleased() {
        return released;
    }

    public void setReleased(boolean released) {
        this.released = released;
    }

    public boolean isInProduction() {
        return inProduction;
    }

    public void setInProduction(boolean inProduction) {
        this.inProduction = inProduction;
    }

    public int getLeafNo() {
        return leafNo;
    }

    public void setLeafNo(int leafNo) {
        this.leafNo = leafNo;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(int ruleNo) {
        this.ruleNo = ruleNo;
    }

    public double getWidth_i() {
        return width_i;
    }

    public void setWidth_i(double width_i) {
        this.width_i = width_i;
    }

    public double getHeight_i() {
        return height_i;
    }

    public void setHeight_i(double height_i) {
        this.height_i = height_i;
    }

    public double getCut_length() {
        return cut_length;
    }

    public void setCut_length(double cut_length) {
        this.cut_length = cut_length;
    }

    public double getCut_length_i() {
        return cut_length_i;
    }

    public void setCut_length_i(double cut_length_i) {
        this.cut_length_i = cut_length_i;
    }

    public String getNotches() {
        return notches;
    }

    public void setNotches(String notches) {
        this.notches = notches;
    }

    public String getNotches_i() {
        return notches_i;
    }

    public void setNotches_i(String notches_i) {
        this.notches_i = notches_i;
    }

    public String getNotches_i_y() {
        return notches_i_y;
    }

    public void setNotches_i_y(String notches_i_y) {
        this.notches_i_y = notches_i_y;
    }

    public double getArea_i() {
        return area_i;
    }

    public void setArea_i(double area_i) {
        this.area_i = area_i;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getDepth_i() {
        return depth_i;
    }

    public void setDepth_i(double depth_i) {
        this.depth_i = depth_i;
    }
}

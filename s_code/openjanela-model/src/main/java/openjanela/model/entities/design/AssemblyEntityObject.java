package openjanela.model.entities.design;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 02-26-13
 *          Time: 04:21 PM
 */
@Entity
@Table(name = "design_assemblies")
public class AssemblyEntityObject implements Serializable {

    //Serializable version
    private static final long serialVersionUID = 3097313002035369896L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order_id", nullable = false)
    private Integer orderId = 0;

    @Column(name = "item_no", nullable = false)
    private Integer itemNo = 0;

    @Column(name = "version_no", nullable = false)
    private Integer versionId = 0;

    @Column(name = "assembly_id", nullable = false)
    private int assemblyId = 0;

    @Column(name = "qty", nullable = false)
    private int qty = 0;

    @Column(name = "row", nullable = false)
    private int row = 0;

    @Column(name = "col", nullable = false)
    private int col = 0;

    @Column(name = "stage", nullable = false)
    private int stage = 0;

    @Column(name = "shift", nullable = false)
    private int shift = 0;

    @Column(name = "shape", nullable = true)
    private byte[] shape;

    @Column(name = "options", nullable = true)
    private byte[] options;

    @Column(name = "image", nullable = true)
    private byte[] image;

    @Column(name = "is_confirmed", nullable = false)
    private boolean confirmed = false;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bom_id", referencedColumnName = "id")
    private BillOfMaterialEntityObject bom;

    @Transient
    private int bomId;

    @Transient
    private int itemQty;

    @Transient
    private String stockCodeParts;

    @Transient
    private String descriptionParts;

    @Transient
    private int prodLine;

    @Transient
    private int station;

    @Transient
    private int glassBomId;

    @Transient
    private int ruleNo;

    @Transient
    private double cut_length;

    @Transient
    private double cut_length_i;

    @Transient
    private double depth;

    @Transient
    private double depth_i;

    @Transient
    private double area;

    @Transient
    private double area_i;

    @Transient
    private double width;

    @Transient
    private double width_i;

    @Transient
    private double height;

    @Transient
    private double height_i;

    @Transient
    private String notches;

    @Transient
    private String notches_i;

    @Transient
    private String notches_i_y;

    public AssemblyEntityObject() {
    }

    public AssemblyEntityObject(Integer orderId, Integer itemNo, Integer versionId, int assemblyId, int qty, int row,
                                int col, int stage, int shift, byte[] shape, byte[] options, byte[] image, boolean confirmed,
                                BillOfMaterialEntityObject bom) {
        this.orderId = orderId;
        this.itemNo = itemNo;
        this.versionId = versionId;
        this.assemblyId = assemblyId;
        this.qty = qty;
        this.row = row;
        this.col = col;
        this.stage = stage;
        this.shift = shift;
        this.shape = shape;
        this.options = options;
        this.image = image;
        this.confirmed = confirmed;
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

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public int getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(int assemblyId) {
        this.assemblyId = assemblyId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
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

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public BillOfMaterialEntityObject getBom() {
        return bom;
    }

    public void setBom(BillOfMaterialEntityObject bom) {
        this.bom = bom;
    }

    public int getBomId() {
        return bomId;
    }

    public void setBomId(int bomId) {
        this.bomId = bomId;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
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

    public int getGlassBomId() {
        return glassBomId;
    }

    public void setGlassBomId(int glassBomId) {
        this.glassBomId = glassBomId;
    }

    public int getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(int ruleNo) {
        this.ruleNo = ruleNo;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getArea_i() {
        return area_i;
    }

    public void setArea_i(double area_i) {
        this.area_i = area_i;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth_i() {
        return width_i;
    }

    public void setWidth_i(double width_i) {
        this.width_i = width_i;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight_i() {
        return height_i;
    }

    public void setHeight_i(double height_i) {
        this.height_i = height_i;
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
}

package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2012, OpenJanela. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 11-13-12
 *          Time: 11:43 PM
 */
@Entity
@Table(name = "production_line")
public class ProductionLine implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "virtual", nullable = false)
    private boolean virtual;

    @Column(name = "parent")
    private Integer parent;

    @Column(name = "cartsize", nullable = false)
    private int cartSize;

    @Column(name = "level")
    private Boolean level;

    @Column(name = "shift1")
    private Boolean shift_1;

    @Column(name = "shift2")
    private Boolean shift_2;

    @Column(name = "shift3")
    private Boolean shift_3;

    @Column(name = "buildingno")
    private Integer buildingNo;

    @Column(name = "warehouseid", nullable = false)
    private Integer warehouseId;

    @Column(name = "shipBuilding")
    private Integer shipBuilding;

    @Column(name = "transferlt")
    private Double transferlt;

    @Column(name = "isglassline")
    private Boolean glassLine;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "assign_own_cart_slot")
    private boolean assignOwnCartSlot = true;

    @Transient
    private Integer shift;

    @Transient
    private double capacityPercent;

    @Transient
    private int supplierId;

    @Transient
    private boolean remote;

    // ==================================<GETTTER AND SETTERS>=================================================

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

    public boolean isVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public int getCartSize() {
        return cartSize;
    }

    public void setCartSize(int cartSize) {
        this.cartSize = cartSize;
    }

    public Boolean getLevel() {
        return level;
    }

    public void setLevel(Boolean level) {
        this.level = level;
    }

    public Boolean getShift_1() {
        return shift_1;
    }

    public void setShift_1(Boolean shift_1) {
        this.shift_1 = shift_1;
    }

    public Boolean getShift_2() {
        return shift_2;
    }

    public void setShift_2(Boolean shift_2) {
        this.shift_2 = shift_2;
    }

    public Boolean getShift_3() {
        return shift_3;
    }

    public void setShift_3(Boolean shift_3) {
        this.shift_3 = shift_3;
    }

    public Integer getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getShipBuilding() {
        return shipBuilding;
    }

    public void setShipBuilding(Integer shipBuilding) {
        this.shipBuilding = shipBuilding;
    }

    public Double getTransferlt() {
        return transferlt;
    }

    public void setTransferlt(Double transferlt) {
        this.transferlt = transferlt;
    }

    public Boolean getGlassLine() {
        return glassLine;
    }

    public void setGlassLine(Boolean glassLine) {
        this.glassLine = glassLine;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    public boolean isAssignOwnCartSlot() {
        return assignOwnCartSlot;
    }

    public void setAssignOwnCartSlot(boolean assignOwnCartSlot) {
        this.assignOwnCartSlot = assignOwnCartSlot;
    }

    public double getCapacityPercent() {
        return capacityPercent;
    }

    public void setCapacityPercent(double capacityPercent) {
        this.capacityPercent = capacityPercent;
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

    public String toString() {
        return this.description;
    }

}

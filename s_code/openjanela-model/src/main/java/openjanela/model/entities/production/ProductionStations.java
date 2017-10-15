package openjanela.model.entities.production;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 05-27-13
 *          Time: 04:25 PM
 */
@Entity
@Table(name = "production_stations")
public class ProductionStations implements Serializable, Cloneable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description")
    @Basic
    private String description;

    @Column(name = "bottleneck")
    @Basic
    private boolean bottleneck;

    @Column(name = "paperless")
    @Basic
    private boolean paperless;

    @Column(name = "viewid")
    @Basic
    private int viewid;

    @Column(name = "optimized")
    @Basic
    private boolean optimized;

    @Column(name = "machinefile")
    @Basic
    private int machinefile;

    @Column(name = "savedir")
    @Basic
    private String savedir;

    @Column(name = "reportrounding")
    @Basic
    private int reportrounding;

    @Column(name = "capacity")
    @Basic
    private int capacity;

    @Column(name = "linestock")
    @Basic
    private boolean linestock;

    @Column(name = "warehouseid")
    @Basic
    private int warehouseid;

    @Column(name = "locationid")
    @Basic
    private int locationid;

    @Column(name = "ship")
    @Basic
    private boolean ship;

    @Column(name = "shipwarehouse")
    @Basic
    private int shipwarehouse;

    @Column(name = "buildingno")
    @Basic
    private int buildingno;

    @Column(name = "comments")
    @Basic
    private String comments;

    @Column(name = "active")
    private boolean active;

    @Transient
    private int prodLineId;

    public ProductionStations() {
    }

    public ProductionStations(Integer id, String description, boolean bottleneck, boolean paperless, int viewid,
                              boolean optimized, int machinefile, String savedir, int reportrounding, int capacity,
                              boolean linestock, int warehouseid, int locationid, boolean ship, int shipwarehouse,
                              int buildingno, String comments, boolean active) {

        this.id = id;
        this.description = description;
        this.bottleneck = bottleneck;
        this.paperless = paperless;
        this.viewid = viewid;
        this.optimized = optimized;
        this.machinefile = machinefile;
        this.savedir = savedir;
        this.reportrounding = reportrounding;
        this.capacity = capacity;
        this.linestock = linestock;
        this.warehouseid = warehouseid;
        this.locationid = locationid;
        this.ship = ship;
        this.shipwarehouse = shipwarehouse;
        this.buildingno = buildingno;
        this.comments = comments;
        this.active = active;
    }

    //******************************************<Getters & Setters>*****************************************************

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

    public boolean isBottleneck() {
        return bottleneck;
    }

    public void setBottleneck(boolean bottleneck) {
        this.bottleneck = bottleneck;
    }

    public boolean isPaperless() {
        return paperless;
    }

    public void setPaperless(boolean paperless) {
        this.paperless = paperless;
    }

    public int getViewid() {
        return viewid;
    }

    public void setViewid(int viewid) {
        this.viewid = viewid;
    }

    public boolean isOptimized() {
        return optimized;
    }

    public void setOptimized(boolean optimized) {
        this.optimized = optimized;
    }

    public int getMachinefile() {
        return machinefile;
    }

    public void setMachinefile(int machinefile) {
        this.machinefile = machinefile;
    }

    public String getSavedir() {
        return savedir;
    }

    public void setSavedir(String savedir) {
        this.savedir = savedir;
    }

    public int getReportrounding() {
        return reportrounding;
    }

    public void setReportrounding(int reportrounding) {
        this.reportrounding = reportrounding;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isLinestock() {
        return linestock;
    }

    public void setLinestock(boolean linestock) {
        this.linestock = linestock;
    }

    public int getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(int warehouseid) {
        this.warehouseid = warehouseid;
    }

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    public boolean isShip() {
        return ship;
    }

    public void setShip(boolean ship) {
        this.ship = ship;
    }

    public int getShipwarehouse() {
        return shipwarehouse;
    }

    public void setShipwarehouse(int shipwarehouse) {
        this.shipwarehouse = shipwarehouse;
    }

    public int getBuildingno() {
        return buildingno;
    }

    public void setBuildingno(int buildingno) {
        this.buildingno = buildingno;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getProdLineId() {
        return prodLineId;
    }

    public void setProdLineId(int prodLineId) {
        this.prodLineId = prodLineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductionStations that = (ProductionStations) o;

        if (active != that.active) return false;
        if (bottleneck != that.bottleneck) return false;
        if (buildingno != that.buildingno) return false;
        if (capacity != that.capacity) return false;
        if (id != that.id) return false;
        if (linestock != that.linestock) return false;
        if (locationid != that.locationid) return false;
        if (machinefile != that.machinefile) return false;
        if (optimized != that.optimized) return false;
        if (paperless != that.paperless) return false;
        if (reportrounding != that.reportrounding) return false;
        if (ship != that.ship) return false;
        if (shipwarehouse != that.shipwarehouse) return false;
        if (viewid != that.viewid) return false;
        if (warehouseid != that.warehouseid) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (savedir != null ? !savedir.equals(that.savedir) : that.savedir != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (bottleneck ? 1 : 0);
        result = 31 * result + (paperless ? 1 : 0);
        result = 31 * result + viewid;
        result = 31 * result + (optimized ? 1 : 0);
        result = 31 * result + machinefile;
        result = 31 * result + (savedir != null ? savedir.hashCode() : 0);
        result = 31 * result + reportrounding;
        result = 31 * result + capacity;
        result = 31 * result + (linestock ? 1 : 0);
        result = 31 * result + warehouseid;
        result = 31 * result + locationid;
        result = 31 * result + (ship ? 1 : 0);
        result = 31 * result + shipwarehouse;
        result = 31 * result + buildingno;
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.description;
    }

    /**
     * Clone Production Stations
     *
     * @return ProductionStations
     */
    public ProductionStations clone() {

        try {

            ProductionStations prodStation = (ProductionStations) super.clone();

            return prodStation;

        } catch (CloneNotSupportedException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }
}

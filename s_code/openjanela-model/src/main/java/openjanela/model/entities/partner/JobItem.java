package openjanela.model.entities.partner;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import openjanela.model.entities.design.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-18-12
 *          Time: 11:31 AM
 */
@Entity
@Table(name = "design_job_item")
@Cacheable
public class JobItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "view_out", nullable = false)
    public boolean viewOut = true;

    @Column(name = "order_id", nullable = false)
    public Integer orderId = 0;

    @Column(name = "item_id", nullable = false)
    public Integer itemId = 0;

    @Column(name = "version_id", nullable = false)
    public Integer versionId = 0;

    @Column(name = "supplier_id", nullable = false)
    public Integer supplierId = 0;

    @Column(name = "series_id", nullable = false)
    public Integer seriesId = 0;

    @Column(name = "predefine_design_id", nullable = false)
    public Integer predefineDesignId = 0;

    @Column(name = "predefine_series_id", nullable = false)
    public Integer predefineDesignSeriesId = 0;

    @Column(name = "grid_id", nullable = false)
    public int gridId = 0;

    @Column(name = "quantity", nullable = false)
    public int quantity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_item_id", referencedColumnName = "id")
    private Set<DesignOptionEntityObject> designOptions;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_item_id", referencedColumnName = "id")
    private Set<BillOfMaterialEntityObject> boms;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_item_id", referencedColumnName = "id")
    private Set<DesignGlassEntityObject> glassBoms;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_item_id", referencedColumnName = "id")
    private Set<ShapeNotesEntityObject> shapeNotes;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_item_id", referencedColumnName = "id")
    private Set<DesignGlassRatingsEntityObject> glassRatingLabels;

    @Lob
    @Column(name = "design", nullable = false)
    private byte[] design;

    /**
     * Job Item Constructor
     */
    public JobItem() {
    }

    /**
     * Job Item Constructor
     *
     * @param orderId,   Order Identification Id
     * @param itemId,    Item Identification Id
     * @param versionId, Version Identification Id
     */
    public JobItem(int orderId, int itemId, int versionId) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.versionId = versionId;
    }

    public JobItem(boolean viewOut, Integer orderId, Integer itemId, Integer versionId, Integer predefineDesignId,
                   Integer predefineDesignSeriesId, int gridId, int quantity, Set<DesignOptionEntityObject> designOptions,
                   Set<BillOfMaterialEntityObject> boms, Set<DesignGlassEntityObject> glassBoms, Set<ShapeNotesEntityObject> shapeNotes,
                   Set<DesignGlassRatingsEntityObject> glassRatingLabels, byte[] design) {

        this.viewOut = viewOut;
        this.orderId = orderId;
        this.itemId = itemId;
        this.versionId = versionId;
        this.predefineDesignId = predefineDesignId;
        this.predefineDesignSeriesId = predefineDesignSeriesId;
        this.gridId = gridId;
        this.quantity = quantity;
        this.designOptions = designOptions;
        this.boms = boms;
        this.glassBoms = glassBoms;
        this.shapeNotes = shapeNotes;
        this.glassRatingLabels = glassRatingLabels;
        this.design = design;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isViewOut() {
        return viewOut;
    }

    public void setViewOut(boolean viewOut) {
        this.viewOut = viewOut;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public Integer getPredefineDesignId() {
        return predefineDesignId;
    }

    public void setPredefineDesignId(Integer predefineDesignId) {
        this.predefineDesignId = predefineDesignId;
    }

    public Integer getPredefineDesignSeriesId() {
        return predefineDesignSeriesId;
    }

    public void setPredefineDesignSeriesId(Integer predefineDesignSeriesId) {
        this.predefineDesignSeriesId = predefineDesignSeriesId;
    }

    public int getGridId() {
        return gridId;
    }

    public void setGridId(int gridId) {
        this.gridId = gridId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<DesignOptionEntityObject> getDesignOptions() {
        return designOptions;
    }

    public void setDesignOptions(Set<DesignOptionEntityObject> designOptions) {
        this.designOptions = designOptions;
    }

    public Set<BillOfMaterialEntityObject> getBoms() {
        return boms;
    }

    public void setBoms(Set<BillOfMaterialEntityObject> boms) {
        this.boms = boms;
    }

    public Set<DesignGlassEntityObject> getGlassBoms() {

        return glassBoms;
    }

    public void setGlassBoms(Set<DesignGlassEntityObject> glassBoms) {
        this.glassBoms = glassBoms;
    }

    public byte[] getDesign() {
        return design;
    }

    public void setDesign(byte[] design) {
        this.design = design;
    }

    public Set<ShapeNotesEntityObject> getShapeNotes() {
        return shapeNotes;
    }

    public void setShapeNotes(Set<ShapeNotesEntityObject> shapeNotes) {
        this.shapeNotes = shapeNotes;
    }

    public Set<DesignGlassRatingsEntityObject> getGlassRatingLabels() {
        return glassRatingLabels;
    }

    public void setGlassRatingLabels(Set<DesignGlassRatingsEntityObject> glassRatingLabels) {
        this.glassRatingLabels = glassRatingLabels;
    }
}

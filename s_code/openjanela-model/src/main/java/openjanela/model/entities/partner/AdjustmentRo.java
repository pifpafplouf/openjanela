package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * @author Sherif
 */
@Entity
@Table(name = "adjustment_ro")
@Cacheable
public class AdjustmentRo implements Serializable, Comparable<AdjustmentRo> {

    /**
     * PROPERTY NAME: AdjustmentRO ID
     */
    protected AdjustmentRoPK adjustmentRoPK;
    /**
     * PROPERTY NAME: Description
     */
    private String description;
    /**
     * PROPERTY NAME: Row
     */
    private int row;
    /**
     * PROPERTY NAME: Row H
     */
    private int roh;
    /**
     * PROPERTY NAME: Row I
     */
    private int rowi;
    /**
     * PROPERTY NAME: Row Hi
     */
    private int rohi;
    /**
     * PROPERTY NAME: Is head
     */
    private boolean ishead;

    public AdjustmentRo() {
    }

    public AdjustmentRo(AdjustmentRoPK adjustmentRoPK, String description, int row, int roh, int rowi, int rohi,
                        boolean ishead) {
        this.adjustmentRoPK = adjustmentRoPK;
        this.description = description;
        this.row = row;
        this.roh = roh;
        this.rowi = rowi;
        this.rohi = rohi;
        this.ishead = ishead;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    @EmbeddedId
    public AdjustmentRoPK getAdjustmentRoPK() {
        return adjustmentRoPK;
    }

    public void setAdjustmentRoPK(AdjustmentRoPK adjustmentRoPK) {
        this.adjustmentRoPK = adjustmentRoPK;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "row")
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Column(name = "roh")
    public int getRoh() {
        return roh;
    }

    public void setRoh(int roh) {
        this.roh = roh;
    }

    @Column(name = "rowi")
    public int getRowi() {
        return rowi;
    }

    public void setRowi(int rowi) {
        this.rowi = rowi;
    }

    @Column(name = "rohi")
    public int getRohi() {
        return rohi;
    }

    public void setRohi(int rohi) {
        this.rohi = rohi;
    }

    @Column(name = "ishead")
    public boolean getIsHead() {
        return ishead;
    }

    public void setIsHead(boolean ish) {
        this.ishead = ish;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adjustmentRoPK != null ? adjustmentRoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return this.description;
    }

    @Override
    public boolean equals(Object o) {

        AdjustmentRo ro = (AdjustmentRo)o;

        if (this.getAdjustmentRoPK().getId() == ro.getAdjustmentRoPK().getId() &&
                this.getAdjustmentRoPK().getSeriesId() == ro.getAdjustmentRoPK().getSeriesId()) {
            return true;
        }

        return false;
    }

    @Override
    public int compareTo(AdjustmentRo o) {
        Integer ro_1_id = this.getAdjustmentRoPK().getId();
        Integer ro_2_id = o.getAdjustmentRoPK().getId();

        return ro_1_id.compareTo(ro_2_id);
    }

    /**
     * Adjustment RO Comparator
     */
    public static Comparator<AdjustmentRo> AdjustmentRoComparator = new Comparator<AdjustmentRo>() {

        public int compare(AdjustmentRo ro1, AdjustmentRo ro2) {

            Integer id1 = ro1.getAdjustmentRoPK().getId();
            Integer id2 = ro2.getAdjustmentRoPK().getId();

            //ascending order
            return id1.compareTo(id2);
        }
    };
}

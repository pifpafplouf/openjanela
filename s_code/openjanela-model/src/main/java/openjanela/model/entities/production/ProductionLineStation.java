package openjanela.model.entities.production;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-04-13
 *          Time: 09:07 PM
 */
@Entity
@Table(name = "production_line_station")
@Cacheable
public class ProductionLineStation {

    @EmbeddedId
    private ProductionLineStationPK id;

    @Column(name = "sequence", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    private int sequence;

    @Column(name = "avgwait", nullable = true, insertable = true, updatable = true, length = 15, precision = 3)
    @Basic
    private double avgwait;

    @Transient
    private int prodLineParent;

    public ProductionLineStation() {
    }

    public ProductionLineStation(ProductionLineStationPK id, int sequence, double avgwait) {
        this.id = id;
        this.sequence = sequence;
        this.avgwait = avgwait;
    }

    //******************************<Getters & Setters>*****************************************************************

    public ProductionLineStationPK getId() {
        return id;
    }

    public void setId(ProductionLineStationPK id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public double getAvgwait() {
        return avgwait;
    }

    public void setAvgwait(double avgwait) {
        this.avgwait = avgwait;
    }

    public int getProdLineParent() {
        return prodLineParent;
    }

    public void setProdLineParent(int prodLineParent) {
        this.prodLineParent = prodLineParent;
    }
}

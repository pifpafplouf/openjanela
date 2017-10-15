package openjanela.model.entities.design;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-30-13
 *          Time: 09:43 PM
 */
@Entity
@Table(name = "assembly_capacity_usage")
public class AssemblyCapacityUsageEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "assemblyid", nullable = false)
    private String assemblyId;

    @Column(name = "prodlineid", nullable = false)
    private Integer prodLineId;

    @Column(name = "stationid", nullable = false)
    private Integer stationId;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "stage")
    private int stage;

    @Column(name = "plparent")
    private Integer prodLineParentId;

    public AssemblyCapacityUsageEntity() {
    }

    public AssemblyCapacityUsageEntity(String assemblyId, Integer prodLineId, Integer stationId, int capacity, int stage,
                                       Integer prodLineParentId) {
        this.assemblyId = assemblyId;
        this.prodLineId = prodLineId;
        this.stationId = stationId;
        this.capacity = capacity;
        this.stage = stage;
        this.prodLineParentId = prodLineParentId;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(String assemblyId) {
        this.assemblyId = assemblyId;
    }

    public Integer getProdLineId() {
        return prodLineId;
    }

    public void setProdLineId(Integer prodLineId) {
        this.prodLineId = prodLineId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public Integer getProdLineParentId() {
        return prodLineParentId;
    }

    public void setProdLineParentId(Integer prodLineParentId) {
        this.prodLineParentId = prodLineParentId;
    }
}

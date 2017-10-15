package openjanela.model.entities.design;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-30-13
 *          Time: 09:43 PM
 */
@Embeddable
public class AssemblyStationUsagePK implements Serializable {

    @Column(name = "assemblyid", nullable = false)
    private String assemblyId;

    @Column(name = "prodlineid", nullable = false)
    private int prodLineId;

    @Column(name = "stationid", nullable = false)
    private int stationId;

    @Column(name = "shift", nullable = false)
    private int shift;

    public AssemblyStationUsagePK() {
    }

    public AssemblyStationUsagePK(String assemblyId, int prodLineId, int stationId, int shift) {
        this.assemblyId = assemblyId;
        this.prodLineId = prodLineId;
        this.stationId = stationId;
        this.shift = shift;
    }

    public String getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(String assemblyId) {
        this.assemblyId = assemblyId;
    }

    public int getProdLineId() {
        return prodLineId;
    }

    public void setProdLineId(int prodLineId) {
        this.prodLineId = prodLineId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }
}

package openjanela.model.entities.design;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-30-13
 *          Time: 09:43 PM
 */
@Entity
@Table(name = "assembly_station_usage")
public class AssemblyStationUsage implements Serializable {

    @EmbeddedId
    private AssemblyStationUsagePK assemblyStationUsagePK;

    @Column(name = "scheduledusedate", nullable = false)
    private Date scheduleduseDate;

    @Column(name = "usedcapacity", nullable = false)
    private int usedCapacity;

    @Column(name = "used", nullable = false)
    private boolean used;

    @Column(name = "usedby", nullable = false)
    private int usedBy;

    @Column(name = "usedondate", nullable = false)
    private Date usedOnDate;

    @Column(name = "plparent", nullable = false)
    private int prodLineParent;

    public AssemblyStationUsage() {
    }

    public AssemblyStationUsage(AssemblyStationUsagePK assemblyStationUsagePK, Date scheduleduseDate, int usedCapacity,
                                boolean used, int usedBy, Date usedOnDate, int prodLineParent) {

        this.assemblyStationUsagePK = assemblyStationUsagePK;
        this.scheduleduseDate = scheduleduseDate;
        this.usedCapacity = usedCapacity;
        this.used = used;
        this.usedBy = usedBy;
        this.usedOnDate = usedOnDate;
        this.prodLineParent = prodLineParent;
    }

    public AssemblyStationUsagePK getAssemblyStationUsagePK() {
        return assemblyStationUsagePK;
    }

    public void setAssemblyStationUsagePK(AssemblyStationUsagePK assemblyStationUsagePK) {
        this.assemblyStationUsagePK = assemblyStationUsagePK;
    }

    public Date getScheduleduseDate() {
        return scheduleduseDate;
    }

    public void setScheduleduseDate(Date scheduleduseDate) {
        this.scheduleduseDate = scheduleduseDate;
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public void setUsedCapacity(int usedCapacity) {
        this.usedCapacity = usedCapacity;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getUsedBy() {
        return usedBy;
    }

    public void setUsedBy(int usedBy) {
        this.usedBy = usedBy;
    }

    public Date getUsedOnDate() {
        return usedOnDate;
    }

    public void setUsedOnDate(Date usedOnDate) {
        this.usedOnDate = usedOnDate;
    }

    public int getProdLineParent() {
        return prodLineParent;
    }

    public void setProdLineParent(int prodLineParent) {
        this.prodLineParent = prodLineParent;
    }
}

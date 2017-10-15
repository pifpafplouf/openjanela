package openjanela.model.entities.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 3/16/14
 *          Time: 8:08 PM
 */
@Entity
@Table(name = "company_sched_pref")
@Cacheable
public class CompanySchedulePreferences implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "purchasinglt", nullable = false)
    private int purchasingLt;

    @Column(name = "staginglt", nullable = false)
    private int stagingLt;

    @Column(name = "confirmreqs", nullable = false)
    private boolean confirmReqs;

    @Column(name = "confirmreqlt", nullable = false)
    private int confirmReqLt;

    @Column(name = "splitjob", nullable = false)
    private boolean splitJob;

    @Column(name = "splitqty", nullable = false)
    private boolean splitQty;

    @Column(name = "splitassemblies", nullable = false)
    private boolean splitAssemblies;

    @Column(name = "staggerpos", nullable = false)
    private boolean staggerPos;

    @Column(name = "inventoryreceivinglt", nullable = false)
    private int inventoryReceivingLt;

    @Column(name = "autolevel", nullable = false)
    private boolean autoLevel;

    @Column(name = "invoicebeforeship", nullable = false)
    private boolean invoiceBeforeShip;

    @Column(name = "basecustomerlt", nullable = false)
    private int baseCustomerLt;

    @Column(name = "basesystemtasklt", nullable = false)
    private int baseSystemTaskLt;

    @Column(name = "measurelt", nullable = false)
    private int measureLt;

    @Column(name = "installlt", nullable = false)
    private int installLt;

    @Column(name = "schedule_permits", nullable = false)
    private boolean schedulePermits;

    @Column(name = "is_production_start_end", nullable = false)
    private boolean productionStartEndDate;

    @Column(name = "is_req_date_install_date", nullable = false)
    private boolean reqDateInstallDate;

    @Column(name = "split_measure", nullable = false)
    private boolean splitMeasure;

    @Column(name = "split_install", nullable = false)
    private boolean splitInstall;

    @Column(name = "cs_task_lt", nullable = false)
    private int taskLt;

    /**
     * Company Schedule Preferences
     */
    public CompanySchedulePreferences() {
    }

    public CompanySchedulePreferences(Integer id, int purchasingLt, int stagingLt, boolean confirmReqs, int confirmReqLt,
                                      boolean splitJob, boolean splitQty, boolean splitAssemblies, boolean staggerPos,
                                      int inventoryReceivingLt, boolean autoLevel, boolean invoiceBeforeShip,
                                      int baseCustomerLt, int baseSystemTaskLt, int measureLt, int installLt,
                                      boolean schedulePermits, boolean productionStartEndDate, boolean reqDateInstallDate,
                                      boolean splitMeasure, boolean splitInstall, int taskLt) {

        this.id = id;
        this.purchasingLt = purchasingLt;
        this.stagingLt = stagingLt;
        this.confirmReqs = confirmReqs;
        this.confirmReqLt = confirmReqLt;
        this.splitJob = splitJob;
        this.splitQty = splitQty;
        this.splitAssemblies = splitAssemblies;
        this.staggerPos = staggerPos;
        this.inventoryReceivingLt = inventoryReceivingLt;
        this.autoLevel = autoLevel;
        this.invoiceBeforeShip = invoiceBeforeShip;
        this.baseCustomerLt = baseCustomerLt;
        this.baseSystemTaskLt = baseSystemTaskLt;
        this.measureLt = measureLt;
        this.installLt = installLt;
        this.schedulePermits = schedulePermits;
        this.productionStartEndDate = productionStartEndDate;
        this.reqDateInstallDate = reqDateInstallDate;
        this.splitMeasure = splitMeasure;
        this.splitInstall = splitInstall;
        this.taskLt = taskLt;
    }

    //**************************************************<Getters & Setters>*********************************************

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPurchasingLt() {
        return purchasingLt;
    }

    public void setPurchasingLt(int purchasingLt) {
        this.purchasingLt = purchasingLt;
    }

    public int getStagingLt() {
        return stagingLt;
    }

    public void setStagingLt(int stagingLt) {
        this.stagingLt = stagingLt;
    }

    public boolean isConfirmReqs() {
        return confirmReqs;
    }

    public void setConfirmReqs(boolean confirmReqs) {
        this.confirmReqs = confirmReqs;
    }

    public int getConfirmReqLt() {
        return confirmReqLt;
    }

    public void setConfirmReqLt(int confirmReqLt) {
        this.confirmReqLt = confirmReqLt;
    }

    public boolean isSplitJob() {
        return splitJob;
    }

    public void setSplitJob(boolean splitJob) {
        this.splitJob = splitJob;
    }

    public boolean isSplitQty() {
        return splitQty;
    }

    public void setSplitQty(boolean splitQty) {
        this.splitQty = splitQty;
    }

    public boolean isSplitAssemblies() {
        return splitAssemblies;
    }

    public void setSplitAssemblies(boolean splitAssemblies) {
        this.splitAssemblies = splitAssemblies;
    }

    public boolean isStaggerPos() {
        return staggerPos;
    }

    public void setStaggerPos(boolean staggerPos) {
        this.staggerPos = staggerPos;
    }

    public int getInventoryReceivingLt() {
        return inventoryReceivingLt;
    }

    public void setInventoryReceivingLt(int inventoryReceivingLt) {
        this.inventoryReceivingLt = inventoryReceivingLt;
    }

    public boolean isAutoLevel() {
        return autoLevel;
    }

    public void setAutoLevel(boolean autoLevel) {
        this.autoLevel = autoLevel;
    }

    public boolean isInvoiceBeforeShip() {
        return invoiceBeforeShip;
    }

    public void setInvoiceBeforeShip(boolean invoiceBeforeShip) {
        this.invoiceBeforeShip = invoiceBeforeShip;
    }

    public int getBaseCustomerLt() {
        return baseCustomerLt;
    }

    public void setBaseCustomerLt(int baseCustomerLt) {
        this.baseCustomerLt = baseCustomerLt;
    }

    public int getBaseSystemTaskLt() {
        return baseSystemTaskLt;
    }

    public void setBaseSystemTaskLt(int baseSystemTaskLt) {
        this.baseSystemTaskLt = baseSystemTaskLt;
    }

    public int getMeasureLt() {
        return measureLt;
    }

    public void setMeasureLt(int measureLt) {
        this.measureLt = measureLt;
    }

    public int getInstallLt() {
        return installLt;
    }

    public void setInstallLt(int installLt) {
        this.installLt = installLt;
    }

    public boolean isSchedulePermits() {
        return schedulePermits;
    }

    public void setSchedulePermits(boolean schedulePermits) {
        this.schedulePermits = schedulePermits;
    }

    public boolean isProductionStartEndDate() {
        return productionStartEndDate;
    }

    public void setProductionStartEndDate(boolean productionStartEndDate) {
        this.productionStartEndDate = productionStartEndDate;
    }

    public boolean isReqDateInstallDate() {
        return reqDateInstallDate;
    }

    public void setReqDateInstallDate(boolean reqDateInstallDate) {
        this.reqDateInstallDate = reqDateInstallDate;
    }

    public boolean isSplitMeasure() {
        return splitMeasure;
    }

    public void setSplitMeasure(boolean splitMeasure) {
        this.splitMeasure = splitMeasure;
    }

    public boolean isSplitInstall() {
        return splitInstall;
    }

    public void setSplitInstall(boolean splitInstall) {
        this.splitInstall = splitInstall;
    }

    public int getTaskLt() {
        return taskLt;
    }

    public void setTaskLt(int taskLt) {
        this.taskLt = taskLt;
    }
}

package openjanela.model.entities.orderEntry;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-17-13
 *          Time: 03:50 PM
 */
@Entity
@Table(name = "sales_reps")
@Cacheable
public class SalesRep implements Serializable {

    @Id
    @Column(name = "userid", nullable = false)
    private Integer userId;

    @Column(name = "commissionid", nullable = true)
    private Integer commisionId;

    @Column(name = "netlistratio", nullable = true)
    private Double net_list_ratio;

    @Column(name = "netlistratioabsolute", nullable = true)
    private Double net_list_ratio_absolute;

    @Column(name = "targetmatrix", nullable = true)
    private Integer targetMatrix;

    @Column(name = "notes", nullable = true)
    private String notes;

    @Column(name = "createdate", nullable = true)
    private Date createDate;

    @Column(name = "createdby", nullable = true)
    private String createBy;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @Column(name = "commissionid_ship", nullable = false)
    private int commissionid_ship;

    @Column(name = "commissionid_install", nullable = false)
    private int commissionid_install;

    public SalesRep() {
    }

    public SalesRep(Integer userId, Integer commisionId, Double net_list_ratio, Double net_list_ratio_absolute,
                    Integer targetMatrix, String notes, Date createDate, String createBy, boolean deleted,
                    int commissionid_ship, int commissionid_install) {

        this.userId = userId;
        this.commisionId = commisionId;
        this.net_list_ratio = net_list_ratio;
        this.net_list_ratio_absolute = net_list_ratio_absolute;
        this.targetMatrix = targetMatrix;
        this.notes = notes;
        this.createDate = createDate;
        this.createBy = createBy;
        this.deleted = deleted;
        this.commissionid_ship = commissionid_ship;
        this.commissionid_install = commissionid_install;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCommisionId() {
        return commisionId;
    }

    public void setCommisionId(Integer commisionId) {
        this.commisionId = commisionId;
    }

    public Double getNet_list_ratio() {
        return net_list_ratio;
    }

    public void setNet_list_ratio(Double net_list_ratio) {
        this.net_list_ratio = net_list_ratio;
    }

    public Double getNet_list_ratio_absolute() {
        return net_list_ratio_absolute;
    }

    public void setNet_list_ratio_absolute(Double net_list_ratio_absolute) {
        this.net_list_ratio_absolute = net_list_ratio_absolute;
    }

    public Integer getTargetMatrix() {
        return targetMatrix;
    }

    public void setTargetMatrix(Integer targetMatrix) {
        this.targetMatrix = targetMatrix;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getCommissionid_ship() {
        return commissionid_ship;
    }

    public void setCommissionid_ship(int commissionid_ship) {
        this.commissionid_ship = commissionid_ship;
    }

    public int getCommissionid_install() {
        return commissionid_install;
    }

    public void setCommissionid_install(int commissionid_install) {
        this.commissionid_install = commissionid_install;
    }

}

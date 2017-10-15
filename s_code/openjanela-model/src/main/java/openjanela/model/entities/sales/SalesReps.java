package openjanela.model.entities.sales;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import openjanela.model.entities.admin.UserAdmin;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Consultant
 * @version 2.0.8
 *          Date Initial: 11-05-13
 *          Time Initial: 09:06 PM
 */
@Entity
@Table(name = "sales_reps")
public class SalesReps implements java.io.Serializable {

    @Id
    @Column(name = "userid", unique = true, nullable = false)
    private int userId;

    @Transient
    private UserAdmin user;

    @Column(name = "commissionid")
    private Integer commissionId;

    @Column(name = "netlistratio", scale = 2)
    private BigDecimal netListRatio;

    @Column(name = "netlistratioabsolute", scale = 2)
    private BigDecimal netListRatioAbsolute;

    @Column(name = "targetmatrix")
    private Integer targetMatrix;

    @Column(name = "notes", nullable = true)
    private String notes;

    @Column(name = "createdate")
    private Date createDate;

    @Column(name = "createdby")
    private Integer createdBy;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "commissionid_ship")
    private Integer shipCommission;

    @Column(name = "commissionid_install")
    private Integer installCommission;

    public SalesReps() {
    }

    public SalesReps(int userId, UserAdmin user, Integer commissionId,
                     BigDecimal netListRatio, BigDecimal netListRatioAbsolute,
                     Integer targetMatrix, String notes, Date createDate,
                     Integer createdBy, boolean deleted, Integer shipCommission,
                     Integer installCommission) {
        super();
        this.userId = userId;
        this.user = user;
        this.commissionId = commissionId;
        this.netListRatio = netListRatio;
        this.netListRatioAbsolute = netListRatioAbsolute;
        this.targetMatrix = targetMatrix;
        this.notes = notes;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.deleted = deleted;
        this.shipCommission = shipCommission;
        this.installCommission = installCommission;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserAdmin getUser() {
        return user;
    }

    public void setUser(UserAdmin user) {
        this.user = user;
    }

    public Integer getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(Integer commissionId) {
        this.commissionId = commissionId;
    }

    public BigDecimal getNetListRatio() {
        return netListRatio;
    }

    public void setNetListRatio(BigDecimal netListRatio) {
        this.netListRatio = netListRatio;
    }

    public BigDecimal getNetListRatioAbsolute() {
        return netListRatioAbsolute;
    }

    public void setNetListRatioAbsolute(BigDecimal netListRatioAbsolute) {
        this.netListRatioAbsolute = netListRatioAbsolute;
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

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getShipCommission() {
        return shipCommission;
    }

    public void setShipCommission(Integer shipCommission) {
        this.shipCommission = shipCommission;
    }

    public Integer getInstallCommission() {
        return installCommission;
    }

    public void setInstallCommission(Integer installCommission) {
        this.installCommission = installCommission;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((commissionId == null) ? 0 : commissionId.hashCode());
        result = prime * result
                + ((createDate == null) ? 0 : createDate.hashCode());
        result = prime * result
                + ((createdBy == null) ? 0 : createdBy.hashCode());
        result = prime * result + (deleted ? 1231 : 1237);
        result = prime
                * result
                + ((installCommission == null) ? 0 : installCommission
                .hashCode());
        result = prime * result
                + ((netListRatio == null) ? 0 : netListRatio.hashCode());
        result = prime
                * result
                + ((netListRatioAbsolute == null) ? 0 : netListRatioAbsolute
                .hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
        result = prime * result
                + ((shipCommission == null) ? 0 : shipCommission.hashCode());
        result = prime * result
                + ((targetMatrix == null) ? 0 : targetMatrix.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + userId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SalesReps other = (SalesReps) obj;
        if (commissionId == null) {
            if (other.commissionId != null)
                return false;
        } else if (!commissionId.equals(other.commissionId))
            return false;
        if (createDate == null) {
            if (other.createDate != null)
                return false;
        } else if (!createDate.equals(other.createDate))
            return false;
        if (createdBy == null) {
            if (other.createdBy != null)
                return false;
        } else if (!createdBy.equals(other.createdBy))
            return false;
        if (deleted != other.deleted)
            return false;
        if (installCommission == null) {
            if (other.installCommission != null)
                return false;
        } else if (!installCommission.equals(other.installCommission))
            return false;
        if (netListRatio == null) {
            if (other.netListRatio != null)
                return false;
        } else if (!netListRatio.equals(other.netListRatio))
            return false;
        if (netListRatioAbsolute == null) {
            if (other.netListRatioAbsolute != null)
                return false;
        } else if (!netListRatioAbsolute.equals(other.netListRatioAbsolute))
            return false;
        if (notes == null) {
            if (other.notes != null)
                return false;
        } else if (!notes.equals(other.notes))
            return false;
        if (shipCommission == null) {
            if (other.shipCommission != null)
                return false;
        } else if (!shipCommission.equals(other.shipCommission))
            return false;
        if (targetMatrix == null) {
            if (other.targetMatrix != null)
                return false;
        } else if (!targetMatrix.equals(other.targetMatrix))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (userId != other.userId)
            return false;
        return true;
    }

}

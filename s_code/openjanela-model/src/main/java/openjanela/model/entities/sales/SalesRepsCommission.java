package openjanela.model.entities.sales;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Consultant
 * @version 2.0.8
 *          Date Initial: 01-08-14
 *          Time Initial: 11:28 PM
 */
@Entity
@Table(name = "sales_reps_commission")
public class SalesRepsCommission implements java.io.Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "rate", scale = 2)
    private BigDecimal rate;

    @Column(name = "rate_matrix")
    private Integer rateMatrix;

    @Column(name = "notes", nullable = true)
    private String notes;

    @Column(name = "createdate")
    private Date createDate;

    @Column(name = "createdby")
    private Integer createdBy;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    public SalesRepsCommission() {
    }

    public SalesRepsCommission(Integer id, String description, BigDecimal rate,
                               Integer rateMatrix, String notes, Date createDate,
                               Integer createdBy, boolean deleted) {
        this.id = id;
        this.description = description;
        this.rate = rate;
        this.rateMatrix = rateMatrix;
        this.notes = notes;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.deleted = deleted;
    }

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

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getRateMatrix() {
        return rateMatrix;
    }

    public void setRateMatrix(Integer rateMatrix) {
        this.rateMatrix = rateMatrix;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((createDate == null) ? 0 : createDate.hashCode());
        result = prime * result
                + ((createdBy == null) ? 0 : createdBy.hashCode());
        result = prime * result + (deleted ? 1231 : 1237);
        result = prime * result
                + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
        result = prime * result + ((rate == null) ? 0 : rate.hashCode());
        result = prime * result
                + ((rateMatrix == null) ? 0 : rateMatrix.hashCode());
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
        SalesRepsCommission other = (SalesRepsCommission) obj;
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
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (notes == null) {
            if (other.notes != null)
                return false;
        } else if (!notes.equals(other.notes))
            return false;
        if (rate == null) {
            if (other.rate != null)
                return false;
        } else if (!rate.equals(other.rate))
            return false;
        if (rateMatrix == null) {
            if (other.rateMatrix != null)
                return false;
        } else if (!rateMatrix.equals(other.rateMatrix))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return description+"";
    }
}

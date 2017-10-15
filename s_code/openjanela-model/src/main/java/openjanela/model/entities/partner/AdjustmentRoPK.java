package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 *
 * @author Sherif
 */
@Embeddable
public class AdjustmentRoPK implements Serializable {

    /**
     * PROPERTY NAME: Identification Number
     */
    private int id;
    /**
     * PROPERTY NAME: Series Identification
     */
    private int seriesId;

    //************************************************************************
    // CONSTRUCTORS
    //************************************************************************

    /**
     * Default Constructor
     */
    public AdjustmentRoPK() {}

    /**
     * Adjustment RO Constructor
     *
     * @param id,       Identification Id
     * @param seriesId, Series Id
     */
    public AdjustmentRoPK(int id, int seriesId) {
        this.id = id;
        this.seriesId = seriesId;
    }

    //************************************************************************
    // GETTERS AND SETTERS
    //************************************************************************

    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "series_id", nullable = false)
    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += id;
        hash += seriesId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdjustmentRoPK)) {
            return false;
        }
        AdjustmentRoPK other = (AdjustmentRoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.seriesId != other.seriesId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Openjanela_Partner_PersistenceObjects.AdjustmentRoPK[ id=" + id + ", seriesId=" + seriesId + " ]";
    }

}

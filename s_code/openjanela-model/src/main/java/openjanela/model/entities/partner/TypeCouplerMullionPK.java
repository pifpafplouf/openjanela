package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 09-19-12
 * Time: 02:03 PM
 */
@Embeddable
public class TypeCouplerMullionPK implements Serializable {

    /**
     * PROPERTY NAME: Identification Id
     */
    private Integer id;
    /**
     * PROPERTY NAME: Series Identification Id
     */
    private Integer seriesId;

    //************************************************************************
    // CONSTRUCTORS
    //************************************************************************

    /**
     * Default constructor
     */
    public TypeCouplerMullionPK() {
    }

    /**
     * Type Coupler Mullion Constructor
     *
     * @param id,       Identification Id
     * @param seriesId, Series Identificatio Id
     */
    public TypeCouplerMullionPK(Integer id, Integer seriesId) {
        this.id = id;
        this.seriesId = seriesId;
    }

    //************************************************************************
    // GETTERS AND SETTERS
    //************************************************************************

    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "series_id", nullable = false)
    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }
}

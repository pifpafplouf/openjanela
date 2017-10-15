package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2012 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-04-12
 *          Time: 09:30 AM
 */
@Embeddable
public class SeriesValidOpeningShapePK implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "series_id", nullable = false)
    private Integer seriesId;

    @Column(name = "opening_id", nullable = false)
    private Integer openingId;

    @Column(name = "abbreviation", nullable = false)
    private String abbreviation;

    /**
     * Default Constructor
     */
    public SeriesValidOpeningShapePK() {
    }

    /**
     * Series Valid Opening Shape Primary Key Constructor
     *
     * @param id,        Identification Id
     * @param seriesId,  Series Identification Id
     * @param openingId, Opening Identification Id
     * @param abbrev,    Abbreviation
     */
    public SeriesValidOpeningShapePK(Integer id, Integer seriesId, Integer openingId, String abbrev) {
        this.id = id;
        this.seriesId = seriesId;
        this.openingId = openingId;
        this.abbreviation = abbrev;
    }

    // ==================================<GETTTER AND SETTERS>=================================================


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public Integer getOpeningId() {
        return openingId;
    }

    public void setOpeningId(Integer openingId) {
        this.openingId = openingId;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}

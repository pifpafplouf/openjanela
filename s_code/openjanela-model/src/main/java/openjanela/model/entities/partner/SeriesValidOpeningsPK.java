package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 08-30-12
 * Time: 09:21 AM
 */
@Embeddable
public class SeriesValidOpeningsPK implements Serializable {

    /**
     * PROPERTY NAME: Series Identification
     */
    private Integer seriesId;
    /**
     * PROPERTY NAME: Opening Identification
     */
    private Integer openingId;

    // ==================================<GETTTER AND SETTERS>=================================================

    @Column(name = "seriesid", nullable = false)
    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    @Column(name = "openingid", nullable = false)
    public Integer getOpeningId() {
        return openingId;
    }

    public void setOpeningId(Integer openingId) {
        this.openingId = openingId;
    }
}

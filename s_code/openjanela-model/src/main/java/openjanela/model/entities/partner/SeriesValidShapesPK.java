package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 08-28-12
 * Time: 02:45 PM
 */
@Embeddable
public class SeriesValidShapesPK implements Serializable {

    /**
     * PROPERTY NAME: Series Identification
     */
    private Integer seriesId;
    /**
     * PROPERTY NAME: Shape Identification
     */
    private Integer shapeId;

    // ==================================<GETTTER AND SETTERS>=================================================

    @Column(name = "shapeid", nullable = false)
    public Integer getShapeId() {
        return shapeId;
    }

    public void setShapeId(Integer shapeId) {
        this.shapeId = shapeId;
    }

    @Column(name = "seriesid", nullable = false)
    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }
}

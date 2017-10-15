package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 02-20-14
 *          Time: 10:17 AM
 */
@Embeddable
public class SeriesValidOpeningShapeMfgPK implements Serializable {

    @Column(name = "series_id", nullable = false)
    private int seriesId;

    @Column(name = "opening_id", nullable = false)
    private int openingId;

    @Column(name = "shape_id", nullable = false)
    private int shapeId;

    @Column(name = "part_id", nullable = false)
    private int partId;

    // ==========================================<GETTTER AND SETTERS>=================================================

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public int getOpeningId() {
        return openingId;
    }

    public void setOpeningId(int openingId) {
        this.openingId = openingId;
    }

    public int getShapeId() {
        return shapeId;
    }

    public void setShapeId(int shapeId) {
        this.shapeId = shapeId;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }
}

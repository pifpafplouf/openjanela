package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 09-12-12
 * Time: 03:35 PM
 */
@Embeddable
public class SeriesAllowedSUThickPK implements Serializable {

    /**
     * PROPERTY NAME: Primary Key value
     */
    private Integer seriesId;
    /**
     * PROPERTY NAME: From thick value
     */
    private int fromThick;
    /**
     * PROPERTY NAME: To thick value
     */
    private int toThick;
    /**
     * PROPERTY NAME: From thick value imperial
     */
    private int fromThickImp;
    /**
     * PROPERTY NAME: to thick value imperial
     */
    private int toThickImp;

    // ==================================<GETTTER AND SETTERS>=================================================

    @Column(name = "series_id", nullable = false)
    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    @Column(name = "from_thick", nullable = false)
    public int getFromThick() {
        return fromThick;
    }

    public void setFromThick(int fromThick) {
        this.fromThick = fromThick;
    }

    @Column(name = "to_thick", nullable = false)
    public int getToThick() {
        return toThick;
    }

    public void setToThick(int toThick) {
        this.toThick = toThick;
    }

    @Column(name = "from_thick_imp", nullable = false)
    public int getFromThickImp() {
        return fromThickImp;
    }

    public void setFromThickImp(int fromThickImp) {
        this.fromThickImp = fromThickImp;
    }

    @Column(name = "to_thick_imp", nullable = false)
    public int getToThickImp() {
        return toThickImp;
    }

    public void setToThickImp(int toThickImp) {
        this.toThickImp = toThickImp;
    }
}

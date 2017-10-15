package openjanela.model.entities.design;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *  Copyright (c) 2013, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 01-19-13
 * Time: 02:04 PM
 */
@Embeddable
public class DesignPK implements Serializable {

    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "series_id", nullable = false)
    private Integer seriesId;

    /**
     * Default No constructor for DesignPK class
     */
    public DesignPK() {
    }

    /**
     * Design Primary Key Constructor
     * @param id, Identification Id
     * @param seriesId, Series Identification Id
     */
    public DesignPK(Integer id, Integer seriesId) {
        this.id = id;
        this.seriesId = seriesId;
    }

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
}

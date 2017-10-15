package openjanela.model.entities.design;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2013, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 01-19-13
 * Time: 10:30 PM
 */
@Embeddable
public class DesignFamilyPK implements Serializable {

    @Column(name = "id")
    private Integer id;
    @Column(name = "series_id")
    private Integer seriesId;

    public DesignFamilyPK() {
    }

    public DesignFamilyPK(Integer id, Integer seriesId) {
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

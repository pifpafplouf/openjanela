package openjanela.model.entities.partner;

import javax.persistence.Cacheable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 09-12-12
 * Time: 03:00 PM
 */
@Entity
@Table(name = "series_allowed_su_thick")
@Cacheable
public class SeriesAllowedSUThick implements Serializable {

    /**
     * PROPERTY NAME: Primary key identification
     */
    private SeriesAllowedSUThickPK id;

    public SeriesAllowedSUThick() {
    }

    public SeriesAllowedSUThick(SeriesAllowedSUThickPK id) {
        this.id = id;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    @EmbeddedId
    public SeriesAllowedSUThickPK getId() {
        return id;
    }

    public void setId(SeriesAllowedSUThickPK id) {
        this.id = id;
    }
}

package openjanela.model.entities.partner;

import javax.persistence.Cacheable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 08-30-12
 * Time: 08:58 AM
 */
@Entity
@Table(name = "series_valid_openings")
@Cacheable
public class SeriesValidOpenings implements Serializable {

    /**
     * PROPERTY NAME: Primary Key Identification
     */
    private SeriesValidOpeningsPK id;

    // ==================================<GETTTER AND SETTERS>=================================================

    @EmbeddedId
    public SeriesValidOpeningsPK getId() {
        return id;
    }

    public void setId(SeriesValidOpeningsPK id) {
        this.id = id;
    }
}

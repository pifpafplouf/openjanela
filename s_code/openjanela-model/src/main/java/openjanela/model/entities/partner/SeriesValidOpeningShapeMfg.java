package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 02-20-14
 *          Time: 10:17 AM
 */
@Entity
@Table(name = "series_valid_opening_shape_mfg")
@Cacheable
public class SeriesValidOpeningShapeMfg implements Serializable {

    @EmbeddedId
    private SeriesValidOpeningShapeMfgPK id;

    @Column(name = "made_in", nullable = false)
    private boolean madeIn = false;

    @Column(name = "glass_made_in", nullable = false)
    private boolean glassMadeIn = false;

    @Column(name = "bought_glazed", nullable = false)
    private boolean boughtGlazed = false;

    public SeriesValidOpeningShapeMfg() {
    }

    public SeriesValidOpeningShapeMfg(SeriesValidOpeningShapeMfgPK id, boolean madeIn, boolean glassMadeIn,
                                      boolean boughtGlazed) {
        this.id = id;
        this.madeIn = madeIn;
        this.glassMadeIn = glassMadeIn;
        this.boughtGlazed = boughtGlazed;
    }

    // ==========================================<GETTTER AND SETTERS>=================================================

    public SeriesValidOpeningShapeMfgPK getId() {
        return id;
    }

    public void setId(SeriesValidOpeningShapeMfgPK id) {
        this.id = id;
    }

    public boolean isMadeIn() {
        return madeIn;
    }

    public void setMadeIn(boolean madeIn) {
        this.madeIn = madeIn;
    }

    public boolean isGlassMadeIn() {
        return glassMadeIn;
    }

    public void setGlassMadeIn(boolean glassMadeIn) {
        this.glassMadeIn = glassMadeIn;
    }

    public boolean isBoughtGlazed() {
        return boughtGlazed;
    }

    public void setBoughtGlazed(boolean boughtGlazed) {
        this.boughtGlazed = boughtGlazed;
    }
}

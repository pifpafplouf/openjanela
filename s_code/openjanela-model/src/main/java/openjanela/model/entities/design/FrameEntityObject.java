package openjanela.model.entities.design;

import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-13-12
 *          Time: 12:09 AM
 */
public class FrameEntityObject extends ShapeAbstractObject {

    //Serializable Version
    private static final long serialVersionUID = -2699457859389193931L;

    /**
     * Bkgrd Opening entity relationship
     */
    private BkgrdOpeningEntityObject bkgrdOpening;

    /**
     * Opening Object entity relationship
     */
    private Set<OpeningEntityObject> openingsObject;

    /**
     * Design Glass Ratings relationship
     */
    private Set<DesignGlassRatingsEntityObject> designGlassRatings;

    // ==================================<METODOS GETTTER AND SETTERS>=================================================

    public BkgrdOpeningEntityObject getBkgrdOpening() {
        return bkgrdOpening;
    }

    public void setBkgrdOpening(BkgrdOpeningEntityObject bkgrdOpening) {
        this.bkgrdOpening = bkgrdOpening;
    }

    public Set<OpeningEntityObject> getOpeningsObject() {
        return openingsObject;
    }

    public void setOpeningsObject(Set<OpeningEntityObject> openingsObject) {
        this.openingsObject = openingsObject;
    }

    public Set<DesignGlassRatingsEntityObject> getDesignGlassRatings() {
        return designGlassRatings;
    }

    public void setDesignGlassRatings(Set<DesignGlassRatingsEntityObject> designGlassRatings) {
        this.designGlassRatings = designGlassRatings;
    }
}

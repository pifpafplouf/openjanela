package openjanela.model.entities.design;

import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-17-12
 *          Time: 02:04 PM
 */
public class SubFacetEntityObject extends ShapeAbstractObject {

    //Serializable version
    private static final long serialVersionUID = 2304639924695855218L;

    /**
     * Bkgrd Opening entity object
     */
    private BkgrdOpeningEntityObject bkgrdOpening;

    /**
     * Opening collection objects
     */
    private Set<OpeningEntityObject> openingsObject;

    /**
     * Frames collection objects
     */
    private Set<FrameEntityObject> frames;

    /**
     * SubFacetEntity Object constructor
     */
    public SubFacetEntityObject() {
        super();
    }

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

    public Set<FrameEntityObject> getFrames() {
        return frames;
    }

    public void setFrames(Set<FrameEntityObject> frames) {
        this.frames = frames;
    }

}

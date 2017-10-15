package openjanela.model.entities.design;

import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-06-12
 *          Time: 03:37 PM
 */
public class FacetEntityObject extends ShapeAbstractObject {

    //Serializable Version
    private static final long serialVersionUID = -3126122006427214488L;

    private boolean inUse = false;

    /**
     * Construction Map levels and sequences
     */
    private ConstructionMap parentOpeningMap;

    /**
     * Bkgrd Opening relationship
     */
    private BkgrdOpeningEntityObject bkgrdOpening;

    /**
     * Sub Facet relationship
     */
    private SubFacetEntityObject subFacet;

    /**
     * Collection Opening objects
     */
    private Set<OpeningEntityObject> openingsObject;

    /**
     * Collection Frame objects
     */
    private Set<FrameEntityObject> frames;

    // ==================================<METODOS GETTTER AND SETTERS>=================================================

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public ConstructionMap getParentOpeningMap() {
        return parentOpeningMap;
    }

    public void setParentOpeningMap(ConstructionMap parentOpeningMap) {
        this.parentOpeningMap = parentOpeningMap;
    }

    public BkgrdOpeningEntityObject getBkgrdOpening() {
        return bkgrdOpening;
    }

    public void setBkgrdOpening(BkgrdOpeningEntityObject bkgrdOpening) {
        this.bkgrdOpening = bkgrdOpening;
    }

    public SubFacetEntityObject getSubFacet() {
        return subFacet;
    }

    public void setSubFacet(SubFacetEntityObject subFacet) {
        this.subFacet = subFacet;
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

package openjanela.model.entities.design;

import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-06-12
 *          Time: 03:36 PM.
 *          This class represent the main principal container object
 */
public class OverallEntityObject extends ShapeAbstractObject {

    //Serializable version
    private static final long serialVersionUID = 19336820585957398L;

    /**
     * Bkgrd Opening entity object
     */
    private BkgrdOpeningEntityObject bkgrdOpeningEntityObject;
    /**
     * Opening entities collection
     */
    private Set<OpeningEntityObject> openings;
    /**
     * Facet entities collection
     */
    private Set<FacetEntityObject> facets;
    /**
     * Collection of forced options answers
     */
    private Set<ForcedOptionAnswerEntityObject> optionsAnswers;

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public BkgrdOpeningEntityObject getBkgrdOpeningEntityObject() {
        return bkgrdOpeningEntityObject;
    }

    public void setBkgrdOpeningEntityObject(BkgrdOpeningEntityObject bkgrdOpeningEntityObject) {
        this.bkgrdOpeningEntityObject = bkgrdOpeningEntityObject;
    }

    public Set<OpeningEntityObject> getOpenings() {
        return openings;
    }

    public void setOpenings(Set<OpeningEntityObject> openings) {
        this.openings = openings;
    }

    public Set<FacetEntityObject> getFacets() {
        return facets;
    }

    public void setFacets(Set<FacetEntityObject> facets) {
        this.facets = facets;
    }

    public Set<ForcedOptionAnswerEntityObject> getOptionsAnswers() {
        return optionsAnswers;
    }

    public void setOptionsAnswers(Set<ForcedOptionAnswerEntityObject> optionsAnswers) {
        this.optionsAnswers = optionsAnswers;
    }
}

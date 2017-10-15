package openjanela.model.entities.design;

import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-06-12
 *          Time: 03:56 PM
 */
public class OpeningEntityObject extends ShapeAbstractObject {

    //Serializable version
    private static final long serialVersionUID = -8162174829609785945L;

    /**
     * SubFacet entity object relationship
     */
    private SubFacetEntityObject subFacet;
    /**
     * GlassSU In entity object relationship
     */
    private GlassSUEntityObject glassIn;
    /**
     * GlassSU Mid entity object relationship
     */
    private GlassSUEntityObject glassMid;
    /**
     * GlassSU Out entity object relationship
     */
    private GlassSUEntityObject glassOut;
    /**
     * Sash Type In entity object relationship
     */
    private SashTypeEntityObject sashTypeIn;
    /**
     * Sash Type Mid entity object relationship
     */
    private SashTypeEntityObject sashTypeMid;
    /**
     * Sash Type Out entity object relationship
     */
    private SashTypeEntityObject sashTypeOut;
    /**
     * DLO In entity object relationship
     */
    private DLOEntityObject dloIn;
    /**
     * DLO Mid entity object relationship
     */
    private DLOEntityObject dloMid;
    /**
     * DLO Out entity object relationship
     */
    private DLOEntityObject dloOut;
    /**
     * Glazing Bead In entity object relationship
     */
    private GlazingBeadsEntityObject glazingBeadIn;
    /**
     * Glazing Bead Mid entity object relationship
     */
    private GlazingBeadsEntityObject glazingBeadMid;
    /**
     * Glazing Bead Out entity object relationship
     */
    private GlazingBeadsEntityObject glazingBeadOut;
    /**
     * Profile Glazing Beads collection
     */
    private Set<ProfileGlazingBeadsEntityObject> glazingBeads;
    /**
     * Opening entity collections
     */
    private Set<OpeningEntityObject> openingsObject;

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public SubFacetEntityObject getSubFacet() {
        return subFacet;
    }

    public void setSubFacet(SubFacetEntityObject subFacet) {
        this.subFacet = subFacet;
    }

    public GlassSUEntityObject getGlassIn() {
        return glassIn;
    }

    public void setGlassIn(GlassSUEntityObject glassIn) {
        this.glassIn = glassIn;
    }

    public GlassSUEntityObject getGlassMid() {
        return glassMid;
    }

    public void setGlassMid(GlassSUEntityObject glassMid) {
        this.glassMid = glassMid;
    }

    public GlassSUEntityObject getGlassOut() {
        return glassOut;
    }

    public void setGlassOut(GlassSUEntityObject glassOut) {
        this.glassOut = glassOut;
    }

    public SashTypeEntityObject getSashTypeIn() {
        return sashTypeIn;
    }

    public void setSashTypeIn(SashTypeEntityObject sashTypeIn) {
        this.sashTypeIn = sashTypeIn;
    }

    public SashTypeEntityObject getSashTypeMid() {
        return sashTypeMid;
    }

    public void setSashTypeMid(SashTypeEntityObject sashTypeMid) {
        this.sashTypeMid = sashTypeMid;
    }

    public SashTypeEntityObject getSashTypeOut() {
        return sashTypeOut;
    }

    public void setSashTypeOut(SashTypeEntityObject sashTypeOut) {
        this.sashTypeOut = sashTypeOut;
    }

    public DLOEntityObject getDloIn() {
        return dloIn;
    }

    public void setDloIn(DLOEntityObject dloIn) {
        this.dloIn = dloIn;
    }

    public DLOEntityObject getDloMid() {
        return dloMid;
    }

    public void setDloMid(DLOEntityObject dloMid) {
        this.dloMid = dloMid;
    }

    public DLOEntityObject getDloOut() {
        return dloOut;
    }

    public void setDloOut(DLOEntityObject dloOut) {
        this.dloOut = dloOut;
    }

    public GlazingBeadsEntityObject getGlazingBeadIn() {
        return glazingBeadIn;
    }

    public void setGlazingBeadIn(GlazingBeadsEntityObject glazingBeadIn) {
        this.glazingBeadIn = glazingBeadIn;
    }

    public GlazingBeadsEntityObject getGlazingBeadMid() {
        return glazingBeadMid;
    }

    public void setGlazingBeadMid(GlazingBeadsEntityObject glazingBeadMid) {
        this.glazingBeadMid = glazingBeadMid;
    }

    public GlazingBeadsEntityObject getGlazingBeadOut() {
        return glazingBeadOut;
    }

    public void setGlazingBeadOut(GlazingBeadsEntityObject glazingBeadOut) {
        this.glazingBeadOut = glazingBeadOut;
    }

    public Set<ProfileGlazingBeadsEntityObject> getGlazingBeads() {
        return glazingBeads;
    }

    public void setGlazingBeads(Set<ProfileGlazingBeadsEntityObject> glazingBeads) {
        this.glazingBeads = glazingBeads;
    }

    public Set<OpeningEntityObject> getOpeningsObject() {
        return openingsObject;
    }

    public void setOpeningsObject(Set<OpeningEntityObject> openingsObject) {
        this.openingsObject = openingsObject;
    }
}

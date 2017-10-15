package openjanela.model.entities.design;

import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-21-12
 *          Time: 11:03 PM
 */
public class SashLeafEntityObject extends ShapeAbstractObject {

    //Serializable version
    private static final long serialVersionUID = 5296238113252510935L;

    private int leafNo = 0;
    private int trackNo = 0;
    private int paneType = 0;

    /**
     * Bkgrd Opening entity object
     */
    private BkgrdOpeningEntityObject bkgrdOpening;

    /**
     * Opening collection entities
     */
    private Set<OpeningEntityObject> openings;

    // ==================================<METODOS GETTTER AND SETTERS>=================================================

    public int getLeafNo() {
        return leafNo;
    }

    public void setLeafNo(int leafNo) {
        this.leafNo = leafNo;
    }

    public int getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(int trackNo) {
        this.trackNo = trackNo;
    }

    public int getPaneType() {
        return paneType;
    }

    public void setPaneType(int paneType) {
        this.paneType = paneType;
    }

    public BkgrdOpeningEntityObject getBkgrdOpening() {
        return bkgrdOpening;
    }

    public void setBkgrdOpening(BkgrdOpeningEntityObject bkgrdOpening) {
        this.bkgrdOpening = bkgrdOpening;
    }

    public Set<OpeningEntityObject> getOpenings() {
        return openings;
    }

    public void setOpenings(Set<OpeningEntityObject> openings) {
        this.openings = openings;
    }
}

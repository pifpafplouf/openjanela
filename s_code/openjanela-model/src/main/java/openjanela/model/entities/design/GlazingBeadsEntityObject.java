package openjanela.model.entities.design;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-13-12
 *          Time: 12:11 AM
 */
public class GlazingBeadsEntityObject extends ShapeAbstractObject {

    //Serializable version
    private static final long serialVersionUID = -5009904944580953772L;

    private int position;

    private int suTypeID = 0;
    private int suFamily = 0;
    private int suThick_m = 0;
    private int suThick_i = 0;

    /**
     * Bkgrd Opening Object
     */
    private BkgrdOpeningEntityObject bkgrdOpening;

    /**
     * Opening Entity Object
     */
    private OpeningEntityObject opening;

    // ==================================<METODOS GETTTER AND SETTERS>=================================================

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getSuTypeID() {
        return suTypeID;
    }

    public void setSuTypeID(int suTypeID) {
        this.suTypeID = suTypeID;
    }

    public int getSuFamily() {
        return suFamily;
    }

    public void setSuFamily(int suFamily) {
        this.suFamily = suFamily;
    }

    public int getSuThick_m() {
        return suThick_m;
    }

    public void setSuThick_m(int suThick_m) {
        this.suThick_m = suThick_m;
    }

    public int getSuThick_i() {
        return suThick_i;
    }

    public void setSuThick_i(int suThick_i) {
        this.suThick_i = suThick_i;
    }

    public BkgrdOpeningEntityObject getBkgrdOpening() {
        return bkgrdOpening;
    }

    public void setBkgrdOpening(BkgrdOpeningEntityObject bkgrdOpening) {
        this.bkgrdOpening = bkgrdOpening;
    }

    public OpeningEntityObject getOpening() {
        return opening;
    }

    public void setOpening(OpeningEntityObject opening) {
        this.opening = opening;
    }

}

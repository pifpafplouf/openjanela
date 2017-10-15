package openjanela.model.entities.design;

import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-06-12
 *          Time: 03:38 PM
 *          This class represents the main Background Opening shape object model.
 */
public class BkgrdOpeningEntityObject extends ShapeAbstractObject {

    //Serializable version
    private static final long serialVersionUID = 673620962074800598L;

    private int order = 0;
    private double newRowH = 0.0;

    /**
     * DLO Entity Object relationship
     */
    private DLOEntityObject DLOGlass;

    /**
     * Profile Collection Entity Object
     */
    private Set<ProfileEntityObject>  profiles;

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public double getNewRowH() {
        return newRowH;
    }

    public void setNewRowH(double newRowH) {
        this.newRowH = newRowH;
    }

    public DLOEntityObject getDLOGlass() {
        return DLOGlass;
    }

    public void setDLOGlass(DLOEntityObject DLOGlass) {
        this.DLOGlass = DLOGlass;
    }

    public Set<ProfileEntityObject> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<ProfileEntityObject> profiles) {
        this.profiles = profiles;
    }
}

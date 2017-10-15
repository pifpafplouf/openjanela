package openjanela.model.entities.design;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-05-12
 *          Time: 09:28 AM
 */
public class ProfileGlazingBeadsEntityObject extends ProfileAbstractObject {

    //Serializable version
    private static final long serialVersionUID = -6710864567352743993L;

    private int location = 0;

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

}

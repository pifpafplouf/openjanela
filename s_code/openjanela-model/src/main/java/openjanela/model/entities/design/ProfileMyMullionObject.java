package openjanela.model.entities.design;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-05-13
 *          Time: 11:02 AM
 */
public class ProfileMyMullionObject extends ProfileAbstractObject {

    //Serializable version
    private static final long serialVersionUID = -8784579557224796882L;

    private int _part_object = 0;

    // ==================================<METODOS GETTTER AND SETTERS>=================================================

    public int get_part_object() {
        return _part_object;
    }

    public void set_part_object(int _part_object) {
        this._part_object = _part_object;
    }
}

package openjanela.model.entities.design;

import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-10-12
 *          Time: 10:50 PM
 */
public class ProfileCollectionObject extends ProfileAbstractObject implements Serializable {

    //Serializable version
    private static final long serialVersionUID = 3364438361159005581L;

    private int _part_object = 0;

    // ==================================<METODOS GETTTER AND SETTERS>=================================================

    public int get_part_object() {
        return _part_object;
    }

    public void set_part_object(int _part_object) {
        this._part_object = _part_object;
    }
}

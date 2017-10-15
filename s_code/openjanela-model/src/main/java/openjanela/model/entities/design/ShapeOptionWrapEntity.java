package openjanela.model.entities.design;

import java.io.Serializable;
import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 9/18/13
 *          Time: 3:10 PM
 */
public class ShapeOptionWrapEntity implements Serializable {

    //Serializable version
    private static final long serialVersionUID = 9084798889816050629L;

    //Shape Options Collection
    private Set<ShapeOptionEntityObject> shapeOptions;

    //**************************************************<Getters & Setters>*********************************************

    public Set<ShapeOptionEntityObject> getShapeOptions() {
        return shapeOptions;
    }

    public void setShapeOptions(Set<ShapeOptionEntityObject> shapeOptions) {
        this.shapeOptions = shapeOptions;
    }
}

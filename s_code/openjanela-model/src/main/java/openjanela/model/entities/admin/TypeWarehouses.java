package openjanela.model.entities.admin;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 02-12-14
 *          Time: 12:15 PM
 */
public enum TypeWarehouses {

    MAINSTOCK(1),
    SATELITESTOCK(2),
    SHIPAREA(3),
    RECEIVING(4);

    private int type;

    TypeWarehouses(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}


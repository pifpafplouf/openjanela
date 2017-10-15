package org.openjanela.data;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-20-13
 *          Time: 09:00 PM
 */
public enum MenuActionEventDraw {

    NOT_SELECTION(0),
    COUPLER_MULLION_EVENT(1),
    SHAPE_EVENT(2),
    SASH_EVENT(3),
    GLASS_SEALED_UNIT_EVENT(4),
    GRIDS_EVENT(5),
    ALIGN_VERTICAL(6),
    ALIGN_HORIZONTAL(7),
    EDIT_COUPLER_MULLION(8),
    EXTEND_COUPLER_MULLION(9),
    EDIT_FRAME(10),
    REMOVE_FRAME(11);

    public int value;

    MenuActionEventDraw(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public void resetValue() {
	        value=0;
	    }

}

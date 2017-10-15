package openjanela.model.entities.design;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 03-15-12
 * Time: 11:49 AM
 */
public enum GlazingTypes {

    UNGLAZED(0),
    GLASS(1),
    SU(2),
    INSERT(3),
    DOOR_INSERT(4);

    private int value;

    GlazingTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

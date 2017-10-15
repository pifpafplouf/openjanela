package openjanela.model.entities.design;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 04-17-12
 * Time: 04:10 PM
 */
public enum GlazingBeadsLocations {

    IN(1),
    MID(2),
    OUT(3);

    private int value;

    GlazingBeadsLocations(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package openjanela.model.entities.design;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-04-12
 * Time: 12:08 AM
 */
public enum OpeningTypes {

    WINDOW(1),
    DOOR(2),
    ENTRANCE(3),
    STANDARD(4);

    private int value;

    OpeningTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

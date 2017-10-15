package openjanela.model.entities.design;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 03-15-12
 * Time: 10:25 AM
 */
public enum OrielTypes {

    SLIDE_FOLD(0),
    IN(1),
    OUT(2);

    private int value;

    OrielTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

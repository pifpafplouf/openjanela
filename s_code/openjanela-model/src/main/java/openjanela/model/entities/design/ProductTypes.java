package openjanela.model.entities.design;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 03-15-12
 * Time: 10:01 AM
 */
public enum ProductTypes {

    WINDOW(1),
    DOOR(2),
    ENTRY(3),
    STANDARD_SIZE_WINDOW(4);

    private int value;

    ProductTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

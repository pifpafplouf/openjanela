package openjanela.model.entities.design;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 03-24-12
 * Time: 02:03 PM
 */
public enum ProfilesType {

    COUPLER(1),
    DIVIDER(1),
    MULLION(0),
    GRID(0);

    private int value;

    ProfilesType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

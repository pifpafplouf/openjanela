package openjanela.model.entities.design;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * Represent a content type of a SashType content
 * User: EMontenegro
 * Date: 05-22-12
 * Time: 10:46 PM
 */
public enum ContentTypes {

    NOTHING(0),
    GLASS(1),
    SASHTYPE(2),
    SUBFRAME(3);

    private int value;

    ContentTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}

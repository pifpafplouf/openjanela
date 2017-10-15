package openjanela.model.entities.design;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 09-28-12
 * Time: 03:21 PM
 */
public enum OpeningContentTypes {

    GLASS(1),
    SASH(2),
    SUBFRAME(3);

    private int value;

    OpeningContentTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

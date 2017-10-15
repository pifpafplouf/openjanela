package openjanela.model.entities.partner;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 09-20-12
 * Time: 11:58 AM
 */
public enum ValidOrientations {

    VERTICAL(1),
    HORIZONTAL(2);

    public int value;

    ValidOrientations(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

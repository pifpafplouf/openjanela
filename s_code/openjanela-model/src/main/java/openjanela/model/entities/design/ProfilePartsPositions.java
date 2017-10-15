package openjanela.model.entities.design;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 06-05-12
 * Time: 10:58 AM
 */
public enum ProfilePartsPositions {

    TOP1(1),
    TOP2(2),
    TOP3(3),
    RIGHT(4),
    BOT1(5),
    BOT2(6),
    BOT3(7),
    LEFT(8);

    private int value;

    ProfilePartsPositions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

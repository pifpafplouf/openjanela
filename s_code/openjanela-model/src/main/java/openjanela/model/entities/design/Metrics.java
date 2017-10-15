package openjanela.model.entities.design;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 03-06-12
 * Time: 04:23 PM
 * Units of metrics
 */
public enum Metrics {

    METRIC(1),
    IMPERIAL_DECIMAL(2),
    IMPERIAL_FRACTION(3),
    FEET(4);

    private int value;

    Metrics(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

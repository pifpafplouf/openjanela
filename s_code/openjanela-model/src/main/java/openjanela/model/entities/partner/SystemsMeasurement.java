package openjanela.model.entities.partner;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 10-11-12
 * Time: 02:55 PM
 */
public enum SystemsMeasurement {

    Metric(1),
    Imperial(2),
    Fraction(3),
    Not_Applicable(4);

    private int value;

    SystemsMeasurement(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

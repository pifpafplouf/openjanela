package openjanela.model.entities.admin;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 10/10/13
 *          Time: 11:19 AM
 */
public enum MathOperators {

    SUM("+"),
    REST("-"),
    MULT("*"),
    DIV("/"),
    MOD("%"),
    GRATHER(">"),
    LESSER("<"),
    EQUALS("=");

    private String mathValue;

    MathOperators(String mathValue) {
        this.mathValue = mathValue;
    }

    public String getMathValue() {
        return mathValue;
    }
}

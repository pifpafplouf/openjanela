package openjanela.model.entities.partner;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-22-12
 * Time: 11:16 PM
 */
public enum TypeOperands {

    ADD(1),
    SUBSTRACT(2),
    MULTIPLY(3),
    DIVIDE(4);

    public int value;

    TypeOperands(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package openjanela.model.entities.partner;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-24-12
 * Time: 11:12 PM
 */
public enum TypesMatrixCell {

    NOT_FOUND(0),
    VALUE(1),
    MATRIX(2),
    ERROR(3),
    WARNING(4),
    TITLE(5),
    XC(6),
    XR(7);

    public int value;

    TypesMatrixCell(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

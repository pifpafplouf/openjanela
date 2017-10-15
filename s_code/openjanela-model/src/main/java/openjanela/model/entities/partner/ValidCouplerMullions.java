package openjanela.model.entities.partner;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 09-20-12
 * Time: 11:55 AM
 */
public enum ValidCouplerMullions {

    DIVIDER(0),
    COUPLER(1),
    MULLION(2);

    public int value;
    
    ValidCouplerMullions(int value) {
        this.value = value;    
    }
    
    public int getValue() {
        return value;
    }
}

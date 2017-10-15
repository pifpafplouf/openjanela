package openjanela.app.configuration.controller;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 09-18-12
 * Time: 10:46 AM
 */
public enum SUTypeCustomOption {
    
    CUSTOM_YES(1),
    CUSTOM_NO(2);
    
    public int value;
    
    SUTypeCustomOption(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public String getDescription() {
        if (value == CUSTOM_YES.getValue()) 
            return "Custom Yes";
        else if (value == CUSTOM_NO.getValue())
            return "Custom No";
        else 
            return "";
    }
    
    public String toString() {
        return getDescription();
    }
}

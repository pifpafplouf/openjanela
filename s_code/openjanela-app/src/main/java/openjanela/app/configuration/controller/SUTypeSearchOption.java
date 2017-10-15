package openjanela.app.configuration.controller;

import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 09-17-12
 * Time: 10:57 PM
 */
public enum SUTypeSearchOption implements Serializable {

    SEARCH_OPTION (0), 
    FAMILY (1),
    THICKNESS (2),
    GLAZING_TYPE (3),  
    NUM_OF_LEAVES (4),
    DESCRIPTION (5),
    STOCKCODE (6),
    IS_CUSTOM (7);
  
    
    public int searchOption;
    
    SUTypeSearchOption(int searchOption) {
        this.searchOption = searchOption;    
    }
    
    public int getValue() {
        return searchOption;
    }
    
    public String getDescription() {
        if (searchOption == GLAZING_TYPE.getValue())
            return "Filter by Glazing Type";
        else if (searchOption == IS_CUSTOM.getValue())
            return "Filter Custom";
        else if (searchOption == NUM_OF_LEAVES.getValue())
            return "Filter by Number of Leaves";
        else if (searchOption == THICKNESS.getValue())
            return "Filter by Thickness";
        else if (searchOption == FAMILY.getValue())
            return "Filter by Family";
        else if (searchOption == DESCRIPTION.getValue())
            return "Filter by Description";
        else if (searchOption == STOCKCODE.getValue())
            return "Filter by Stockcode";
        else
            return "Show All";
    }
    
    public String toString() {
        return getDescription();
    }
}

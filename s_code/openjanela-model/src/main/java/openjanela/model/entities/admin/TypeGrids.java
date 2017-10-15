package openjanela.model.entities.admin;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 12/3/13
 *          Time: 4:26 PM
 */
public enum TypeGrids {

    NORMAL(1),
    PERIMETER(2),
    TDL(3),
    TDL_PERIMETER(4),
    SDL(5),
    SDL_PERIMETER(6),
    STUCK_ON(7),
    STUCK_ON_PERIMETER(8);

    private int value;

    TypeGrids(int value) {
        this.value = value;
    }

    /**
     * Return Value
     *
     * @return int
     */
    public int getValue() {
        return value;
    }
}

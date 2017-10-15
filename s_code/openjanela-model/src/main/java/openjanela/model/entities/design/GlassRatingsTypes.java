package openjanela.model.entities.design;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-13-13
 *          Time: 01:22 PM
 */
public enum GlassRatingsTypes {

    NFRC_U_FACTOR(1),
    NFRC_SHGC(2),
    NFRC_VT(3),
    NFRC_CR(7),
    NFRC_AL(4),
    NFRC_DP_(5),
    NFRC_DP(6),
    FL_CODE(100);

    private int value;

    GlassRatingsTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

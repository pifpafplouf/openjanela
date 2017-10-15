package openjanela.model.entities.design;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8 Date: 10-08-12 Time: 09:57 AM
 */
public enum OpeningClassTypes {

    ALL(0),
    PICTURE(1),
    OUT_SWING(2),
    IN_SWING(3),
    S_SLIDER(4),
    D_SLIDER(5),
    N_SLIDER(6),
    FOLDING(7),
    TRANSOM(8),
    SIDE_LIGHT(9),
    KICK_PANEL(10),
    POCKET(11),
    PIVOT(12),
    LOUVERED(13);

    private int value;

    /**
     * Opening Class Type Constructor
     *
     * @param value , key value
     */
    OpeningClassTypes(int value) {
        this.value = value;
    }

    /**
     * Return value constant
     *
     * @return int
     */
    public int getValue() {
        return value;
    }

    /**
     * Return Constant value description name
     *
     * @param value , key value
     * @return String
     */
    public String getValueName(int value) {
        if (PICTURE.getValue() == value) {
            return "Fixed/PW";
        } else if (OUT_SWING.getValue() == value) {
            return "OutSwing";
        } else if (IN_SWING.getValue() == value) {
            return "InSwing";
        } else if (S_SLIDER.getValue() == value) {
            return "1 Track Slider";
        } else if (D_SLIDER.getValue() == value) {
            return "2 Track Slider";
        } else if (FOLDING.getValue() == value) {
            return "Folding & Other Specials";
        } else if (TRANSOM.getValue() == value) {
            return "Transoms";
        } else if (SIDE_LIGHT.getValue() == value) {
            return "SideLights";
        } else if (KICK_PANEL.getValue() == value) {
            return "Kick Panel";
        } else if (POCKET.getValue() == value) {
            return "Pocket";
        } else if (PIVOT.getValue() == value) {
            return "Pivot";
        } else if (LOUVERED.getValue() == value) {
            return "Louvered";
        } else if (ALL.getValue() == value) {
            return "All";
        } else {
            return "";
        }
    }

    public String toString() {
        return getValueName(this.value);
    }
}

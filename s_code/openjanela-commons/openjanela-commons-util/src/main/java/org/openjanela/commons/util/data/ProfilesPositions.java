package org.openjanela.commons.util.data;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-23-13
 *          Time: 09:30 AM
 */
public class ProfilesPositions {

    /**
     * Return a  position description from his value
     *
     * @param value, Position value key
     * @return String
     */
    public static String getPosition(int value) {

        switch (value) {
            case 1:
                return "Top1";
            case 2:
                return "Top2";
            case 3:
                return "Top3";
            case 4:
                return "Right";
            case 5:
                return "Bot1";
            case 6:
                return "Bot3";
            case 7:
                return "Bot2";
            case 8:
                return "Left";
            case 11:
                return "Vert";
            case 12:
                return "Horz";
            case 13:
                return "Perimeter";
            case 18:
                return "L +";
            case 19:
                return "Cross +";
            case 20:
                return "Area";
            case 21:
                return "Vol";
            case 24:
                return "Corner";
            case 51:
                return "Sq/Lite";
            case 52:
                return "None";
            case 53:
                return "Width";
            case 54:
                return "Height";
            case 55:
                return "Depth";
            case 56:
                return "Unit";
            default:
                return "--";

        }
    }

    /**
     * Return a position abbreviation from his value
     *
     * @param value, Position value key
     * @return String
     */
    public static String getAbbrevPosition(int value) {
        switch (value) {
            case 1:
                return "T";
            case 2:
                return "T";
            case 3:
                return "T";
            case 4:
                return "R";
            case 5:
                return "B";
            case 6:
                return "B";
            case 7:
                return "B";
            case 8:
                return "L";
            case 11:
                return "V";
            case 12:
                return "H";
            case 13:
                return "P";
            case 18:
                return "L +";
            case 19:
                return "C +";
            case 20:
                return "A";
            case 21:
                return "Vol";
            case 24:
                return "Cor";
            case 51:
                return "Sq/Lite";
            case 52:
                return "None";
            case 53:
                return "Width";
            case 54:
                return "Height";
            case 55:
                return "Depth";
            case 56:
                return "Unit";
            default:
                return "--";

        }
    }
}

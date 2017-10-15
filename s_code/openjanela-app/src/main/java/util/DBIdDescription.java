package util;

/**
 * ****************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 * <p/>
 * Contributors:
 * Sherif El Dibani
 * *****************************************************************************
 */

public class DBIdDescription {
    public int intid;
    public String id;
    public String description;
    public boolean isIntField;

    public DBIdDescription(int newIntID, String newID, String newDescription,
                           boolean newIsIntField) {
        intid = newIntID;
        id = newID;
        description = newDescription;
        isIntField = newIsIntField;
    }

    public String toString() {
        return this.description;
    }

}

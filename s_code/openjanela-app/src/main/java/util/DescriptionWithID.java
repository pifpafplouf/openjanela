/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

public class DescriptionWithID {
    public DescriptionWithID() {
    }

    public void setID(int identifier) {
        this.id = identifier;
    }

    public int getID() {
        return id;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIDStr() {
        return idStr;
    }

    public void setIDStr(String idString) {
        this.idStr = idString;
    }

    public String toString() {
        return this.description;
    }

    private int id;
    private String idStr;
    private String description;
}

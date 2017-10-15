/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.io.*;

public class RulesCellObject
        implements Serializable {

    public RulesCellObject(int id, Object object) {
        this.id = id;
        objectCell = object;
    }

    public RulesCellObject(int id, String idString, Object object) {
        this.id = id;
        this.idString = idString;
        objectCell = object;
    }

    public String toString() {
        return objectCell.toString();
    }

    public int getID() {
        return id;
    }

    public String getVirtualIDString() {
        return idString;
    }

    int id;
    String idString;
    Object objectCell;
}

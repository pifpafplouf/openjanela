/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.sql.*;
import java.util.*;

public class SearchByGeneral {
    public int id;
    public String description;
    public int formodule;
    public int filedtype;
    public String populatefield;
    public String sqlstmt;
    public boolean wildcard;
    public boolean islike;
    public boolean isint;

    public SearchByGeneral() {
    }

    public String getsqlstmt() {
        return sqlstmt;
    }

    public int getID() {
        return id;
    }

    public String getpopulatefield() {
        return populatefield;
    }

    public int getfiledtype() {
        return filedtype;
    }

    public boolean getIsWild() {
        return wildcard;
    }

    public boolean getIsLike() {
        return islike;
    }

    public boolean getIsInt() {
        return isint;
    }

    public boolean equals(final Object obj) {

        if (obj != null && obj instanceof SearchByGeneral) {
            final SearchByGeneral result = (SearchByGeneral) obj;
            if (id == result.id) {
                return true;
            }
        }
        return false;
    }

}

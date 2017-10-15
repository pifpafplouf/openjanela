/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.sql.*;

public class ISSUtility {

    public ISSUtility() {
    }

    protected static int getID(Connection conn, String idFieldName,
                               String tableName, String descriptionFieldName,
                               String description) {
        Statement stmt = null;
        int id = 0;
        try {
            stmt = conn.createStatement();
            String query = String.valueOf(String.valueOf((new StringBuffer("SELECT ")).
                    append(idFieldName).append(" as id FROM ").append(tableName).append(
                    " WHERE ").append(descriptionFieldName).append("='").append(
                    description).append("'")));
            ResultSet rs;
            for (rs = stmt.executeQuery(query); rs.next(); ) {
                id = rs.getInt("id");

            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    protected static String getDescrption(Connection conn,
                                          String descriptionFieldName,
                                          String tableName, String idFieldName,
                                          int ID) {
        Statement stmt = null;
        String description = "";
        try {
            stmt = conn.createStatement();
            String query = String.valueOf(String.valueOf((new StringBuffer("SELECT ")).
                    append(descriptionFieldName).append(" as description From ").append(
                    tableName).append(" WHERE ").append(idFieldName).append("=").append(
                    ID)));
            ResultSet rs;
            for (rs = stmt.executeQuery(query); rs.next(); ) {
                description = rs.getString("description");

            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return description;
    }

//

}

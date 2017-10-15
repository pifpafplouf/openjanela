/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/

package util;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBConnection {

    public DBConnection() {
    }

    public static Connection getConnection(String dbDataSourceName) {
        Connection conn = null;
        try {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/".concat(dbDataSourceName));
            if (ds == null) {
                System.out.println(String.valueOf(String.valueOf((new StringBuffer(
                        "Data Source ")).append(dbDataSourceName).append(" not found"))));
            }
        } catch (Exception e) {
            System.out.println(String.valueOf(String.valueOf((new StringBuffer(
                    "Naming service exception at ")).append(dbDataSourceName).append(
                    " init: ").append(e.getMessage()))));
            e.printStackTrace();
        }
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    private static String dbUID = "root";
    private static String dbPWD = "root";
    private static DataSource ds = null;
    private static String dbDataSourceName = "ik_main";

}

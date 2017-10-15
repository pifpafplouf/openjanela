/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.io.*;
import java.sql.*;


public class Mysql {

    public Mysql(String sql) throws Exception {
        conn = null;
        stmt = null;
        prepstmt = null;
        dbName = "ik_main";
        try {
            if (conn == null) {
                conn = DBConnection.getConnection(dbName);
            }
            prepareStatement(sql);
        } catch (Exception e) {
            throw new Exception("Error".concat(String.valueOf(String.valueOf(e.
                    getMessage()))));
        }
    }

    public void prepareStatement(String sql) throws SQLException {
        prepstmt = conn.prepareStatement(sql);
    }

    public void setString(int index, String value) throws SQLException {
        prepstmt.setString(index, value);
    }

    public void setInt(int index, int value) throws SQLException {
        prepstmt.setInt(index, value);
    }

    public void setBoolean(int index, boolean value) throws SQLException {
        prepstmt.setBoolean(index, value);
    }

    public void setDate(int index, Date value) throws SQLException {
        prepstmt.setDate(index, value);
    }

    public void setDouble(int index, double value) throws SQLException {
        prepstmt.setDouble(index, value);
    }

    public void setLong(int index, long value) throws SQLException {
        prepstmt.setLong(index, value);
    }

    public void setTimestamp(int index, Timestamp value) throws SQLException {
        prepstmt.setTimestamp(index, value);
    }

    public void setFloat(int index, float value) throws SQLException {
        prepstmt.setFloat(index, value);
    }

    public void setBinaryStream(int index, ByteArrayInputStream in, int length) throws
            SQLException {
        prepstmt.setBinaryStream(index, in, length);
    }

    public void clearParameters() throws SQLException {
        prepstmt.clearParameters();
    }

    public PreparedStatement getPreparedStatement() {
        return prepstmt;
    }

    public Statement getStatement() {
        return stmt;
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public ResultSet executeQuery() throws SQLException {
        if (prepstmt != null) {
            return prepstmt.executeQuery();
        } else {
            return null;
        }
    }

    public void executeUpdate(String sql) throws SQLException {
        if (stmt != null) {
            stmt.executeUpdate(sql);
        }
    }

    public void executeUpdate() throws SQLException {
        if (prepstmt != null) {
            prepstmt.executeUpdate();
        }
    }

    public void close() throws Exception {
        if (stmt != null) {
            stmt.close();
            stmt = null;
        }
        if (prepstmt != null) {
            prepstmt.close();
            prepstmt = null;
        }
        if (conn != null) {
            conn.close();
        }
    }

    public boolean executeSQL(String sqlText) {
        boolean isOK = true;
        try {
            Statement stmt = conn.createStatement();
            while (sqlText != null) {
                stmt.executeUpdate(sqlText);
            }
            stmt.close();
        } catch (SQLException se) {
            System.out.println("SQLException occurred when execute SQL statement. ");
            System.out.println("  |--SQL statement: ".concat(String.valueOf(String.
                    valueOf(sqlText))));
            se.printStackTrace();
            isOK = false;
        }
        return isOK;
    }

    private static String retrieveSQLFromFile(LineNumberReader source) {
        return null;

    }

    private Connection conn;
    private Statement stmt;
    private PreparedStatement prepstmt;
    private String dbName;
}

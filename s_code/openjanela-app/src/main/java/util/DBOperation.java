/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;


// Referenced classes of package vsmequote.dao:
//			DBResultSet, DBConnection

public class DBOperation
        implements Serializable {

    public DBOperation() {
    }

    private static ArrayList getListResults(final Connection con, final String sql) {
        Statement statement = null;
        final ArrayList<DBResultSet> arrayList = new ArrayList();
        try {
            if (con != null) {
                statement = con.createStatement();
                final ResultSet resultset = statement.executeQuery(sql);
                final ResultSetMetaData resultsetmetadata = resultset.getMetaData();
                final int columnTypes[] = new int[resultsetmetadata.getColumnCount() + 1];
                final String columnNames[] = new String[columnTypes.length];
                for (int k = 1; k < columnTypes.length; k++) {
                    columnTypes[k] = resultsetmetadata.getColumnType(k);
                    columnNames[k] = resultsetmetadata.getColumnName(k);
                }

                resultset.beforeFirst();
                for (; resultset.next();
                     arrayList.add(new DBResultSet(resultset,
                             columnTypes.length, columnTypes, columnNames))) {
                    ;
                }
                resultset.close();
                statement.close();
            }
        } catch (final Exception e6) {
            ((Throwable) e6).printStackTrace();
        } finally {
        }
        return arrayList;
    }

    public static DBResultSet[] doQuery(final String dbSrcName, final String queryString) {
        try {
            final ArrayList dbRsList = getListResults(dbSrcName, queryString);
            if (dbRsList == null) {
                final DBResultSet adbresultset[] = new DBResultSet[0];
                return adbresultset;
            }
            final int i = dbRsList.size();
            final DBResultSet ajspdbresult[] = new DBResultSet[i];
            for (int j = 0; j < i; j++) {
                ajspdbresult[j] = (DBResultSet) dbRsList.get(j);
            }

            final DBResultSet adbresultset1[] = ajspdbresult;
            return adbresultset1;
        } catch (final Exception e3) {
            ((Throwable) e3).printStackTrace();
        }
        return new DBResultSet[0];
    }

    public static DBResultSet[] doQuery(final Connection conSeires, final String queryString) {
        try {
            final ArrayList dbRsList = getListResults(conSeires, queryString);
            if (dbRsList == null) {
                final DBResultSet adbresultset[] = new DBResultSet[0];
                final DBResultSet adbresultset2[] = adbresultset;
                return adbresultset2;
            }
            final int i = dbRsList.size();
            final DBResultSet ajspdbresult[] = new DBResultSet[i];
            for (int j = 0; j < i; j++) {
                ajspdbresult[j] = (DBResultSet) dbRsList.get(j);
            }

            final DBResultSet adbresultset1[] = ajspdbresult;
            final DBResultSet adbresultset3[] = adbresultset1;
            return adbresultset3;
        } catch (final Exception e3) {
            ((Throwable) e3).printStackTrace();
        }
        return new DBResultSet[0];
    }

    private static ArrayList getListResults(final String dbSrcName, final String sql) {
        Statement statement = null;
        final ArrayList<DBResultSet> arrayList = new ArrayList();
        Connection con = null;
        try {
            con = DBConnection.getConnection(dbSrcName);
            if (con != null) {
                statement = con.createStatement();
                final ResultSet resultset = statement.executeQuery(sql);
                final ResultSetMetaData resultsetmetadata = resultset.getMetaData();
                final int columnTypes[] = new int[resultsetmetadata.getColumnCount() + 1];
                final String columnNames[] = new String[columnTypes.length];
                for (int k = 1; k < columnTypes.length; k++) {
                    columnTypes[k] = resultsetmetadata.getColumnType(k);
                    columnNames[k] = resultsetmetadata.getColumnName(k);
                }

                resultset.beforeFirst();
                for (; resultset.next(); arrayList.add(new DBResultSet(resultset, columnTypes.length, columnTypes, columnNames))) {
                    ;
                }
                resultset.close();
                statement.close();
                con.close();
            }
        } catch (final Exception e6) {
            ((Throwable) e6).printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (final SQLException e) {
                    ((Throwable) e).printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static boolean doUpdate(final String dbSrcName, final String queryString) {
        boolean result = true;
        Statement stmt = null;
        Connection con = null;
        try {
            con = DBConnection.getConnection(dbSrcName);
            if (con != null) {
                stmt = con.createStatement();
                stmt.executeUpdate(queryString);
                stmt.close();
                con.close();
            }
        } catch (final Exception e) {
            ((Throwable) e).printStackTrace();
            result = false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (final SQLException e) {
                    ((Throwable) e).printStackTrace();
                }
            }
        }
        return result;
    }

    public static boolean doDelete(final String dbSrcName, final String queryString) {
        boolean result = true;
        Statement stmt = null;
        Connection con = null;
        try {
            con = DBConnection.getConnection(dbSrcName);
            if (con != null) {
                stmt = con.createStatement();
                stmt.execute(queryString);
                stmt.close();
                con.close();
            }
        } catch (final Exception e) {
            ((Throwable) e).printStackTrace();
            result = false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (final SQLException e) {
                    ((Throwable) e).printStackTrace();
                }
            }
        }
        return result;
    }

    public static boolean doUpdate(final Connection con, final String queryString) {
        boolean result = true;
        Statement stmt = null;
        try {
            if (con != null) {
                stmt = con.createStatement();
                stmt.execute(queryString);
                stmt.close();
            }
        } catch (final Exception e) {
            ((Throwable) e).printStackTrace();
            result = false;
        } finally {
        }
        return result;
    }

    public static boolean doDelete(final Connection con, final String queryString) {
        boolean result = true;
        Statement stmt = null;
        try {
            if (con != null) {
                stmt = con.createStatement();
                stmt.execute(queryString);
                stmt.close();
            }
        } catch (final Exception e) {
            ((Throwable) e).printStackTrace();
            result = false;
        } finally {
        }
        return result;
    }
}

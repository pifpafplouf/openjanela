/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.sql.*;
import java.text.*;
import java.util.*;

public class ISSUtility2 {

    private ISSUtility2() {
    }

    public static String findDBServer() {
        return "mysql";
    }

    public static String customerGroupIDPerCustomerID(final Connection con,
                                                      final String mainDB, final String customerid) {
        String groupID = "0";
        final DBResultSet custDBRs[] = DBOperation.doQuery(con,
                String.valueOf(String.
                        valueOf(new StringBuffer("select groups from ").append(mainDB).
                                append(".customers where customerid='").append(customerid).
                                append("'"))));
        for (int i = 0; i < custDBRs.length; i++) {
            groupID = custDBRs[i].getStringValue("groups");

        }
        return groupID;
    }

    public static DBResultSet[] getUserInfo(final Connection con, final String userid) {
        return DBOperation.doQuery(con,
                "select * from users where id=".concat(String.
                        valueOf(String.valueOf(userid))));
    }

    public static DBResultSet[] getJobType(final Connection con, final String mainDB) {
        return DBOperation.doQuery(con,
                String.valueOf(String.valueOf(new
                        StringBuffer("select * from ").append(mainDB).append(
                        ".jobtype order by description"))));
    }

    public static DBResultSet[] getPaymentTerms(final Connection con, final String mainDB) {
        return DBOperation.doQuery(con,
                String.valueOf(String.valueOf(new
                        StringBuffer("select * from ").append(mainDB).append(
                        ".paymentterms order by description"))));
    }

    public static DBResultSet[] getCountrys(final Connection con) {
        final String query = "select * from country order by country_name";
        return DBOperation.doQuery(con, query);
    }

    public static DBResultSet[] getStateOrProvincePerCountryID(final String countryid,
                                                               final Connection con) {
        final String query = String.valueOf(String.valueOf(new StringBuffer(
                "select * from stateorprovince where countryid=").append(countryid).
                append(" order by name")));
        return DBOperation.doQuery(con, query);
    }

    public static HashMap findCountry_statesMap(final Connection con) {
        final HashMap c_sMap = new HashMap();
        final DBResultSet c[] = getCountrys(con);
        for (int i = 0; i < c.length; i++) {
            c_sMap.put(c[i].getStringValue("id"),
                    getStateOrProvincePerCountryID(c[i].getStringValue("id"), con));

        }
        return c_sMap;
    }

    public static DBResultSet[] getSalesRep(final Connection con, final String mainDB) {
        return DBOperation.doQuery(con,
                String.valueOf(String.valueOf(new
                        StringBuffer("select * from ").append(mainDB).append(
                        ".salesreps order by firstname, lastname"))));
    }

    public static DBResultSet[] getTaxTable(final Connection con, final String mainDB) {
        return DBOperation.doQuery(con,
                String.valueOf(String.valueOf(new
                        StringBuffer("select * from ").append(mainDB).append(
                        ".taxtable order by taxid"))));
    }

    public static DBResultSet[] getOrderStatus(final Connection con, final String mainDB) {
        return DBOperation.doQuery(con,
                String.valueOf(String.valueOf(new
                        StringBuffer("select * from ").append(mainDB).append(
                        ".orderstatus order by orderstatusid"))));
    }

    public static DBResultSet[] getCustomersPerGroupID(final Connection con,
                                                       final String mainDB, final boolean isUserSales, final String salesRepID, final String groupID) {

        String sql = "";
        if (isUserSales) {
            sql = String.valueOf(String.valueOf(new StringBuffer("select * from ").
                    append(mainDB).append(
                    ".customers where salesrepid='").append(salesRepID).append(
                    "' and groups=").append(groupID).append(" order by companyname")));
        } else {
            sql = String.valueOf(String.valueOf(new StringBuffer("select * from ").
                    append(mainDB).append(
                    ".customers where groups=").append(groupID).append(
                    " order by companyname")));
        }
        final DBResultSet custDBRs[] = DBOperation.doQuery(con, sql);
        return custDBRs;
    }

    public static DBResultSet[] getProductionPriorityRest(final Connection con,
                                                          final String userworkingdealerdb) {

        return DBOperation.doQuery(con, "select * from productionpriority");
    }

    public static DBResultSet[] getCustomersPerCustomerID(final Connection con,
                                                          final String mainDB, final String customerid) {

        final String sql = String.valueOf(String.valueOf(new StringBuffer(
                "select * from ").append(mainDB).append(
                ".customers where customerid='").append(customerid).append("'")));
        final DBResultSet custDBRs[] = DBOperation.doQuery(con, sql);
        return custDBRs;
    }

    public static String getCustomerStatusPerCustomerID(final Connection con,
                                                        final String mainDB, final String customerid) {

        String customerStatus = "Normal";
        final DBResultSet custDBRs[] = getCustomersPerCustomerID(con, mainDB, customerid);
        for (int i = 0; i < custDBRs.length; i++) {
            customerStatus = custDBRs[i].getStringValue("customerstatus");

        }
        return customerStatus;
    }

    public static final DecimalFormat sixDecimal = new DecimalFormat("0.000000");
    public static final DecimalFormat fourDecimal = new DecimalFormat("0.0000");
    public static final DecimalFormat twoDecimal = new DecimalFormat("0.00");
    public static final DecimalFormat oneDecimal = new DecimalFormat("0.0");
    public static String dbLocation = "localhost";
    public static Connection conSeries = null;
    public static String seriesdbName = "seriesdb";
    public static HashMap<?, ?> image_Map = null;
//    NumberFormat nf
}

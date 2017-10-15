/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 *******************************************************************************/
package Data;


import java.sql.*;
import java.util.*;

import util.Mysql;

public class User {

    public int id;

    public int partnerID;

    public String loginname;

    public String password;

    public String email;

    public int usertype;

    public String mainDB;

    public int prefUOM = 1;

    public boolean viewcost;

    public boolean changeprice;

    public boolean changediscount;

    public boolean owncustomer;

    public int salesrepid;

    public boolean changestatus;

    public boolean importorder;

    public boolean importpo;

    public String connection;

    public int maxstatus;

    public boolean exportbyftp;

    public String fullname;

    public int dealerid;

    public boolean isloggedin;

    public int language;

    public int mDecimals = 1;

    public int impDecimal = 6;

    public String currentDB;

    public Mysql mysql;

    public User() {

    }

    public void setCurrentDB(final String currentDB) {

        this.currentDB = currentDB;
    }

    public String getCurrentDB() {

        return currentDB;
    }

    public boolean isChangediscount() {

        return changediscount;
    }

    public void setChangediscount(final boolean changediscount) {

        this.changediscount = changediscount;
    }

    public boolean isChangeprice() {

        return changeprice;
    }

    public void setChangeprice(final boolean changeprice) {

        this.changeprice = changeprice;
    }

    public boolean isChangestatus() {

        return changestatus;
    }

    public void setChangestatus(final boolean changestatus) {

        this.changestatus = changestatus;
    }

    public String getConnection() {

        return connection;
    }

    public void setConnection(final String connection) {

        this.connection = connection;
    }

    public String getmainDB() {

        return mainDB;
    }

    public void setmainDB(final String mainDB) {

        this.mainDB = mainDB;
    }

    public int getDefaultentryuom() {

        return prefUOM;
    }

    public void setDefaultentryuom(final int defaultentryuom) {

        prefUOM = defaultentryuom;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(final String email) {

        this.email = email;
    }

    public boolean isExportbyftp() {

        return exportbyftp;
    }

    public void setExportbyftp(final boolean exportbyftp) {

        this.exportbyftp = exportbyftp;
    }

    public String getFullname() {

        return fullname;
    }

    public void setFullname(final String fullname) {

        this.fullname = fullname;
    }

    public int getId() {

        return id;
    }

    public void setId(final int id) {

        this.id = id;
    }

    public boolean isImportorder() {

        return importorder;
    }

    public void setImportorder(final boolean importorder) {

        this.importorder = importorder;
    }

    public boolean isImportpo() {

        return importpo;
    }

    public void setImportpo(final boolean importpo) {

        this.importpo = importpo;
    }

    public String getLoginname() {

        return loginname;
    }

    public void setLoginname(final String loginname) {

        this.loginname = loginname;
    }

    public int getMaxstatus() {

        return maxstatus;
    }

    public void setMaxstatus(final int maxstatus) {

        this.maxstatus = maxstatus;
    }

    public boolean isOwncustomer() {

        return owncustomer;
    }

    public void setOwncustomer(final boolean owncustomer) {

        this.owncustomer = owncustomer;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(final String password) {

        this.password = password;
    }

    public int getSalesrepid() {

        return salesrepid;
    }

    public void setSalesrepid(final int salesrepid) {

        this.salesrepid = salesrepid;
    }

    public int getUsertype() {

        return usertype;
    }

    public void setUsertype(final int usertype) {

        this.usertype = usertype;
    }

    public boolean isViewcvost() {

        return viewcost;
    }

    public void setViewcost(final boolean viewcost) {

        this.viewcost = viewcost;
    }

    public int insert() throws Exception {

        try {
            final String insertsql =
                    "insert into erpiccolodb.users  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            final int maxid = maxID();
            mysql.prepareStatement(insertsql);
            mysql.setInt(1, maxid);
            mysql.setString(2, loginname);
            mysql.setString(3, password);
            mysql.setString(4, email);
            mysql.setInt(5, usertype);
            mysql.setString(6, mainDB);
            mysql.setInt(7, prefUOM);
            mysql.setBoolean(8, viewcost);
            mysql.setBoolean(9, changeprice);
            mysql.setBoolean(10, changediscount);
            mysql.setBoolean(11, owncustomer);
            mysql.setInt(12, salesrepid);
            mysql.setBoolean(13, changestatus);
            mysql.setBoolean(14, importorder);
            mysql.setBoolean(15, importpo);
            mysql.setString(16, connection);
            mysql.setInt(17, maxstatus);
            mysql.setBoolean(18, exportbyftp);
            mysql.setString(19, fullname);
            mysql.setInt(20, dealerid);

            mysql.executeUpdate();
        } catch (final Exception ex) {
            throw new Exception("Users.insert()".concat(String
                    .valueOf(String.valueOf(ex.getMessage()))));
        }
        return 0;
    }

    public void update() throws Exception {

        final String updatesql =
                "UPDATE erpiccolodb.users SET email= ?,password=? ,usertype=?, mainDB= ?, defaultentryuom= ?, viewcost= ?, changeprice= ?, changediscount= ?, owncustomer= ?, salesrepid= ?, changestatus= ?, importorder= ?, importpo= ?, connection= ?, maxstatus= ?, exportbyftp= ?, fullname= ?, dealerid=? WHERE id=?";
        try {
            mysql.prepareStatement(updatesql);
            mysql.setString(1, email);
            mysql.setString(2, password);
            mysql.setInt(3, usertype);
            mysql.setString(4, mainDB);
            mysql.setInt(5, prefUOM);
            mysql.setBoolean(6, viewcost);
            mysql.setBoolean(7, changeprice);
            mysql.setBoolean(8, changediscount);
            mysql.setBoolean(9, owncustomer);
            mysql.setInt(10, salesrepid);
            mysql.setBoolean(11, changestatus);
            mysql.setBoolean(12, importorder);
            mysql.setBoolean(13, importpo);
            mysql.setString(14, connection);
            mysql.setInt(15, maxstatus);
            mysql.setBoolean(16, exportbyftp);
            mysql.setString(17, fullname);
            mysql.setInt(18, id);
            mysql.executeUpdate();
        } catch (final Exception ex) {
            throw new Exception("Users.update()".concat(String
                    .valueOf(String.valueOf(ex.getMessage()))));
        }
    }





    public ResultSet select(final String selectsql) throws Exception {

        try {
            final ResultSet rs = mysql.executeQuery(selectsql);
            final ResultSet resultset = rs;
            return resultset;
        } catch (final Exception ex) {
            throw new Exception("Users.select()".concat(String
                    .valueOf(String.valueOf(ex.getMessage()))));
        }
    }

    public void Delete() throws Exception {

        final String deletesql =
                "delete from erpiccolodb.users where  id=?";
        try {
            mysql.prepareStatement(deletesql);
            mysql.setInt(1, id);
            mysql.executeUpdate();
        } catch (final Exception ex) {
            throw new Exception("users.delete()".concat(String
                    .valueOf(String.valueOf(ex.getMessage()))));
        }
    }

    public int maxID() {

        int max = 0;
        try {
            final ResultSet rst =
                    mysql
                            .executeQuery("select MAX(id) from erpiccolodb.users");
            if (rst.next()) {
                max = rst.getInt(1);
            }
            rst.close();
        } catch (final Exception ex) {
            ex.getMessage();
        }
        return max;
    }

    public boolean Duplicate() {

        boolean dup = false;
        try {
            final String dupsql =
                    String
                            .valueOf(String
                                    .valueOf(new StringBuffer(
                                            "select * from erpiccolodb.users where logginname='")
                                            .append(loginname.trim())
                                            .append("';")));
            final ResultSet rs = mysql.executeQuery(dupsql);
            if (rs.next()) {
                dup = true;
            }
            rs.close();
        } catch (final Exception ex) {
            ex.getMessage();
        }
        return dup;
    }

    public void close() throws Exception {

        if (mysql != null) {
            mysql.close();
        }
    }

}

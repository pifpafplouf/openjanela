/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.sql.*;

public class ConnectionWrapper {

    public ConnectionWrapper(Connection conn, String url, String uid, String pwd,
                             int connType) {
        this.conn = null;
        this.url = null;
        this.uid = null;
        this.pwd = null;
        this.connType = -1;
        this.conn = conn;
        this.url = url;
        this.uid = uid;
        this.pwd = pwd;
        this.connType = connType;
    }

    protected Connection conn;
    protected String url;
    protected String uid;
    protected String pwd;
    protected int connType;
    public static final int CONN_TYPE_DEALER = 0;
    public static final int CONN_TYPE_SERIES = 1;

}

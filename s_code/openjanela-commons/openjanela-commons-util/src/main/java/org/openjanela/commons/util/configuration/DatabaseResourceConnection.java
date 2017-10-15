package org.openjanela.commons.util.configuration;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Copyright (c) 2011-2013, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 03-04-13
 * Time: 10:15 AM
 */
public class DatabaseResourceConnection {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(DatabaseResourceConnection.class);

    //Databases server access
    public static final int MYSQL_DB = 1;
    public static final int POSTGREE_DB = 2;
    public static final int ORACLE_DB = 3;
    public static final int SQLSERVER_DB = 4;

    public static final int LOCAL_CONNECTION = 1;
    public static final int REMOTE_CONNECTION = 2;

    //Configuration properties options
    public static final String RESOURCEJAR = "RESOURCEJAR";
    public static final String DRIVER = "DRIVER";
    public static final String URLCONNECTION = "URL";
    public static final String CONNECTION = "CONNECTION";
    public static final String LOCALHOST = "LOCALHOST";
    public static final String LOCALPORT = "LOCALPORT";
    public static final String LOCALUSER = "LOCALUSER";
    public static final String LOCALPASSWORD = "LOCALPASSWORD";
    public static final String LOCALDBOPENJANELA = "LOCALDBOPENJANELA";
    public static final String LOCALDBOPENJANELAPARTNER = "LOCALDBOPENJANELAPARTNER";
    public static final String REMOTEHOST = "REMOTEHOST";
    public static final String REMOTEPORT = "REMOTEPORT";
    public static final String REMOTEUSER = "REMOTEUSER";
    public static final String REMOTEPASSWORD = "REMOTEPASSWORD";
    public static final String REMOTEDBOPENJANELA = "REMOTEDBOPENJANELA";
    public static final String REMOTEDBOPENJANELAPARTNER = "REMOTEDBOPENJANELAPARTNER";

    /**
     * This method load properties connection file from absolut path
     *
     * @throws IOException, Exception if file is not found
     */
    public static Properties loadPropertiesConnectionFile() throws IOException {

        //Search persistence file properties
        File persistenceFile = new File(getAbsolutePathPersistenceFile() + "/persistence.properties");

        if (!persistenceFile.exists()) {
            persistenceFile.createNewFile();
        }

        Properties connProp = new Properties();
        connProp.load(new FileInputStream(persistenceFile));

        return connProp;
    }

    /**
     * This mehod return an absoluthe path for persistence file
     *
     * @return String
     */
    public static String getAbsolutePathPersistenceFile() {
        String userHome = System.getProperty("user.home");
        String appConfigHome = userHome + "/.openjanela";

        File dirHome = new File(appConfigHome);

        if (!dirHome.exists()) {
            dirHome.mkdir();
        }

        return appConfigHome;
    }

    /**
     * Return Driver Class for Database Server
     *
     * @param serverDB, Database Server
     * @return String
     */
    public static String getDriverClass(int serverDB) {

        String driverClass;

        switch (serverDB) {

            case MYSQL_DB:
                driverClass = "com.mysql.jdbc.Driver";
                break;
            case POSTGREE_DB:
                driverClass = "";
                break;
            case ORACLE_DB:
                driverClass = "";
                break;
            case SQLSERVER_DB:
                driverClass = "";
                break;
            default:
                driverClass = "";
                break;
        }

        return driverClass;
    }

    /**
     * Return Url Connection for Database Server
     *
     * @param serverDB, Database Server url connection
     * @return String
     */
    public static String getUrlConnectionDB(int serverDB) {

        String url;

        switch (serverDB) {

            case MYSQL_DB:
                url = "jdbc:mysql://";
                break;
            case POSTGREE_DB:
                url = "jdbc:postgresql://";
                break;
            case ORACLE_DB:
                url = "jdbc:oracle:thin:@//";
                break;
            case SQLSERVER_DB:
                url = "jdbc:sqlserver://";
                break;
            default:
                url = "";
                break;
        }

        return url;
    }
}

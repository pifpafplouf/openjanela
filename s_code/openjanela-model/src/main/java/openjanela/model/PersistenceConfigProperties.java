package openjanela.model;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 11-06-12
 *          Time: 12:36 PM
 */
public class PersistenceConfigProperties {

    //Constant variables
    public static final String HIBERNATE_CONNECTION_DRIVER = "com.mysql.jdbc.Driver";
    public static final String HIBERNATE_DIALECT = "org.hibernate.dialect.MySQLMyISAMDialect";

    //Instance static class persistence config
    private static PersistenceConfigProperties instance;

    //******************************************************************
    //Tenant 1 Schema
    //******************************************************************
    private String tenant_1_server;
    private long tenant_1_port;
    private String tenant_1_schema;
    private String tenant_1_login;
    private String tenant_1_password;

    //******************************************************************
    //Tenant 2 Schema
    //******************************************************************
    private String tenant_2_server;
    private long tenant_2_port;
    private String tenant_2_schema;
    private String tenant_2_login;
    private String tenant_2_password;

    //******************************************************************
    //Tenant 2 Schema
    //******************************************************************
    private String tenant_3_server;
    private long tenant_3_port;
    private String tenant_3_schema;
    private String tenant_3_login;
    private String tenant_3_password;

    //******************************************************************
    //Getters & Setters
    //******************************************************************

    public String getTenant_1_server() {
        return tenant_1_server;
    }

    public void setTenant_1_server(String tenant_1_server) {
        this.tenant_1_server = tenant_1_server;
    }

    public long getTenant_1_port() {
        return tenant_1_port;
    }

    public void setTenant_1_port(long tenant_1_port) {
        this.tenant_1_port = tenant_1_port;
    }

    public String getTenant_1_schema() {
        return tenant_1_schema;
    }

    public void setTenant_1_schema(String tenant_1_schema) {
        this.tenant_1_schema = tenant_1_schema;
    }

    public String getTenant_1_login() {
        return tenant_1_login;
    }

    public void setTenant_1_login(String tenant_1_login) {
        this.tenant_1_login = tenant_1_login;
    }

    public String getTenant_1_password() {
        return tenant_1_password;
    }

    public void setTenant_1_password(String tenant_1_password) {
        this.tenant_1_password = tenant_1_password;
    }

    public String getTenant_2_server() {
        return tenant_2_server;
    }

    public void setTenant_2_server(String tenant_2_server) {
        this.tenant_2_server = tenant_2_server;
    }

    public long getTenant_2_port() {
        return tenant_2_port;
    }

    public void setTenant_2_port(long tenant_2_port) {
        this.tenant_2_port = tenant_2_port;
    }

    public String getTenant_2_schema() {
        return tenant_2_schema;
    }

    public void setTenant_2_schema(String tenant_2_schema) {
        this.tenant_2_schema = tenant_2_schema;
    }

    public String getTenant_2_login() {
        return tenant_2_login;
    }

    public void setTenant_2_login(String tenant_2_login) {
        this.tenant_2_login = tenant_2_login;
    }

    public String getTenant_2_password() {
        return tenant_2_password;
    }

    public void setTenant_2_password(String tenant_2_password) {
        this.tenant_2_password = tenant_2_password;
    }

    public String getTenant_3_server() {
        return tenant_3_server;
    }

    public void setTenant_3_server(String tenant_3_server) {
        this.tenant_3_server = tenant_3_server;
    }

    public long getTenant_3_port() {
        return tenant_3_port;
    }

    public void setTenant_3_port(long tenant_3_port) {
        this.tenant_3_port = tenant_3_port;
    }

    public String getTenant_3_schema() {
        return tenant_3_schema;
    }

    public void setTenant_3_schema(String tenant_3_schema) {
        this.tenant_3_schema = tenant_3_schema;
    }

    public String getTenant_3_login() {
        return tenant_3_login;
    }

    public void setTenant_3_login(String tenant_3_login) {
        this.tenant_3_login = tenant_3_login;
    }

    public String getTenant_3_password() {
        return tenant_3_password;
    }

    public void setTenant_3_password(String tenant_3_password) {
        this.tenant_3_password = tenant_3_password;
    }

    //******************************************************************
    //UTILITY METHODS
    //******************************************************************

    /**
     * Return Persistence Config Properties instance
     *
     * @return PeristeceConfigProperties
     */
    public static PersistenceConfigProperties getInstance() {
        if (instance == null)
            instance = new PersistenceConfigProperties();

        return instance;
    }

    //******************************************************************
    //UTILITY METHODS
    //******************************************************************

    /**
     * Return connection URL
     *
     * @return String
     */
    public String getURLConnectionTenant_1() {
        StringBuffer url = new StringBuffer("jdbc:mysql://");
        url.append(tenant_1_server + ":");
        url.append(tenant_1_port);
        url.append("/" + tenant_1_schema);
        //url.append("?useCompression=true");

        return url.toString();
    }

    /**
     * Return connection URL
     *
     * @return String
     */
    public String getURLConnectionTenant_2() {
        StringBuffer url = new StringBuffer("jdbc:mysql://");
        url.append(tenant_2_server + ":");
        url.append(tenant_2_port);
        url.append("/" + tenant_2_schema);
        //url.append("?useCompression=true");

        return url.toString();
    }

    /**
     * Return connection URL
     *
     * @return String
     */
    public String getURLConnectionTenant_3() {
        StringBuffer url = new StringBuffer("jdbc:mysql://");
        url.append(tenant_3_server + ":");
        url.append(tenant_3_port);
        url.append("/" + tenant_3_schema);
        //url.append("?useCompression=true");

        return url.toString();
    }
}

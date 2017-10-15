package openjanela.model;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 11-06-12
 * Time: 12:41 PM
 * Represents configuration options for hibernate database connectivity
 */
public enum HibernateProperties {

    HIBERNATE_PROPERTY_CONNECTION_DRIVER_CLASS("hibernate.connection.driver_class"), //A full qualified classname org.hibernate.dialect.Dialect
    HIBERNATE_PROPERTY_CONNECTION_URL("hibernate.connection.url"), //
    HIBERNATE_PROPERTY_CONNECTION_USERNAME("hibernate.connection.username"),
    HIBERNATE_PROPERTY_CONNECTION_PASSWORD("hibernate.connection.password"),
    HIBERNATE_PROPERTY_DIALECT("hibernate.dialect"),
    HIBERNATE_PROPERTY_SHOW_SQL("hibernate.show_sql"), //true or false. Write all SQL Statements to the console.
    HIBERNATE_PROPERTY_FORMAT_SQL("hibernate.format_sql"), //true or false. Pretty-print the SQL in the log and console.
    HIBERNATE_PROPERTY_DEFAULT_SCHEMA("hibernate.default_schema"), //schema name. Qualify unqualified table names with the given schema or tablespace.
    HIBERNATE_PROPERTY_DEFAULT_CATALOG("hibernate.default_catalog"), //catalog name. Qualifies unqualified table names with the given catalog.
    HIBERNATE_PROPERTY_SESSION_FACTORY_NAME("hibernate.session_factory_name"), //a JNDI name
    HIBERNATE_PROPERTY_MAX_FETCH_DEPTH("hibernate.max_fetch_depth"), //A value between 0 and 3
    HIBERNATE_PROPERTY_DEFAULT_BATCH_FETCH_SIZE("hibernate.default_batch_fetch_size"), //4, 8 or 16
    HIBERNATE_PROPERTY_DEFAULT_ENTITY_MODE("hibernate.default_entity_mode"), //dynamic-map pojo
    HIBERNATE_PROPERTY_ORDER_UPDATES("hibernate.order_updates"), //true or false
    HIBERNATE_PROPERTY_GENERATE_STATISTICS("hibernate.generate_statistics"), //true or false
    HIBERNATE_PROPERTY_USE_IDENTIFIER_ROLLBACK("hibernate.use_identifier_rollback"), //true or false
    HIBERNATE_PROPERTY_USE_SQL_COMMENTS("hibernate.use_sql_comments"), //true or false
    HIBERNATE_PROPERTY_JDBC_FETCH_SIZE("hibernate.jdbc.fetch_size"),
    HIBERNATE_PROPERTY_JDBC_BATCH_SIZE("hibernate.jdbc.batch_size"),
    HIBERNATE_PROPERTY_JDBC_BATCH_VERSIONED_DATA("hibernate.jdbc.batch_versioned_data"),
    HIBERNATE_PROPERTY_JDBC_FACTORY_CLASS("hibernate.jdbc.factory_class"),
    HIBERNATE_PROPERTY_JDBC_USE_SCROLLABLE_RESULTSET("hibernate.jdbc.use_scrollable_resultset"),
    HIBERNATE_PROPERTY_JDBC_USE_STREAMS_FOR_BINARY("hibernate.jdbc.use_streams_for_binary"),
    HIBERNATE_PROPERTY_JDBC_USE_GET_GENERATED_KEYS("hibernate.jdbc.use_get_generated_keys"),
    HIBERNATE_PROPERTY_CONNECTION_POOL_SIZE("hibernate.connection.pool_size"),
    HIBERNATE_PROPERTY_HBM2DDL_AUTO("hibernate.hbm2ddl.auto"),
    HIBERNATE_PROPERTY_CONNECTION_PROVIDER_CLASS("hibernate.connection.provider_class"),
    HIBERNATE_PROPERTY_C3P0_ACQUIRE_INCREMENT("hibernate.c3p0.acquire.increment"),
    HIBERNATE_PROPERTY_C3P0_MIN_SIZE("hibernate.c3p0.min_size"),
    HIBERNATE_PROPERTY_C3P0_MAX_SIZE("hibernate.c3p0.max_size"),
    HIBERNATE_PROPERTY_C3P0_TIMEOUT("hibernate.c3p0.timeout"),
    HIBERNATE_PROPERTY_C3P0_ACQUIRE_RETRY_ATTEMPS("hibernate.c3p0.acquireRetryAttempts"),
    HIBERNATE_PROPERTY_C3P0_ACQUIRE_RETRY_DELAY("hibernate.c3p0.acquireRetryDelay"),
    HIBERNATE_PROPERTY_C3P0_MAX_STATEMENTS("hibernate.c3p0.max_statements"),
    HIBERNATE_PROPERTY_C3P0_MAX_IDLE_TIME("hibernate.c3po.maxIdleTime"),
    HIBERNATE_PROPERTY_C3P0_IDLE_TEST_PERIOD("hibernate.c3p0.idle_test_period"),
    HIBERNATE_PROPERTY_C3P0_MAX_IDLE_TIME_EXCESS_CONNECTION("hibernate.c3po.maxIdleTime.maxIdleTimeExcessConnections"),
    HIBERNATE_PROPERTY_C3P0_NUM_HELPED_THEADS("hibernate.c3po.numHelperThreads"),
    HIBERNATE_UNRETURNED_CONNECTION_TIMEOUT("hibernate.c3p0.unreturnedConnectionTimeout"),
    HIBERNATE_DEBUG_UNRETURNED_CONNECTION_STACKTRACE("hibernate.c3p0.debugUnreturnedConnectionStackTraces");

    
    private String value;
    
    HibernateProperties(String value) {
        this.value = value;    
    }

    public String getValue() {
        return value;
    }
}

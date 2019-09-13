package com.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface DbPoolConfigFactory {

    public static String AUTO_COMMIT = "true";
    public static String INITIAL_SIZE = "10";
    public static String MAX_IDLE = "5";
    public static String MIN_IDLE = "1";
    public static String MAX_SIZE = "20";
    public static String MIN_SIZE = "20";
    public static String BATCH_SIZE = "20";
    public static String MAX_WAIT_MILLIS = "20000";
    public static String DRIVER_CLASS_NAME = "driverClassName";
    public static String CONNECTION_FACTORY = "com.database.DriverConnectionFactory";
    public static String EXCEPTION_HANDLER = "com.database.SQLExceptionHandler";
    public static String MIN_EVICTABLE_IDLE_TIME_MILLIS = "10000";
    public static String QUERY_TIMEOUT_SECS = "10000";
    public static String READ_ONLY = "false";
    public static String SOFT_MIN_EVICTABLE_IDLE_TIME_MILLIS = "10000";
    public static String STATEMENT_POOL_SIZE = "10";
    public static String TEST_ON_BORROW = "false";
    public static String TEST_ON_RETURN = "false";
    public static String TEST_WHILE_IDLE = "false";

    public static String TEST_PER_EVICTION_RUN = "2";


    public DbPoolConfig getDefaultPool();
    public DbPoolConfig getPool(String poolName);
    public List<String> getAllPoolNames();

    public static class Factory
    {
        private static final Logger LOG = LoggerFactory.getLogger(DbPoolConfigFactory.class);
        public static DbPoolConfigFactory INSTANCE = getDbPoolConfigFactory();

        public static DbPoolConfigFactory getDbPoolConfigFactory()
        {
            LOG.info("Starting the DbPoolConfig Factory to start the db service");
            try
            {
                String factoryClassName = System.getProperty("dbconfig.factory", DbPropertiesConfigFactory.class.getName());
                return (DbPoolConfigFactory) Class.forName(factoryClassName).newInstance();
            }
            catch (Exception ex)
            {
                LOG.error("loadInstance(): Error loading DbPoolConfigFactory. Defaulting to {}", DbPropertiesConfigFactory.class.getName(), ex);
                return new DbPropertiesConfigFactory();
            }
        }
    }
}

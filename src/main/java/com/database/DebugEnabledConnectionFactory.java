package com.database;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDriver;
import org.apache.commons.pool.KeyedObjectPoolFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DebugEnabledConnectionFactory extends PoolableConnectionFactory {

    public DebugEnabledConnectionFactory(
            ConnectionFactory connectionFactory,
            GenericObjectPool pool,
            KeyedObjectPoolFactory statementPool,
            String validationQuery,
            int validationQueryInSec,
            boolean isReadOnly,
            boolean isAutoCommit)
    {
        super(connectionFactory, pool, statementPool, validationQuery, validationQueryInSec, isReadOnly, isAutoCommit);
        registerDriver((DriverConnectionFactory) connectionFactory, pool);
    }

    private void registerDriver(DriverConnectionFactory factory, GenericObjectPool pool)
    {
        try {
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
            driver.registerPool(factory.getPoolConfig().getPoolName(), pool);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

package com.priyo.registration.util;

/**
 * Created by mithunshawon on 11/13/14.
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnectionPool {
    private static DataSource dataSource;
    private static final String DRIVER_NAME;
    private static final String URL;
    private static final String USER_NAME;
    private static final String PASSWORD;

    static {
        final ResourceBundle config = ResourceBundle.getBundle("db");
        DRIVER_NAME = config.getString("jdbc.driver");
        URL = config.getString("jdbc.url.address");
        USER_NAME = config.getString("db.user");
        PASSWORD = config.getString("db.password");
        try {
            dataSource = setupDataSource();
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    private static DataSource setupDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(DRIVER_NAME);
        comboPooledDataSource.setJdbcUrl(URL);
        comboPooledDataSource.setUser(USER_NAME);
        comboPooledDataSource.setPassword(PASSWORD);
        comboPooledDataSource.setMinPoolSize(5);
        comboPooledDataSource.setAcquireIncrement(5);
        comboPooledDataSource.setMaxPoolSize(400);
        return comboPooledDataSource;
    }
}
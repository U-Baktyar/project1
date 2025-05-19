package org.example.utils.data.impl;

import org.example.utils.data.DBConnection;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionPSQL implements DBConnection {
    private static DBConnectionPSQL instance;
    private Properties properties;

    public static DBConnectionPSQL getInstance() {
        if (instance == null) {
            synchronized (DBConnectionPSQL.class) {
                if (instance == null) {
                    instance = new DBConnectionPSQL();
                    instance.getProperties();
                }
            }
        }
        return instance;
    }

    private DBConnectionPSQL() {};

    private void getProperties() {
        properties = new Properties();
        try(InputStream inputStream = DBConnectionPSQL.class.getClassLoader().getResourceAsStream("jdbc.properties")){
            if (inputStream == null) {
                throw new RuntimeException("Файл jdbc.properties не найден в classpath");
            }
            properties.load(inputStream);
        }catch (IOException e){
            throw new RuntimeException("Ошибка загрузки конфигурации: " + e.getMessage(), e);
        }
    }

    @Override
    public Connection getConnect() {
        if (properties == null) {
            throw new IllegalStateException("Свойства не инициализированы.");

        }
        String driver = properties.getProperty("db.url");
        String username = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        try{
            Connection connection = DriverManager.getConnection(driver, username, password);
            if (connection != null) {
                return connection;
            }
        }catch (SQLException e){
            System.err.println("Ошибка подключения к БД: " + e.getMessage());
        }
        return null;
    }
}

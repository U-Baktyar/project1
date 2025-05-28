package org.example.utils.data.impl;

import org.example.utils.data.DBConnection;
import org.example.utils.data.DBInitializer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class DBInitializePSQL implements DBInitializer {

    private static DBInitializer instance;

    public static DBInitializer getInstance() {
        if (instance == null) {
            synchronized (DBInitializer.class) {
                if (instance == null) {
                    instance = new DBInitializePSQL(DBConnectionPSQL.getInstance());
                }
            }
        }
        return instance;
    }
    private final DBConnection dbConnection;
    private DBInitializePSQL(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }


    public String getPSQLQuery(String fileURL) {
        StringBuilder psql = new StringBuilder();
        Path path = Paths.get(fileURL);
        try {
            List<String> lines = Files.readAllLines(path);
            psql.append(String.join("\n", lines));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return psql.toString();
    }

    @Override
    public void initialize() {
        String psqlQuery = getPSQLQuery("src/main/resources/psql.txt");
        try(Connection connection = dbConnection.getConnect();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(psqlQuery);
            System.out.println("создание таблиц прошло успешно");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



}

package com.entregafinalspring.entregafinal.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class H2Connection {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASS = "";

    private static final String CREATE_DENTISTS = "CREATE TABLE IF NOT EXISTS dentists (id INT PRIMARY KEY, name VARCHAR(255), lastname VARCHAR(255), registration VARCHAR(255))";

    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void createTables() {
        try {
            Connection connection = getConnection();
            connection.createStatement().execute(CREATE_DENTISTS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

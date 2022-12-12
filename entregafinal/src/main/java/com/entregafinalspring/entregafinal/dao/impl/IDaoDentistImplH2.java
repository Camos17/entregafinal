package com.entregafinalspring.entregafinal.dao.impl;

import com.entregafinalspring.entregafinal.dao.IDaoDentist;
import com.entregafinalspring.entregafinal.models.Dentist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IDaoDentistImplH2 implements IDaoDentist {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
//    private final static String DB_URL = "jdbc:h2:~/h2-database-dental-clinic;";

    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/h2-database-dental-clinic;";

    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "";


    private final static String CREATE_DENTIST = "CREATE TABLE IF NOT EXISTS dentist" +
            " (id int auto_increment primary key, name varchar(255), lastname varchar(255), registration int)";
    private final static String INSERT_DENTIST_DATA = "INSERT INTO dentist (id, name, lastname, registration) VALUES(?, ?, ?, ?)";

    @Override
    public void saveDentist(Dentist dentist) throws SQLException {

        Connection connection = null;
        DriverManager driverManager = null;
        PreparedStatement psCreate = null;
        PreparedStatement psInsert = null;


        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = driverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            psCreate = connection.prepareStatement(CREATE_DENTIST);
            psCreate.execute();

            connection.setAutoCommit(false);

            psInsert = connection.prepareStatement(INSERT_DENTIST_DATA);
            psInsert.setInt(1, dentist.getId());
            psInsert.setString(2, dentist.getName());
            psInsert.setString(3, dentist.getLastname());
            psInsert.setString(4, dentist.getRegistration());

            psInsert.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);


        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }



    }

    @Override
    public Dentist getDentist(int id) {
        return null;
    }

}

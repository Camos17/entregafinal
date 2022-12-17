package com.entregafinalspring.entregafinal.servicesNew.impl;

import com.entregafinalspring.entregafinal.dao.impl.DentistDaoImplH2;
import com.entregafinalspring.entregafinal.entity.Dentist;
import com.entregafinalspring.entregafinal.servicesNew.DentistService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class DentistServiceImpl implements DentistService {

    final static Logger logger = Logger.getLogger(DentistDaoImplH2.class);

    // CONSTANTES PARA CONEXION BD
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/h2-database-dental-clinic";

//    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/h2-database-dental-clinic;";

    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "";


    // CONSTANTES PARA MANIPULACION BD
    private final static String CREATE_DENTIST = "CREATE TABLE IF NOT EXISTS dentists" +
            " (id int auto_increment primary key, name varchar(255), lastname varchar(255), registration int)";
    private final static String INSERT_DENTIST_DATA = "INSERT INTO DENTISTS (id, name, lastname, registration) VALUES(?, ?, ?, ?)";
    private final static String SELECT_DENTIST_DATA = "SELECT id, name, lastname, registration FROM DENTISTS WHERE id = ?";

    private final static String SELECT_ALL_DENTISTS = "SELECT * FROM DENTISTS";

    private final static String UPDATE_DENTIST = "UPDATE DENTISTS SET name = ?, lastname = ?, registration = ? WHERE id  = ?";

    private final static String DELETE_DENTIST = "DELETE FROM DENTISTS WHERE id = ?";

    @Override
    public void createDentist(Dentist dentist) throws SQLException {
        logger.debug("Guardando un nuevo odontologo -1");
        Connection connection = null;
        DriverManager driverManager = null;
        PreparedStatement psCreate;
        PreparedStatement psInsert;


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
            logger.error(exception);
        } finally {
            connection.close();
        }
    }

}

package com.entregafinalspring.entregafinal.services.impl;

import com.entregafinalspring.entregafinal.dto.DentistDTO;
import com.entregafinalspring.entregafinal.entity.Dentist;
import com.entregafinalspring.entregafinal.services.DentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService {

    final static Logger logger = Logger.getLogger(DentistServiceImpl.class);

    // CONSTANTES PARA CONEXION BD
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
//    private final static String DB_URL = "jdbc:h2:~/h2-database-dental-clinic";

    private final static String DB_URL = "jdbc:h2:~/h2-database-dental-clinic;INIT=RUNSCRIPT FROM 'classpath:create.sql'";

//    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/h2-database-dental-clinic;";

    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "";


    // CONSTANTES PARA MANIPULACION BD
//    private final static String CREATE_DENTIST = "CREATE TABLE IF NOT EXISTS dentists" +
//            " (id int auto_increment primary key, name varchar(255), lastname varchar(255), registration int)";
    private final static String INSERT_DENTIST_DATA = "INSERT INTO DENTISTS (name, lastname, registration) VALUES(?, ?, ?)";
    private final static String SELECT_DENTIST_DATA = "SELECT id, name, lastname, registration FROM DENTISTS WHERE id = ?";

    private final static String SELECT_ALL_DENTISTS = "SELECT * FROM DENTISTS";

    private final static String UPDATE_DENTIST = "UPDATE DENTISTS SET name = ?, lastname = ?, registration = ? WHERE id  = ?";

    private final static String DELETE_DENTIST = "DELETE FROM DENTISTS WHERE id = ?";

    @Override
    public Optional<DentistDTO> createDentist(Dentist dentist) throws SQLException {
        logger.debug("Guardando un nuevo odontologo -1");
        Connection connection = null;
        DriverManager driverManager = null;
        PreparedStatement psInsert;
        Optional<DentistDTO> dentistDTO = null;

        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = driverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            connection.setAutoCommit(false);

            psInsert = connection.prepareStatement(INSERT_DENTIST_DATA);
            psInsert.setString(1, dentist.getName());
            psInsert.setString(2, dentist.getLastname());
            psInsert.setString(3, dentist.getRegistration());

            psInsert.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);

            // El objeto con el metodo para mapear
            ObjectMapper objectMapper = new ObjectMapper();

            // El objeto contenedor que va a tener el resultado del mapeo y le mapeo ya realizado
            dentistDTO = Optional.of(objectMapper.convertValue(dentist, DentistDTO.class));


        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error(exception);
        } finally {
            connection.close();
        }
        return dentistDTO;
    }

    @Override
    public Optional<DentistDTO> searchDentist(int id) {
        logger.debug("buscando el odontologo con id= " + id);
        Connection connection = null;
        PreparedStatement preparedStatement;
        Dentist dentist = null;
        Optional<DentistDTO> dentistDTO = null;

        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement(SELECT_DENTIST_DATA);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                int dentistId = rs.getInt("id");
                String dentistName = rs.getString("name");
                String dentistLastname = rs.getString("lastname");
                String registration = rs.getString("registration");

                // El objeto con el metodo para mapear
                ObjectMapper objectMapper = new ObjectMapper();

                // El objeto (entidad) que necesito mapear
                dentist = new Dentist(dentistId, dentistName, dentistLastname, registration);

                // El objeto contenedor que va a tener el resultado del mapeo y le mapeo ya realizado
                dentistDTO = Optional.of(objectMapper.convertValue(dentist, DentistDTO.class));

            }
            preparedStatement.close();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return dentistDTO;
    }

    @Override
    public List<Optional<DentistDTO>> searchAllDentist() {
        Connection connection = null;
        PreparedStatement ps = null;
        List<Dentist> dentists = new ArrayList<>();
        Optional<DentistDTO> dentistDTO = null;
        List<Optional<DentistDTO>> dentistDTOList = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            ps = connection.prepareStatement(SELECT_ALL_DENTISTS);

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int dentistId = result.getInt("id");
                String dentistName = result.getString("name");
                String dentistLastname = result.getString("lastname");
                String registration = result.getString("registration");

                // Objeto con el metodo para mapear
                ObjectMapper objectMapper = new ObjectMapper();

                Dentist dentist = new Dentist(dentistId, dentistName, dentistLastname, registration);
                dentists.add(dentist);

                // El objeto contenedor que va a tener el resultado del mapeo y el mapeo ya realizado
                dentistDTO = Optional.of(objectMapper.convertValue(dentist, DentistDTO.class));
                dentistDTOList.add(dentistDTO);
            }
            ps.close();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException | SQLException e) {
            throw new RuntimeException(e);
        }
        return dentistDTOList;
    }

    @Override
    public Optional<DentistDTO> updateDentist(Dentist dentist) {
        Connection connection = null;
        PreparedStatement ps = null;
        Optional<DentistDTO> dentistDTO = null;

        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            ps = connection.prepareStatement(UPDATE_DENTIST);
            ps.setString(1, dentist.getName());
            ps.setString(2, dentist.getLastname());
            ps.setString(3, dentist.getRegistration());
            ps.setInt(4, dentist.getId());

            ps.executeUpdate();
            ps.close();

            // Objeto con el metodo para mapear
            ObjectMapper objectMapper = new ObjectMapper();

            // El objeto contenedor que va a tener el resultado del mapeo y el mapeo ya realizado
            dentistDTO = Optional.of(objectMapper.convertValue(dentist, DentistDTO.class));

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return dentistDTO;
    }

    @Override
    public void deleteDentist(Integer id) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            ps = connection.prepareStatement(DELETE_DENTIST);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
            logger.debug("Odontologo con id" + id  + " fue elimindao");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

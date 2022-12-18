package com.entregafinalspring.entregafinal.servicesNew.impl;

import com.entregafinalspring.entregafinal.entity.Patient;
import com.entregafinalspring.entregafinal.servicesNew.PatientService;
import com.entregafinalspring.entregafinal.util.Util;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    final static Logger logger = Logger.getLogger(PatientServiceImpl.class);

    // CONSTANTES PARA CONEXION BD
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
//    private final static String DB_URL = "jdbc:h2:~/h2-database-dental-clinic";

    private final static String DB_URL = "jdbc:h2:~/h2-database-dental-clinic;INIT=RUNSCRIPT FROM 'classpath:create.sql'";

//    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/h2-database-dental-clinic;";

    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "";


    private final static String CREATE_PATIENTS = "CREATE TABLE IF NOT EXISTS patients " +
            "(id int auto_increment primary key, name varchar(255), lastname varchar(255), address varchar(255), dni varchar(255), registrationDate TIMESTAMP WITHOUT TIME ZONE)";

    private final static String INSERT_PATIENT_DATA = "INSERT INTO patients (name, lastname, address, dni, registrationDate) VALUES(?,?,?,?,?)";
    private final static String SELECT_PATIENT_DATA = "SELECT id, name, lastname, address, dni, registrationDate FROM patients WHERE id = ?";

    private final static String SELECT_ALL_PATIENTS = "SELECT * FROM patients";

    private final static String UPDATE_PATIENT = "UPDATE patients SET name = ?, lastname = ?, address = ?, dni = ?, registrationDate = ? WHERE id = ?";

    private final static String DELETE_PATIENT = "DELETE FROM patients WHERE id  = ?";

    // TODO: Review savePatient response after save patient from Postman
    @Override
    public Patient savePatient(Patient patient) throws SQLException {
        System.out.println("Registrando paciente (new service): " + patient.toString());
        logger.debug("Guardado de un nuevo paciente.!");

        Connection connection = null;
        PreparedStatement psCreate = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Ya no es necesaria al ejecutar desde la conexión DB_URL con create.sql
//            psCreate = connection.prepareStatement(CREATE_PATIENTS);
//            psCreate.execute();

            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(INSERT_PATIENT_DATA);

            preparedStatement.setString(1, patient.getName());
            preparedStatement.setString(2, patient.getLastname());
            preparedStatement.setString(3, patient.getAddress());
            preparedStatement.setString(4, patient.getDni());
            preparedStatement.setDate(5, Util.utilDateToSqlDate(patient.getRegistrationDate()));

            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
        return patient;
    }

    @Override
    public Patient searchPatient(Integer id) throws SQLException {
        logger.debug("Paciente encontrado con id= " + id);
        Connection connection = null;
        PreparedStatement ps = null;
        Patient patient = null;

        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            ps = connection.prepareStatement(SELECT_PATIENT_DATA);
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int patientId = result.getInt("id");
                String patientName = result.getString("name");
                String patientLastname = result.getString("lastname");
                String patientAddress = result.getString("address");
                String patientDni = result.getString("dni");
                Date patientRD = result.getDate("registrationDate");

                patient = new Patient(patientId, patientName, patientLastname, patientAddress, patientDni, patientRD);
            }

            ps.close();

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
        return patient;
    }

    @Override
    public List<Patient> searchAllPatients() {
        logger.debug("Listado de pacientes");
        Connection connection = null;
        PreparedStatement ps = null;
        List<Patient> patients = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            ps = connection.prepareStatement(SELECT_ALL_PATIENTS);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Integer patientId = result.getInt("id");
                String patientName = result.getString("name");
                String patientLastname = result.getString("lastname");
                String patientAddress = result.getString("address");
                String patientDni = result.getString("dni");
                java.sql.Date patientRD = result.getDate("registrationDate");

                Patient patient = new Patient(patientId, patientName, patientLastname, patientAddress, patientDni, patientRD);
                patients.add(patient);

            }
            ps.close();

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        logger.debug("Actualizando paciente");
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            ps = connection.prepareStatement(UPDATE_PATIENT);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getLastname());
            ps.setString(3, patient.getAddress());
            ps.setString(4, patient.getDni());
            ps.setDate(5, Util.utilDateToSqlDate(patient.getRegistrationDate()));
            ps.setInt(6, patient.getId());

            ps.executeUpdate();
            ps.close();
            logger.info("Paciente actualizado");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return patient;
    }

    @Override
    public void deletePatient(Integer id) {
        logger.debug("Borrando pacinete");
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            ps = connection.prepareStatement(DELETE_PATIENT);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
            logger.debug("Paciente eliminado");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

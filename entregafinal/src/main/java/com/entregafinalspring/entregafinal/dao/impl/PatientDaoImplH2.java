//package com.entregafinalspring.entregafinal.dao.impl;
//
//import com.entregafinalspring.entregafinal.dao.configuracion.ConfigurationJDBC;
//import com.entregafinalspring.entregafinal.models.Patient;
//import com.entregafinalspring.entregafinal.util.Util;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.sql.*;
//
//@Repository
//public class PatientDaoImplH2 implements IDao<Patient> {
//
//    final static Logger logger = Logger.getLogger(PatientDaoImplH2.class);
//    private final static String CREATE_PATIENTS = "CREATE TABLE IF NOT EXISTS patients " +
//            "(id int auto_increment primary key, name varchar(255), lastname varchar(255), address varchar(255), dni varchar(255), registrationDate TIMESTAMP WITHOUT TIME ZONE)";
//
//    private final ConfigurationJDBC configurationJDBC;
//
//    @Autowired
//    public PatientDaoImplH2(ConfigurationJDBC configurationJDBC) {
//        this.configurationJDBC = configurationJDBC ;
//    }
//
//
//    @Override
//    public Patient save(Patient patient) {
//        System.out.println("Registrando paciente: " + patient.toString());
//
//        Connection connection = configurationJDBC.connectToDb();
//        PreparedStatement psCreate = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            psCreate = connection.prepareStatement(CREATE_PATIENTS);
//            psCreate.execute();
//
//            preparedStatement = connection.prepareStatement("INSERT INTO patients (name, lastname, address, dni, registrationDate) VALUES(?,?,?,?,?)",
//                    Statement.RETURN_GENERATED_KEYS);
//
//            preparedStatement.setString(1, patient.getName());
//            preparedStatement.setString(2, patient.getLastname());
//            preparedStatement.setString(3, patient.getAddress());
//            preparedStatement.setString(4, patient.getDni());
//            preparedStatement.setDate(5, Util.utilDateToSqlDate(patient.getRegistrationDate()));
//            preparedStatement.executeUpdate();
//
//            ResultSet keys = preparedStatement.getGeneratedKeys();
//            if (keys.next()) {
//                patient.setId(keys.getInt(1));
//            }
//
//            preparedStatement.close();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return patient;
//    }
//
//
//}

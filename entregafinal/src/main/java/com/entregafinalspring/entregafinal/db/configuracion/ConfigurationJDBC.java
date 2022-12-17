package com.entregafinalspring.entregafinal.db.configuracion;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ConfigurationJDBC {

    private final String jdbcDriver;
    private final String dbUrl;
    private final String nombreUsuario;
    private final String contrasenaUsuario;

    //Podemos usar este constructor para conectarnos con otra configuracion
    /*public ConfiguracionJDBC(String jdbcDriver, String dbUrl, String nombreUsuario, String contrasenaUsuario) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }*/

    public ConfigurationJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/h2-database-dental-clinic";
//        this.dbUrl = "jdbc:h2:tcp://localhost/~/h2-database-dental-clinic;INIT=RUNSCRIPT FROM 'classpath*:create.sql'";
//        this.dbUrl = "jdbc:h2:~/db_clinica-test;INIT=RUNSCRIPT FROM 'classpath:create.sql'";
        this.nombreUsuario = "root";
        this.contrasenaUsuario = "";
    }

    public Connection connectToDb() {
        Connection connection = null;
        try {
            Class.forName(jdbcDriver).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(dbUrl, nombreUsuario, contrasenaUsuario);
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException |
                 NoSuchMethodException throwables) {
            throwables.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }


}

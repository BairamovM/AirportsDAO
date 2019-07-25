package com.solvd.airport.dao.daoClass;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactory {

    private static final Logger logDAO = Logger.getLogger(ConnectionFactory.class);

    public static final String URL = "jdbc:mysql://localhost:3306/"; // ?useSSL=false
    public static final String USER = "Neuromancer";
    public static final String PASS = "Neuromancer";

    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            logDAO.error("Error connecting to the database", e);
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

}

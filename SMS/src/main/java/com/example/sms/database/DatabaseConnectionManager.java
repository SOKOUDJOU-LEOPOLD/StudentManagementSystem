package com.example.sms.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseConnectionManager {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/student_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";

    private Connection connection;

    public DatabaseConnectionManager() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Connected successfully!!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectionManager.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }


    public Connection getConnection() {
        return connection;
    }
}


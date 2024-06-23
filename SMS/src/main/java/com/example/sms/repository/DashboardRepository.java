package com.example.sms.repository;

import com.example.sms.database.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DashboardRepository {
    DatabaseConnectionManager manager = new DatabaseConnectionManager();

    public int getNumberOfStudent(){
        Connection connection = manager.getConnection();

        String query = "SELECT COUNT(`STU_ID`) FROM `student`;";

        try {
            Statement s = connection.createStatement();
            ResultSet re = s.executeQuery(query);
            re.next();
            return re.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getNumberOfCourse(){
        Connection connection = manager.getConnection();

        String query = "SELECT COUNT(`COURSE_ID`) FROM `course`;";

        try {
            Statement s = connection.createStatement();
            ResultSet re = s.executeQuery(query);
            re.next();
            return re.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}

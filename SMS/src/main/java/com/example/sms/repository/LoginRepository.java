package com.example.sms.repository;

import com.example.sms.database.DatabaseConnectionManager;
import com.example.sms.model.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginRepository {

    DatabaseConnectionManager manager = new DatabaseConnectionManager();

    public Login adminLogin(String reg_no, String password){
        Connection connection = manager.getConnection();

        String query = "SELECT * FROM `login` WHERE `REG_NO` = '" +
                reg_no + "' AND `PASSWORD` = SHA1('"+ password +"');";

        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);
            if(rs.next()){
                Login login = new Login(rs.getInt("LOGIN_ID"), rs.getString("REG_NO"), rs.getString("PASSWORD"));

                return login;
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }



}

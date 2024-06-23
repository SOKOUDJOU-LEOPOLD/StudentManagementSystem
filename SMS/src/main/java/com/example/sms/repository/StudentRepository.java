package com.example.sms.repository;

import com.example.sms.database.DatabaseConnectionManager;
import com.example.sms.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentRepository {

    DatabaseConnectionManager manager = new DatabaseConnectionManager();

    public ArrayList<Student> getStudents(){
        Connection connection = manager.getConnection();

        String query = "SELECT * FROM `student`;";

        ArrayList<Student> students = new ArrayList<>();
        try{
            Statement s = connection.createStatement();
            ResultSet re = s.executeQuery(query);

            while (re.next()){
                Student student = new Student(re.getInt("STU_ID"), re.getString("REF_NO"), re.getString("NAME"),
                        re.getDate("BIRTHDAY"), re.getString("PHONE"), re.getString("ADDRESS"));

                students.add(student);
            }
            return students;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void storeStudent(Student student){
        Connection connection = manager.getConnection();
        String query = "INSERT INTO `student`(`STU_ID`,`REF_NO`,`NAME`,`BIRTHDAY`,`PHONE`,`ADDRESS`) VALUES(?,?,?,?,?,?);";

        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,student.getStu_id());
            ps.setString(2,student.getRef_no());
            ps.setString(3,student.getName());
            ps.setDate(4, student.getBirthday());
            ps.setString(5, student.getPhone());
            ps.setString(6, student.getAddress());

            ps.execute();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

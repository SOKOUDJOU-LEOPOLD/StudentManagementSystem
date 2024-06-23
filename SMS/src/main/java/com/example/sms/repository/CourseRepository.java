package com.example.sms.repository;

import com.example.sms.database.DatabaseConnectionManager;
import com.example.sms.model.Course;
import com.example.sms.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class CourseRepository {
    DatabaseConnectionManager manager = new DatabaseConnectionManager();

    public ArrayList<Course> getCourses(){
        Connection connection = manager.getConnection();

        String query = "SELECT * FROM `course`;";
        ArrayList<Course> courses = new ArrayList<>();
        try{
            Statement s = connection.createStatement();
            ResultSet re = s.executeQuery(query);

            while (re.next()){
                Course course = new Course(re.getInt("COURSE_ID"), re.getString("CODE"),
                        re.getString("TITLE"), re.getString("DESCRIPTION"),
                        re.getString("PASSING_GRADE"));

                courses.add(course);
            }
            return courses;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void storeCourse(Course course) {
        Connection connection = manager.getConnection();
        String query = "INSERT INTO `course`(`COURSE_ID`,`CODE`,`TITLE`,`DESCRIPTION`,`PASSING_GRADE`) VALUES(?,?,?,?,?);";

        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,course.getCourse_id());
            ps.setString(2,course.getCode());
            ps.setString(3,course.getTitle());
            ps.setString(4, course.getDescription());
            ps.setString(5, course.getPassing_grade());
            ps.execute();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

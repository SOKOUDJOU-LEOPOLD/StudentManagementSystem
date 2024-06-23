package com.example.sms.controller;

import com.example.sms.model.Course;
import com.example.sms.model.Student;
import com.example.sms.repository.CourseRepository;
import com.example.sms.repository.StudentRepository;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddEditStudentPageController {
    public TextField reg_no;
    public TextField name;
    public TextField birthday;
    public TextField phone;
    public TextField address;
    public Button save_id;

    public void saveStudent(ActionEvent event) {
//        StudentRepository studentRepository = new StudentRepository();
//        try {
//            Student student = new Student(0, reg_no.getText(), name.getText(), , phone.getText(), address.getText());
//            studentRepository.storeStudent(student);
//
//            reg_no.setText("");
//            name.setText("");
//            birthday.setText("");
//            phone.setText("");
//            address.setText("");
//
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//
//
//

    }
}

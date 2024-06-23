package com.example.sms.controller;

import com.example.sms.model.Course;
import com.example.sms.repository.CourseRepository;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddEditCoursePageController {
    public TextField code_id;
    public TextField title_id;
    public TextField grade_id;
    public TextArea description_id;
    public Button save_id;

    public void saveCourse(ActionEvent event) {
        CourseRepository courseRepository = new CourseRepository();
        Course course = new Course(0, code_id.getText(), title_id.getText(), description_id.getText(), grade_id.getText());

        courseRepository.storeCourse(course);

        code_id.setText("");
        title_id.setText("");
        description_id.setText("");
        grade_id.setText("");
    }
}

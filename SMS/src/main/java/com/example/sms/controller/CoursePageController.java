package com.example.sms.controller;

import com.example.sms.model.Course;
import com.example.sms.model.Student;
import com.example.sms.repository.CourseRepository;
import com.example.sms.repository.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CoursePageController implements Initializable {
    public TableColumn<Course, String> code_id;
    public TableColumn<Course, String> title_id;
    public TableColumn<Course, String> desc_id;
    public TableColumn<Course, String> passgrade_id;
    public Button edit_id;
    public Button add_id;
    public Button delete_id;
    public TableView courseTableView;
    private HomePageController homePageController;

    public void editCourse(ActionEvent event) {
    }

    public void addCourse(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/sms/add-edit-course-page.fxml"));
        AnchorPane pane = fxmlLoader.load();
        homePageController.centerPane.getChildren().clear();
        homePageController.centerPane.getChildren().add(pane);
        homePageController.centerPane.setPadding(new Insets(20, 0, 0, 150));


    }

    public void deleteCourse(ActionEvent event) {
    }

    public void setHomePageController(HomePageController homePageController) {
        this.homePageController = homePageController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CourseRepository courseRepository = new CourseRepository();

        ObservableList<Course> mylist =  FXCollections.observableArrayList(courseRepository.getCourses());

        code_id.setCellValueFactory(new PropertyValueFactory<Course, String>("code"));
        title_id.setCellValueFactory(new PropertyValueFactory<Course, String>("title"));
        desc_id.setCellValueFactory(new PropertyValueFactory<Course, String>("description"));
        passgrade_id.setCellValueFactory(new PropertyValueFactory<Course, String>("passing_grade"));

        courseTableView.setItems(mylist);

    }
}

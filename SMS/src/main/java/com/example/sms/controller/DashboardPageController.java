package com.example.sms.controller;

import com.example.sms.repository.DashboardRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardPageController implements Initializable {
    public Text number_students_id;
    public Text number_courses_id;
    public Button studentButton;
    public Button courseButton;
    private HomePageController homePageController;

    public void loadStudent(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/sms/student-page.fxml"));
        AnchorPane pane = fxmlLoader.load();

        homePageController.centerPane.getChildren().clear();
        homePageController.centerPane.getChildren().add(pane);
        homePageController.centerPane.setPadding(new Insets(20, 0, 0, 150));

        //pass the home controller to the student controller
        StudentPageController studentPageController = fxmlLoader.getController();
        studentPageController.setHomePageController(homePageController);
    }

    public void loadCourse(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/sms/course-page.fxml"));
        AnchorPane pane = fxmlLoader.load();

        homePageController.centerPane.getChildren().clear();
        homePageController.centerPane.getChildren().add(pane);
        homePageController.centerPane.setPadding(new Insets(20, 0, 0, 150));

        //pass the home controller to the student controller
        CoursePageController coursePageController = fxmlLoader.getController();
        coursePageController.setHomePageController(homePageController);
    }

    public void setHomePageController(HomePageController homePageController) {
        this.homePageController = homePageController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DashboardRepository dashboardRepository = new DashboardRepository();
        number_students_id.setText("" + dashboardRepository.getNumberOfStudent());
        number_courses_id.setText("" + dashboardRepository.getNumberOfCourse());
    }
}

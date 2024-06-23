package com.example.sms.controller;

import com.example.sms.model.Student;
import com.example.sms.repository.StudentRepository;
import javafx.beans.property.SimpleIntegerProperty;
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
import java.sql.Date;
import java.util.ResourceBundle;

public class StudentPageController implements Initializable {
    public Button edit_id;
    public Button add_id;
    public Button delete_id;
    public TableColumn<Student, String> reg_no_id;
    public TableColumn<Student, String> name_id;
    public TableColumn<Student, Date> birthday_id;
    public TableColumn<Student, String> phone_id;
    public TableColumn<Student, String> address_id;
    public TableView<Student> studentTableView;
    private HomePageController homePageController;

    public void editStudent(ActionEvent event) {
    }

    public void addStudent(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/sms/add-edit-student-page.fxml"));
        AnchorPane pane = fxmlLoader.load();
        homePageController.centerPane.getChildren().clear();
        homePageController.centerPane.getChildren().add(pane);
        homePageController.centerPane.setPadding(new Insets(20, 0, 0, 150));
    }

    public void deleteStudent(ActionEvent event) {
    }

    public void setHomePageController(HomePageController homePageController) {
        this.homePageController = homePageController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StudentRepository studentRepository = new StudentRepository();

        ObservableList<Student> mylist =  FXCollections.observableArrayList(studentRepository.getStudents());

        reg_no_id.setCellValueFactory(new PropertyValueFactory<Student, String>("ref_no"));
        name_id.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        birthday_id.setCellValueFactory(new PropertyValueFactory<Student, Date>("birthday"));
        phone_id.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));
        address_id.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));

        studentTableView.setItems(mylist);


    }
}

package com.example.sms.controller;

import com.example.sms.HelloApplication;
import com.example.sms.model.Login;
import com.example.sms.repository.LoginRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {
    public TextField reg_no_id;
    public TextField pwd_id;
    public Button login_id;



    public void login(ActionEvent event) throws IOException {
        LoginRepository loginRepository = new LoginRepository();
        Login login = loginRepository.adminLogin(reg_no_id.getText(), pwd_id.getText());



        if(login != null){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/sms/home-page.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 1532, 800);
            stage.setTitle("Home!");
            stage.getIcons().add(new Image(String.valueOf(HelloApplication.class.getResource("images/schoollogo.jpg"))));
            stage.setScene(scene);
            stage.show();

            Stage primaryStage = (Stage)login_id.getScene().getWindow();
            primaryStage.close();

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Process");
            alert.setHeaderText("Results:");
            alert.setContentText("User Not Found.\"\n\" Please Register");

            alert.showAndWait();
        }

    }
}

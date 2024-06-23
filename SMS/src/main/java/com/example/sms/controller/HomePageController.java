package com.example.sms.controller;

import com.example.sms.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    public GridPane gridPaneId;
    public Button logoButton;
    public Text welcomeTextId;
    public Circle circleId;
    public Text nameId;
    public Button dashboardbutton1;
    public Button dashboardbutton;
    public Button studentButton;
    public Button courseButton;
    public Button logoutButton;
    public Button profileButton;
    public StackPane centerPane;

    public void loadDashboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/sms/dashboard-page.fxml"));
        loadPage(fxmlLoader);

        DashboardPageController dashboardController = fxmlLoader.getController();
        dashboardController.setHomePageController(this);
    }

    public void logOut(ActionEvent event) throws IOException {
        //close the home page
        Stage primaryStage = (Stage)centerPane.getScene().getWindow();
        primaryStage.close();

        //load the login page
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        Stage stage = new Stage();
        stage.setTitle("Login!");
        stage.getIcons().add(new Image(String.valueOf(HelloApplication.class.getResource("images/schoollogo.jpg"))));
        stage.setScene(scene);
        stage.show();
    }

    public void loadStudent(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/sms/student-page.fxml"));
        loadPage(fxmlLoader);

        StudentPageController studentPageController = fxmlLoader.getController();
        studentPageController.setHomePageController(this);
    }

    public void loadCourse(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/sms/course-page.fxml"));
        loadPage(fxmlLoader);

        CoursePageController coursePageController = fxmlLoader.getController();
        coursePageController.setHomePageController(this);
    }

    public void loadProfile(ActionEvent event) {
    }

    public void loadPage(FXMLLoader loader) throws IOException {

        AnchorPane pane = loader.load();
        centerPane.getChildren().clear();
        centerPane.getChildren().add(pane);
        centerPane.setPadding(new Insets(20, 0, 0, 150));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //make the profile button disappear
        profileButton.setVisible(false);

        // fill the profile circle
        Image img = new Image(String.valueOf(HelloApplication.class.getResource("images/personlogo.jpeg")));
        circleId.setFill(new ImagePattern(img));

        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/com/example/sms/dashboard-page.fxml"));
        // access the HomeController's centerPane to display the dashboard.fxml
        try {
            Parent pane = fxmlLoader1.load();

            DashboardPageController dashboardController = fxmlLoader1.getController();
            dashboardController.setHomePageController(this);
            centerPane.getChildren().clear();
            centerPane.getChildren().add(pane);
            centerPane.setPadding(new Insets(20, 0, 0, 150));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

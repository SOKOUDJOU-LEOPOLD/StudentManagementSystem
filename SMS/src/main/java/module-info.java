module com.example.sms {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    exports com.example.sms.controller;
    opens com.example.sms.controller to javafx.fxml;

    opens com.example.sms.model to javafx.fxml;
    exports com.example.sms.model;

    opens com.example.sms to javafx.fxml;
    exports com.example.sms;
    requires java.sql;
}
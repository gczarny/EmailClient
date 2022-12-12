module EmailClient {

    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires activation;
    requires java.mail;

    opens com.app;
    opens com.app.view;
    opens com.app.controller;
    opens com.app.model;
}
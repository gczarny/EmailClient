package com.app.controller;

import com.app.EmailManager;
import com.app.controller.services.LoginService;
import com.app.model.EmailAccount;
import com.app.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {

    @FXML
    private Label errorLabel;

    @FXML
    private TextField emailAddressFied;

    @FXML
    private PasswordField passwordField;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        System.out.println("loginButtonAction!");
        if(fieldsAreValid()){
            EmailAccount emailAccount = new EmailAccount(emailAddressFied.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            loginService.start();
            loginService.setOnSucceeded(event -> {
                EmailLoginResult emailLoginResult = loginService.getValue();
                switch(emailLoginResult){
                    case SUCCESS:
                        System.out.println("Login: " + emailAccount);
                        System.out.println("loginButtonAction!!");
                        viewFactory.showMainWindow();
                        Stage stage = (Stage) errorLabel.getScene().getWindow();
                        viewFactory.closeStage(stage);
                        return;
                    case FAILED_BY_CREDENTIALS:
                        errorLabel.setText("Invalid credentials!");
                        return;
                    case FAILED_BY_NETWORK:
                        errorLabel.setText("Network problem!");
                        return;
                    case FAILED_BY_UNEXPECTED_ERROR:
                        errorLabel.setText("Unexpected error!");
                        return;
                    default:
                        return;
                }
            });
        }
    }

    private boolean fieldsAreValid() {
        if(emailAddressFied.getText().isEmpty()){
            errorLabel.setText("Please fill email");
            return false;
        }
        if(passwordField.getText().isEmpty()){
            errorLabel.setText("Please fill email");
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailAddressFied.setText("grzegorz.czarny.prog@wp.pl");
        passwordField.setText("password");
    }
}

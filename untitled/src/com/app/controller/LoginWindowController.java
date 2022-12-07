package com.app.controller;

import com.app.EmailManager;
import com.app.controller.services.LoginService;
import com.app.model.EmailAccount;
import com.app.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController {

    @FXML
    private Button errorLabel;

    @FXML
    private TextField emailAddressFied;

    @FXML
    private PasswordField passwordField;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        if(fieldsAreValid()){
            EmailAccount emailAccount = new EmailAccount(emailAddressFied.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            EmailLoginResult emailLoginResult = loginService.login();

            switch(emailLoginResult){
                case SUCCESS:
                    System.out.println("Login: " + emailAccount);
                    return;
            }
        }
        System.out.println("loginButtonAction!!");
        viewFactory.showMainWindow();
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);
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
}

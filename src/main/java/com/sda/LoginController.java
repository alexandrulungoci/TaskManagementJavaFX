package com.sda;


import com.sda.UI.UserUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;


public class LoginController {

    UserUI userUI = new UserUI();

    @FXML
    private TextField fnReg;

    @FXML
    private TextField lnReg;

    @FXML
    private TextField unReg;

    @FXML
    private TextField passReg;

    @FXML
    private Button register;

    @FXML
    private void login() {
        System.out.println("login");

    }

    @FXML
    public void register(ActionEvent event) {
        Window owner = register.getScene().getWindow();
        if (fnReg.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your first name");
            return;
        }
        if (lnReg.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your last name");
            return;
        }
        if (unReg.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your username");
            return;
        }
        if (passReg.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your password");
            return;
        }

        AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Registration Successful!",
                "Welcome " + unReg.getText());

        String firstname = fnReg.getText();
        String lastName = lnReg.getText();
        String username = unReg.getText();
        String pass = passReg.getText();

        userUI.registerUser(firstname, lastName, username, pass);

    }

    @FXML
    private void loginRegister(ActionEvent event) throws IOException {
        URL url = getClass().getClassLoader().getResource("login_register.fxml");
        Parent loginReg = FXMLLoader.load(url);
        Scene loginScene = new Scene(loginReg);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

    @FXML
    private void mainMenu(ActionEvent event) throws IOException {
        URL url = getClass().getClassLoader().getResource("mainMenu.fxml");
        Parent mainParent = FXMLLoader.load(url);
        Scene mainScene = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

}

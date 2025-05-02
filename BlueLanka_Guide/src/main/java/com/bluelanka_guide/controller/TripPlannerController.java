package com.bluelanka_guide.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
public class TripPlannerController {

    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    protected void onTestButton() {
        nameTextField.setDisable(true);
        passwordTextField.setDisable(true);
    }
}

package com.bluelanka_guide.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    @FXML
    private Button loginbtn_id;

    @FXML
    private Label msg1id;

    @FXML
    private PasswordField passwordtext;
    @FXML
    private Button cancelbtn_id;
    @FXML
    private Button registerbtn_id;


    @FXML
    private TextField usernametext;

    private Connection connect;
    private PreparedStatement statement;
    private ResultSet result;


    public Connection connectdb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    @FXML
    public void loginbtn_idOnAction(javafx.event.ActionEvent event) {
        if (usernametext.getText().isBlank() || passwordtext.getText().isBlank()) {
            msg1id.setText("Please Enter both username and password.");
            return;
        }

        connect = connectdb();
        if (connect == null) {
            msg1id.setText("Database connection failed.");
            return;
        }

        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, usernametext.getText());
            statement.setString(2, passwordtext.getText());
            result = statement.executeQuery();

            if (result.next()) {
                msg1id.setText("Login successful!");
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Dashboard.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) registerbtn_id.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                msg1id.setText("Invalid username or password.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg1id.setText("An error occurred.");
        }
    }


    public void cancelbtn_idOnAction(javafx.event.ActionEvent event) {
        Stage stage=(Stage)cancelbtn_id.getScene().getWindow();
        stage.close();
    }

    public void registerbtn_idOnAction(javafx.event.ActionEvent event){

        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Signup.fxml"));
            root = fxmlLoader.load();
            Stage stage = (Stage) registerbtn_id.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Register");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

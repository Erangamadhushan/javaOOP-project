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

public class SignupController {


    @FXML
    private Button cancel_reg_id;

    @FXML
    private PasswordField confirm_reg_id;

    @FXML
    private Label confirmpasswordtxt_reg_id;

    @FXML
    private TextField email_reg_id;

    @FXML
    private Label emailtxt_reg_id;

    @FXML
    private Button login_reg_id;

    @FXML
    private Label msg2id;

    @FXML
    private PasswordField password_reg_id;

    @FXML
    private Label passwordtxt_reg_id;

    @FXML
    private Label register_text_id;

    @FXML
    private Button signup_reg_id;

    @FXML
    private Label text_reg_id;

    @FXML
    private TextField username_reg_id;

    @FXML
    private Label usernametxt_reg_id;







    public void cancel_reg_idOnAction(javafx.event.ActionEvent event) {
        Stage stage=(Stage)cancel_reg_id.getScene().getWindow();
        stage.close();
    }

    public Connection connectdb(){
        try{
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "");
            return connect;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void signup_reg_idOnAction(javafx.event.ActionEvent event) {
        if (username_reg_id.getText().isBlank()) {
            msg2id.setText("Please Enter User name");
            msg2id.setVisible(true);
        } else if (email_reg_id.getText().isBlank()) {
            msg2id.setText("Please Enter Email Address");
            msg2id.setVisible(true);
        } else if (password_reg_id.getText().isBlank()) {
            msg2id.setText("Please Enter Password");
            msg2id.setVisible(true);
        } else if (confirm_reg_id.getText().isBlank()) {
            msg2id.setText("Please Confirm Password");
            msg2id.setVisible(true);
        } else {
            if (password_reg_id.getText().equals(confirm_reg_id.getText())) {
                Connection connect = connectdb();

                try {
                    String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
                    PreparedStatement statement = connect.prepareStatement(sql);
                    statement.setString(1, username_reg_id.getText());
                    statement.setString(2, email_reg_id.getText());
                    statement.setString(3, password_reg_id.getText());

                    int rowsAffected = statement.executeUpdate();

                    if (rowsAffected > 0) {
                        msg2id.setText("Registration successful!");
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = (Stage) signup_reg_id.getScene().getWindow();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Login Page");
                        stage.show();
                    } else {
                        msg2id.setText("Registration failed. Try again.");
                    }

                } catch (Exception e) {
                    e.printStackTrace(); // Better for debugging
                    msg2id.setText("Error occurred during registration.");
                }

            } else {
                msg2id.setText("Confirm Password is Wrong!");
                msg2id.setVisible(true);
            }
        }
    }


    public void login_reg_idOnAction(javafx.event.ActionEvent event){

        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
            root = fxmlLoader.load();
            Stage stage = (Stage) login_reg_id.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Page");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    }











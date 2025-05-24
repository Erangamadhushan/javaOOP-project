package com.bluelanka_guide.controller;

import com.bluelanka_guide.AppStarter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public  class register extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(AppStarter.class.getResource("/FXML/Signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}

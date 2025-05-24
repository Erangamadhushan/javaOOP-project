package com.bluelanka_guide;

import com.bluelanka_guide.models.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import java.io.IOException;

public class AppStarter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(AppStarter.class.getResource("/FXML/TripPlanner/TripPlanner.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(),
//                800,
//                600);
//        stage.setTitle("Travel Tools");
//        stage.setScene(scene);
//        stage.show();

        Model.getInstance().getViewFactory().showTravelToolsWindow();
    }
   public static void main(String[] args) {
       launch(args);
   }
}

package com.bluelanka_guide;

import com.bluelanka_guide.models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppStarter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(AppStarter.class.getResource("/FXML/TravelToolsPage/CurrencyConverter.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Travel Tools");
//        stage.setScene(scene);
//        stage.show();

        Model.getInstance().getViewFactoryTravelTools().showTravelToolsWindow();
    }
//    public static void main(String[] args) {
//        launch(args);
//    }
}

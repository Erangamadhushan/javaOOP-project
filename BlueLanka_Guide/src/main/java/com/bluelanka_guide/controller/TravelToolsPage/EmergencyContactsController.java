package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class EmergencyContactsController implements Initializable {
    public Button btnBack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnBack.setOnAction(event -> onBackBtnClicked());
    }

    private void onBackBtnClicked() {
        Model.getInstance().getViewFactoryTravelTools().getToolSelectedMenuItem().set("back");
    }
}

package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class TravelToolsController implements Initializable {
    public Button btnMenuCurrencyConverter;
    public Button btnMenuWeather;
    public Button btnMenuUnitConverter;
    public Button btnMenuChecklist;
    public Button btnMenuEmergencyContacts;
    public Button btnMenuOther;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        btnMenuCurrencyConverter.setOnAction(actionEvent -> onCurrencyConverter());
        btnMenuWeather.setOnAction(actionEvent -> onWeather());
        btnMenuUnitConverter.setOnAction(actionEvent -> onUnitConverter());
        btnMenuEmergencyContacts.setOnAction(actionEvent -> onEmergencyContacts());
        btnMenuChecklist.setOnAction(actionEvent -> onChecklist());
    }

    private void onChecklist() {
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("Checklist");
    }

    private void onEmergencyContacts() {
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("EmergencyContacts");
    }

    private void onUnitConverter() {
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("UnitConverter");
    }

    private void onWeather() {
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("Weather");
    }

    private void onCurrencyConverter() {
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("CurrencyConverter");
    }

}
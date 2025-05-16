package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class TravelToolsSubMenuController implements Initializable {
    public Button btnCurrencyConverter;
    public Button btnWeather;
    public Button btnUnitConverter;
    public Button btnChecklist;
    public Button btnEmergencyContacts;
    public Button btnOther;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        btnCurrencyConverter.setOnAction(event -> onCurrencyConverter());
        btnWeather.setOnAction(event -> onWeather());
        btnUnitConverter.setOnAction(event -> onUnitConverter());
        btnEmergencyContacts.setOnAction(event -> onEmergencyContacts());
        btnChecklist.setOnAction(event -> onChecklist());
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

package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TravelToolsWindowController implements Initializable {
    public BorderPane toolsParentWindow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactoryTravelTools().getToolSelectedMenuItem().addListener
                ((observable, oldVal, newVal) -> {

                    switch (newVal){
                        case "CurrencyConverter" :
                            toolsParentWindow.setCenter(Model.getInstance().getViewFactoryTravelTools().getCurrencyConverterView());
                            toolsParentWindow.setLeft(Model.getInstance().getViewFactoryTravelTools().getTravelToolsSubMenuView());
                            break;

                        case "Weather" :
                            toolsParentWindow.setCenter(Model.getInstance().getViewFactoryTravelTools().getWeatherView());
                            toolsParentWindow.setLeft(Model.getInstance().getViewFactoryTravelTools().getTravelToolsSubMenuView());
                            break;

                        case "UnitConverter" :
                            toolsParentWindow.setLeft(Model.getInstance().getViewFactoryTravelTools().getTravelToolsSubMenuView());
                            toolsParentWindow.setCenter(Model.getInstance().getViewFactoryTravelTools().getUnitConverterView());
                            break;

                        case "EmergencyContacts" :
                            toolsParentWindow.setLeft(Model.getInstance().getViewFactoryTravelTools().getTravelToolsSubMenuView());
                            toolsParentWindow.setCenter(Model.getInstance().getViewFactoryTravelTools().getEmergencyContactsView());
                            break;

                        case "Checklist" :
                            toolsParentWindow.setLeft(Model.getInstance().getViewFactoryTravelTools().getTravelToolsSubMenuView());
                            toolsParentWindow.setCenter(Model.getInstance().getViewFactoryTravelTools().getChecklistView());
                            break;
//
//                        case "back" :
//                            toolsParentWindow.setLeft(Model.getInstance().getViewFactory().getTravelToolsView());
//                            toolsParentWindow.setCenter(null);
//                            break;

                        default:
                            toolsParentWindow.setLeft(Model.getInstance().getViewFactoryTravelTools().getTravelToolsView());
                            toolsParentWindow.setCenter(null);
                            break;
                    }
                });
    }

}

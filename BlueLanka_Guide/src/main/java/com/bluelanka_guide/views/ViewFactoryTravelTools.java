package com.bluelanka_guide.views;

import com.bluelanka_guide.controller.TravelToolsPage.TravelToolsWindowController;
import com.bluelanka_guide.models.UnitType;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewFactoryTravelTools {
    private UnitType unitType;

    private final StringProperty toolSelectedMenuItem;
    private AnchorPane travelToolsView;
    private AnchorPane checklistView;
    private AnchorPane currencyConverterView;
    private AnchorPane emergencyContactsView;
    private AnchorPane unitConverterView;
    private AnchorPane weatherView;
    private AnchorPane travelToolsSubMenuView;
    private BorderPane travelToolsWindowView;
    private HBox listItemView;


    public ViewFactoryTravelTools(){
        this.unitType = UnitType.Length;
        this.toolSelectedMenuItem = new SimpleStringProperty("");
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public StringProperty getToolSelectedMenuItem() {
        return toolSelectedMenuItem;
    }

    //travel tools menu views
    public BorderPane getTravelToolsWindow(){
        try{
            if(travelToolsWindowView == null){
                travelToolsWindowView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/TravelToolsWindow.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return travelToolsWindowView;
    }

    public AnchorPane getTravelToolsSubMenuView(){
        try{
            if(travelToolsSubMenuView == null){
                travelToolsSubMenuView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/TravelToolsSubMenu.fxml")).load();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return travelToolsSubMenuView;
    }

    public AnchorPane getTravelToolsView() {
        try{
            if(travelToolsView == null){
                travelToolsView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/TravelTools.fxml")).load();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return travelToolsView;
    }

    //travel tools views
    public AnchorPane getChecklistView() {
        try{
            if(checklistView == null){
                checklistView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/Checklist.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return checklistView;
    }

    public AnchorPane getCurrencyConverterView() {
        try{
            if(currencyConverterView == null){
                currencyConverterView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/CurrencyConverter.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return currencyConverterView;
    }

    public AnchorPane getEmergencyContactsView() {
        try{
            if(emergencyContactsView == null){
                emergencyContactsView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/EmergencyContacts.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return emergencyContactsView;
    }

    public AnchorPane getUnitConverterView() {
        try{
            if(unitConverterView == null){
                unitConverterView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/UnitConverter.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return unitConverterView;
    }

    public AnchorPane getWeatherView() {
        try{
            if(weatherView == null){
                weatherView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/Weather.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return weatherView;
    }

    public HBox getListItem(){
        try{
            listItemView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/CheckItem.fxml")).load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listItemView;
    }

    public void showTravelToolsWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/TravelToolsWindow.fxml"));
        TravelToolsWindowController controller = new TravelToolsWindowController();
        loader.setController(controller);
        createStage(loader);
    }

    //creating stage
    public void createStage(FXMLLoader loader){
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("BlueLanka Guide");
        stage.setScene(scene);
        stage.show();
    }

}

package com.bluelanka_guide.controller.TripPlanner;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TripPlannerController {

    @FXML
    private RadioButton radWeekend;
    @FXML
    private RadioButton radWeek;
    @FXML
    private RadioButton radExtended;
    @FXML
    private CheckBox checkMatara;
    @FXML
    private CheckBox checkHikkaduwa;
    @FXML
    private CheckBox checkNordicFjords;
    @FXML
    private CheckBox checkSouthPacific;
    @FXML
    private CheckBox checkOther;
    @FXML
    private TextField txtOtherRegion;

    @FXML
    private Button btnGeneratePlan;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnPrevious;
    @FXML
    private Button btnSave;

    @FXML
    private CheckBox chkChildFriendly;
    @FXML
    private CheckBox chkAccessibility;

    @FXML
    private Spinner spinnerChildren;
    @FXML
    private Spinner spinnerAdults;

    @FXML
    private ComboBox comboCurrency;
    @FXML
    private TextField txtBudgetAmount;

    @FXML
    private RadioButton radUltraLuxury;
    @FXML
    private RadioButton radLuxury;
    @FXML
    private RadioButton radModerate;
    @FXML
    private RadioButton radBudget;

    @FXML
    private Slider sliderIntensity;

    @FXML
    private CheckBox checkCultural;
    @FXML
    private CheckBox checkWildlife;
    @FXML
    private CheckBox checkSailing;
    @FXML
    private CheckBox checkWaterSports;

    @FXML
    private CheckBox checkRelaxation;
    @FXML
    private CheckBox checkSnorkeling;
    @FXML
    private CheckBox checkDiving;
    @FXML
    private CheckBox checkFishing;

    @FXML
    private Slider sliderDays;
    
    @FXML
    private Slider sliderPopularity;
    
    @FXML
    private RadioButton radCoastal;
    @FXML
    private RadioButton radOpenSea;
    @FXML
    private RadioButton radIslandHopping;
    @FXML
    private RadioButton radMixed;


    @FXML
    private RadioButton radDayTrip;

    @FXML
    public void handleOtherRegion() {

    }

    @FXML
    private void handlePrevious() {

    }

    @FXML
    private void handleNext() {

    }

    @FXML
    private void handleGeneratePlan() {

    }
}

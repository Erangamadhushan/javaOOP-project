package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.*;
import com.bluelanka_guide.models.UnitsModel.*;
import com.bluelanka_guide.services.UnitConvertTask;
import com.bluelanka_guide.services.UnitConverterAPIConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class UnitConverterController implements Initializable {
    public Button btnBack;
    public TextField txtFromAmount;
    public ComboBox<Unit> cmbFromUnit;
    public ComboBox<Unit> cmbToUnit;
    public Button btnSwap;
    public Button btnConvert;
    public Label lblError;
    public TextField txtToAmount;
    public ChoiceBox<UnitType> chbSelectUnit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //back button function
        btnBack.setOnAction(event -> onBackBtnClicked());

        //setting choice box values
        chbSelectUnit.setItems(FXCollections.observableArrayList(UnitType.Length, UnitType.Weight, UnitType.Area, UnitType.Temperature, UnitType.Volume, UnitType.Time));
        UnitType initialValue = Model.getInstance().getViewFactoryTravelTools().getUnitType();
        chbSelectUnit.setValue(initialValue);

        //setting values for combo boxes according to choice
        handleUnitChange(initialValue);
        chbSelectUnit.valueProperty().addListener((observable, oldVal, newVal) -> {
            handleUnitChange(newVal);
        });

        //convert button function
        btnConvert.setOnAction(event -> onConvert());
    }

    private void handleUnitChange(UnitType value) {
        switch (value){

            case Weight:
                setComboBox(WeightUnit.values());
                break;
            case Area:
                setComboBox(AreaUnit.values());
                break;
            case Temperature:
                setComboBox(TemperatureUnit.values());
                break;
            case Volume:
                setComboBox(VolumeUnit.values());
                break;
            case Time:
                setComboBox(TimeUnit.values());
                break;
            default:
                setComboBox(LengthUnit.values());
                break;
        }
    }

    private void onBackBtnClicked() {
        Model.getInstance().getViewFactoryTravelTools().getToolSelectedMenuItem().set("back");
    }

    private void onConvert() {
        try {
            String fromUnitSymbol = null;
            String toUnitSymbol = null;
            try {
                fromUnitSymbol = cmbFromUnit.getValue().getSymbol();
                toUnitSymbol = cmbToUnit.getValue().getSymbol();
            } catch (Exception e) {
                lblError.setText("Please select both units");
                txtFromAmount.clear();
                txtToAmount.clear();
                return;
            }
            String fromAmountStr = txtFromAmount.getText();

            if(fromUnitSymbol == null || toUnitSymbol == null){
                lblError.setText("Please select both units");
                txtFromAmount.clear();
                txtToAmount.clear();
                return;
            }
            if(Objects.equals(fromAmountStr, "")){
                lblError.setText("Please enter amount");
                txtFromAmount.clear();
                txtToAmount.clear();
                return;
            }

            UnitConvertTask task = new UnitConvertTask(fromAmountStr, fromUnitSymbol, toUnitSymbol);

            task.setOnSucceeded(event -> {
                double toAmountDouble = task.getValue();
                String toAmountStr = Double.toString(toAmountDouble);
                txtToAmount.setText(toAmountStr);

                lblError.setText("");
            });

            task.setOnFailed(event -> {
                lblError.setText("Error : Failed to fetch data.");
            });

            Thread thread = new Thread(task);
            thread.setDaemon(true);
            thread.start();
        } catch (Exception e) {
            lblError.setText("Error : " + e.getMessage());
            txtToAmount.clear();
            txtFromAmount.clear();
        }

    }

    private <T extends Enum<T> & Unit> void setComboBox(T[] units){
        ObservableList<Unit> observableList = FXCollections.observableArrayList(units);
        cmbFromUnit.setItems(observableList);
        cmbToUnit.setItems(observableList);
    }

}

package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.Model;
import com.bluelanka_guide.services.ExchangeRateTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrencyConverterController implements Initializable {
    public Button btnBack;
    public TextField txtFromAmount;
    public ComboBox<String> cmbFromCurrency;
    public ComboBox<String> cmbToCurrency;
    public Label lblToAmount;
    public Button btnConvert;
    public Label lblError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //back button function
        btnBack.setOnAction(event -> onBackBtnClicked());

        //combobox elements
        String[] currencyArray = {"LKR", "USD", "EUR", "GBP", "CAD", "AUD", "INR", "JPY", "CNY", "NZD"};
        ObservableList<String> currencyList = FXCollections.observableArrayList(currencyArray);
        cmbFromCurrency.setItems(currencyList);
        cmbToCurrency.setItems(currencyList);

        //convert button function
        btnConvert.setOnAction(event -> onConvert());

    }

    private void onBackBtnClicked() {
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("back");
    }

    private void onConvert() {
        try {
            //get values from comboboxes
            String fromCurrencySymbol = cmbFromCurrency.getValue();
            String toCurrencySymbol = cmbToCurrency.getValue();

            ExchangeRateTask task = new ExchangeRateTask(fromCurrencySymbol, toCurrencySymbol);

            task.setOnSucceeded(event -> {
                //get exchange rate
                double rate = task.getValue();

                String strFromAmount = txtFromAmount.getText();
                double doubleFromAmount = Double.parseDouble(strFromAmount);

                //calculate converted amount
                double doubleToAmount = rate * doubleFromAmount;

                String strToAmount = Double.toString(doubleToAmount);
                lblToAmount.setText(strToAmount);

                lblError.setText("");
            });

            task.setOnFailed(event -> {
                lblError.setText("Error: Failed to fetch Exchange data.");
            });

            //running a new thread background
            Thread thread = new Thread(task);
            thread.setDaemon(true);
            thread.start();


        } catch (Exception e) {
            lblError.setText("Error: "+ e.getMessage());
            lblToAmount.setText("");
            txtFromAmount.clear();
        }
    }
}

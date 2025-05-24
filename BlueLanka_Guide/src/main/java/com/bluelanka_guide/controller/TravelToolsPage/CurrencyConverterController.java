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
    public Button btnSwap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //back button function
        btnBack.setOnAction(event -> onBackBtnClicked());

        //combobox elements
        String[] currencyArray = {"LKR", "USD", "EUR", "GBP", "CAD", "AUD", "INR", "JPY", "CNY", "NZD"};
        ObservableList<String> currencyList = FXCollections.observableArrayList(currencyArray);
        cmbFromCurrency.setItems(currencyList);
        cmbToCurrency.setItems(currencyList);
//        cmbToCurrency.setEditable(true);
//        cmbFromCurrency.setEditable(true);

        //convert button function
        btnConvert.setOnAction(event -> onConvert());

    }

    private void onBackBtnClicked() {
        Model.getInstance().getViewFactoryTravelTools().getToolSelectedMenuItem().set("back");
    }

    private void onConvert() {
        try {
            //get values from comboboxes
            String fromCurrencySymbol = cmbFromCurrency.getValue();
            String toCurrencySymbol = cmbToCurrency.getValue();

            if(fromCurrencySymbol == null || toCurrencySymbol == null){
                lblError.setText("Please select both currencies");
                return;
            }

            ExchangeRateTask task = new ExchangeRateTask(fromCurrencySymbol, toCurrencySymbol);

            task.setOnSucceeded(event -> {
                //get exchange rate
                double rate = task.getValue();

                String strFromAmount = txtFromAmount.getText();
                double doubleFromAmount = 0;
                try {
                    doubleFromAmount = Double.parseDouble(strFromAmount);
                    lblError.setText("");
                } catch (NumberFormatException e) {
                    lblError.setText("Please enter a valid number");
//                    System.out.println(e.getMessage());
                    txtFromAmount.clear();
                    lblToAmount.setText("");
                    return;
                }

                //calculate converted amount
                double doubleToAmount = rate * doubleFromAmount;

                String strToAmount = String.format("%.2f", doubleToAmount);
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

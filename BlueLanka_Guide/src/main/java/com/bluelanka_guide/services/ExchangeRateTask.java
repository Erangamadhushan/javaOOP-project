package com.bluelanka_guide.services;

import javafx.concurrent.Task;

public class ExchangeRateTask extends Task<Double> {
    private final String fromCurrency;
    private final String toCurrency;

    public ExchangeRateTask(String fromCurrency, String toCurrency) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    @Override
    protected Double call() throws Exception {
        CurrencyAPIConnection apiConnection = new CurrencyAPIConnection();
        return apiConnection.getExchangeRates(fromCurrency, toCurrency);
    }
}

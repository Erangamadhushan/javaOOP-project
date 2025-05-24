package com.bluelanka_guide.services;

import javafx.concurrent.Task;

public class UnitConvertTask extends Task<Double> {
    private final String amount;
    private final String from;
    private final String to;

    public UnitConvertTask(String amount, String from, String to) {
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Double call() throws Exception {
        UnitConverterAPIConnection unitConvert = new UnitConverterAPIConnection();
        return unitConvert.getConvertedData(amount, from, to);
    }
}

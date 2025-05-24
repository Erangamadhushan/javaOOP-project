package com.bluelanka_guide.models.UnitsModel;

public enum WeightUnit implements Unit{
    MILLIGRAM("Milligram", "mg"),
    GRAM("gram", "g"),
    KILOGRAM("Kilogram", "kg"),
    METRIC_TON("Metric Ton", "T"),
    POUND("Pound", "lb");

    private final String name;
    private final String symbol;

    WeightUnit(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return name + "(" + symbol + ")";
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}

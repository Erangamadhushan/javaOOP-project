package com.bluelanka_guide.models.UnitsModel;

public enum TemperatureUnit implements Unit{
    CELSIUS("Celsius", "C"),
    FAHRENHEIT("Fahrenheit", "F"),
    KELVIN("Kelvin", "K");

    private final String name;
    private final String symbol;

    TemperatureUnit(String name, String symbol) {
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

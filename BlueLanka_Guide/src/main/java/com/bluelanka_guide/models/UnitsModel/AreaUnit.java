package com.bluelanka_guide.models.UnitsModel;

public enum AreaUnit implements Unit{
    SQUARE_METER("Square Meter", "m²"),
    SQUARE_CENTIMETER("Square centimeter", "cm²"),
    SQUARE_KILOMETER("Square Kilometer", "km²"),
    HECTARE("Hectare", "ha"),
    ACRE("Acre", "ac");

    private final String name;
    private final String symbol;

    AreaUnit(String name, String symbol) {
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

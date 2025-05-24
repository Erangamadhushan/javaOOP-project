package com.bluelanka_guide.models.UnitsModel;

public enum LengthUnit implements Unit{
    METER("Meter", "m"),
    CENTIMETER("Centimeter", "cm"),
    KILOMETER("Kilometer", "km"),
    MILLIMETER("Milimeter", "mm"),
    INCH("Inch", "in");

    private final String name;
    private final String symbol;

    LengthUnit(String name, String symbol) {
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

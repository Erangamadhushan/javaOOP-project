package com.bluelanka_guide.models.UnitsModel;

public enum VolumeUnit implements Unit{
    LITER("Liter", "l"),
    MILLILITER("Milliliter", "ml"),
    CUBICMETER("Cubic Meter", "m³"),
    CUBIC_CENTIMETER("Cubic Centimeter", "cm³"),
    CUBIC_MILLIMETER("Cubic Millimeter", "mm³");

    private final String name;
    private final String symbol;

    VolumeUnit(String name, String symbol) {
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

package org;

/**
 * Created by jukzhang on 10/5/16.
 */
public class LengthLib {
    private double value;
    private String unit;

    public LengthLib(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }

    public boolean equals(LengthLib length) {
        double convertValue = length.getValue();
        if("cm" == length.getUnit())
            convertValue = convertValue / 100;
        return this.value == convertValue;
    }
}

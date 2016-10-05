package org;

/**
 * Created by jukzhang on 10/5/16.
 */
public class MilliMeter extends LengthLib {
    public MilliMeter(double value, String unit) {
        this.value = value;
        this.unit = unit;
        this.unifyFactor = 1;
    }
}
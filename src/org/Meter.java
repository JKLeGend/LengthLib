package org;

/**
 * Created by jukzhang on 10/5/16.
 */
public class Meter extends LengthLib{
    public Meter(double value, String unit) {
        this.value = value;
        this.unit = unit;
        this.unifyFactor = 1000;
    }
}

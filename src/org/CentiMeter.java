package org;

/**
 * Created by jukzhang on 10/5/16.
 */
public class CentiMeter extends LengthLib{
    public CentiMeter(double value, String unit) {
        this.value = value;
        this.unit = unit;
        this.unifyFactor = 10;
    }
}
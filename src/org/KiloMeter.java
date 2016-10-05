package org;

/**
 * Created by jukzhang on 10/5/16.
 */
public class KiloMeter extends LengthLib {
    public KiloMeter(double value, String unit) {
        this.value = value;
        this.unit = unit;
        this.unifyFactor = 1000000;
    }
}

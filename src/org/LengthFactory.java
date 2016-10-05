package org;

/**
 * Created by jukzhang on 10/5/16.
 */
public class LengthFactory {
    public LengthLib createLength(double value, String unit) {
        LengthLib length;
        switch(unit) {
            case "mm":
                length = new MilliMeter(value, unit);
                break;
            case "cm":
                length = new CentiMeter(value, unit);
                break;
            case "m":
                length = new Meter(value, unit);
                break;
            case "km":
                length = new KiloMeter(value, unit);
                break;
            default:
                length = null;
        }
        return length;
    }
}

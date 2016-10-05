package org;

/**
 * Created by jukzhang on 10/5/16.
 */
public class LengthLib {
    double value;
    String unit;
    double unifyFactor;
    LengthFactory length;

    public LengthLib() {}

    public LengthLib(LengthFactory length) {
        this.length = length;
    }

    public LengthLib createLength(double value, String unit) {
        return length.createLength(value, unit);
    }

    public double getValue() {
        return this.value;
    }

    public void unify(){
        this.value = this.value * this.unifyFactor;
    }

    public boolean equals(LengthLib length) {
        this.unify();
        length.unify();
        return (this.value == length.getValue());
    }
}

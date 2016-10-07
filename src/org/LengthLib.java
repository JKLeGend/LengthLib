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

    public LengthLib plus(LengthLib length) {
        this.unify();
        length.unify();
        LengthLib lengthLib = new LengthLib(new LengthFactory());
        LengthLib plusLength = lengthLib.createLength(this.value + length.getValue(), "mm");

        return plusLength;
    }

    public LengthLib minus(LengthLib length) {
        this.unify();
        length.unify();
        LengthLib lengthLib = new LengthLib(new LengthFactory());
        LengthLib minusLength = lengthLib.createLength(this.value - length.getValue(), "mm");

        return minusLength;
    }

    public LengthLib multiply(double num) {
        this.unify();
        LengthLib lengthLib = new LengthLib(new LengthFactory());
        LengthLib multiplyLength = lengthLib.createLength(this.value * num, "mm");

        return multiplyLength;
    }
}

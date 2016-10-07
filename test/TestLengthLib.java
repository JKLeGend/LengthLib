import org.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by jukzhang on 10/5/16.
 */
public class TestLengthLib {
    public static final double PRECISION = 0.000001;
    LengthFactory lengthFactory;
    LengthLib length;

    @Before
    public void initialize() {
        lengthFactory = new LengthFactory();
        length = new LengthLib(lengthFactory);
    }

    @Test
    public void shouldReturnTrueWhenGetValueFrom_1m() {
        Meter meter = (Meter) length.createLength(1, "m");

        assertEquals(1.0, meter.getValue(), PRECISION);
        assertNotEquals(2.0, meter.getValue(), PRECISION);
    }

    @Test
    public void shouldReturnTrueWhen_1m_1m() {
        Meter meter_1 = (Meter) length.createLength(1, "m");
        Meter meter_2 = (Meter) length.createLength(1, "m");

        assertEquals(true, meter_1.equals(meter_2));
    }

    @Test
    public void shouldReturnFalseWhen_1m_2m() {
        Meter meter_1 = (Meter) length.createLength(1, "m");
        Meter meter_2 = (Meter) length.createLength(2, "m");

        assertNotEquals(true, meter_1.equals(meter_2));
    }

    @Test
    public void shouldReturnFalseWhen_1m_100cm() {
        Meter meter_1 = (Meter) length.createLength(1, "m");
        CentiMeter centiMeter_100 = (CentiMeter) length.createLength(100, "cm");

        assertEquals(true, meter_1.equals(centiMeter_100));
    }

    @Test
    public void shouldReturnFalseWhen_1cm_10mm() {
        CentiMeter centiMeter_1 = (CentiMeter) length.createLength(1, "cm");
        MilliMeter milliMeter_10 = (MilliMeter) length.createLength(10, "mm");

        assertEquals(true, centiMeter_1.equals(milliMeter_10));
    }

    @Test
    public void shouldReturnFalseWhen_1km_100000cm() {
        KiloMeter kiloMeter_1 = (KiloMeter) length.createLength(1, "km");
        CentiMeter centiMeter_100000 = (CentiMeter) length.createLength(100000, "cm");

        assertEquals(true, kiloMeter_1.equals(centiMeter_100000));
    }

    @Test
    public void shouldReturn3000When_1m_plus_2m() {
        Meter meter_1 = (Meter) length.createLength(1, "m");
        Meter meter_2 = (Meter) length.createLength(2, "m");

        assertEquals(3000, meter_1.plus(meter_2).getValue(), PRECISION);
    }

    @Test
    public void shouldReturn1200When_1m_plus_20cm() {
        Meter meter_1 = (Meter) length.createLength(1, "m");
        CentiMeter centiMeter_20 = (CentiMeter) length.createLength(20, "cm");

        assertEquals(1200, meter_1.plus(centiMeter_20).getValue(), PRECISION);
    }

    @Test
    public void shouldReturn1000002When_1km_plus_2mm() {
        KiloMeter kiloMeter_1 = (KiloMeter) length.createLength(1, "km");
        MilliMeter milliMeter_2 = (MilliMeter) length.createLength(2, "mm");

        assertEquals(1000002, kiloMeter_1.plus(milliMeter_2).getValue(), PRECISION);
    }

    @Test
    public void shouldReturn1000111When_1km_1m_1cm_1mm() {
        KiloMeter kiloMeter_1 = (KiloMeter) length.createLength(1, "km");
        Meter meter_1 = (Meter) length.createLength(1, "m");
        CentiMeter centiMeter_1 = (CentiMeter) length.createLength(1, "cm");
        MilliMeter milliMeter_1 = (MilliMeter) length.createLength(1, "mm");

        LengthLib resultLength = kiloMeter_1.plus(meter_1).plus(centiMeter_1).plus(milliMeter_1);

        assertEquals(1001011, resultLength.getValue(), PRECISION);
    }

    @Test
    public void shouldReturn_1000When_1m_minus_2m() {
        Meter meter_1 = (Meter) length.createLength(1, "m");
        Meter meter_2 = (Meter) length.createLength(2, "m");

        assertEquals(-1000, meter_1.minus(meter_2).getValue(), PRECISION);
    }

    @Test
    public void shouldReturn800When_1m_minus_20cm() {
        Meter meter_1 = (Meter) length.createLength(1, "m");
        CentiMeter centiMeter_20 = (CentiMeter) length.createLength(20, "cm");

        assertEquals(800, meter_1.minus(centiMeter_20).getValue(), PRECISION);
    }

    @Test
    public void shouldReturn999998When_1km_minus_2mm() {
        KiloMeter kiloMeter_1 = (KiloMeter) length.createLength(1, "km");
        MilliMeter milliMeter_2 = (MilliMeter) length.createLength(2, "mm");

        assertEquals(999998, kiloMeter_1.minus(milliMeter_2).getValue(), PRECISION);
    }

    @Test
    public void shouldReturn998989When_minus_1km_1m_1cm_1mm() {
        KiloMeter kiloMeter_1 = (KiloMeter) length.createLength(1, "km");
        Meter meter_1 = (Meter) length.createLength(1, "m");
        CentiMeter centiMeter_1 = (CentiMeter) length.createLength(1, "cm");
        MilliMeter milliMeter_1 = (MilliMeter) length.createLength(1, "mm");

        LengthLib resultLength = kiloMeter_1.minus(meter_1).minus(centiMeter_1).minus(milliMeter_1);

        assertEquals(998989, resultLength.getValue(), PRECISION);
    }

    @Test
    public void shouldReturn0When_1m_multiply_0() {
        Meter meter_1 = (Meter) length.createLength(1, "m");

        assertEquals(0, meter_1.multiply(0).getValue(), PRECISION);
    }

    @Test
    public void shouldReturn3000When_1m_multiply_3() {
        Meter meter_1 = (Meter) length.createLength(1, "m");

        assertEquals(3000, meter_1.multiply(3).getValue(), PRECISION);
    }

    @Test
    public void shouldReturn3000When_1dot5cm_multiply_3dot5() {
        CentiMeter centiMeter_1 = (CentiMeter) length.createLength(1.5, "cm");

        assertEquals(52.5, centiMeter_1.multiply(3.5).getValue(), PRECISION);
    }
}


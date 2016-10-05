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
}

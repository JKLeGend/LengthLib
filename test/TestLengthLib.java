import org.LengthLib;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by jukzhang on 10/5/16.
 */
public class TestLengthLib {
    public static final double PRECISION = 0.000001;

    @Test
    public void shouldReturnTrueWhenGetValueFrom_1m() {
        LengthLib length = new LengthLib(1, "m");

        assertEquals(1.0, length.getValue(), PRECISION);
        assertNotEquals(2.0, length.getValue(), PRECISION);
    }

    @Test
    public void shouldReturnTrueWhen_1m_1m() {
        LengthLib length_1 = new LengthLib(1, "m");
        LengthLib length_2 = new LengthLib(1, "m");

        assertEquals(true, length_1.equals(length_2));
    }

    @Test
    public void shouldReturnFalseWhen_1m_2m() {
        LengthLib length_1 = new LengthLib(1, "m");
        LengthLib length_2 = new LengthLib(2, "m");

        assertNotEquals(true, length_1.equals(length_2));
    }

    @Test
    public void shouldReturnFalseWhen_1m_100cm() {
        LengthLib length_1 = new LengthLib(1, "m");
        LengthLib length_2 = new LengthLib(100, "cm");

        assertEquals(true, length_1.equals(length_2));
    }
}

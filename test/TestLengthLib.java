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
}

import io.maxlab.stringsum.StringCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by maxence on 24/10/16.
 */
public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @Before
    public void Setup() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void emptyString() throws Exception {
        assertEquals("Empty string should return 0",0,stringCalculator.get(""));
    }
}

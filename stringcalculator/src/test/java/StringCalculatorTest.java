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
    public void empty_string() throws Exception {
        assertEquals("Empty string should return 0", 0, stringCalculator.add(""));
    }


    @Test
    public void one_number() throws Exception {
        assertEquals("If there is only one number it should be the result", 1, stringCalculator.add("1"));
    }

    @Test
    public void two_number() throws Exception {
        assertEquals("If there is only one number it should be the result", 3, stringCalculator.add("1,2"));
    }


    @Test
    public void three_number() throws Exception {
        assertEquals("If there is only one number it should be the result", 6, stringCalculator.add("1,2,3"));
    }
}

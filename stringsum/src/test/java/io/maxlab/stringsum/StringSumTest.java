package io.maxlab.stringsum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by maxence on 19/10/16.
 */
public class StringSumTest {

    private StringSum stringSum;

    @Before
    public void setup() {
        stringSum = new StringSum();
    }

    @Test
    public void empty_string_test()  {
        final StringSum stringSum = new StringSum();
        assertEquals("If the string is not a natural number replace it by 0", 0, stringSum.sum("", ""));
    }

    @Test
    public void nominal_case_test()  {
        final StringSum stringSum = new StringSum();
        assertEquals("Expecting the right sum", 3, stringSum.sum("2", "1"));
    }
}

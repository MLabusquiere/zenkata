import io.maxlab.stringsum.StringCalculator;
import io.maxlab.stringsum.exception.NegativeNotAllowed;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        assertEquals("should add two numbers", 3, stringCalculator.add("1,2"));
    }


    @Test
    public void three_number() throws Exception {
        assertEquals("should add the three numbers", 6, stringCalculator.add("1,2,3"));
    }

    @Test
    public void handle_new_line_separtor() throws Exception {
        assertEquals("\n should be a separator", 6, stringCalculator.add("1\n2\n3"));
    }

    @Test
    public void handle_new_line_and_comma_separator() throws Exception {
        assertEquals("handle new line and comma separator as same time", 6, stringCalculator.add("1,2\n3"));
    }

    @Test
    public void handle_separator_as_first_line() throws Exception {
        assertEquals("If the first line is not a number then it's a separator if there is only one char", 6, stringCalculator.add(";\n3;1;2"));
    }


    @Test(expected = NegativeNotAllowed.class)
    public void throw_exception_if_there_is_a_negative_integer() throws Exception {
        stringCalculator.add("-3");
    }

    @Test(expected = NegativeNotAllowed.class)
    public void throw_exception_contianingall_integer_if_there_is_several_negative_integers() throws Exception {
        try {
            stringCalculator.add("-3,-5,4");
        }catch (NegativeNotAllowed e)   {
            String em = e.getMessage();
            assertTrue("The exception message should contain -3", em.contains("-3"));
            assertTrue("The exception message should contain -5", em.contains("-5"));
            assertFalse("The exception message should not contain 4", em.contains("4"));
            throw e;
        }
    }
}

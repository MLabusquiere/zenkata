package io.maxlab.stringsum;

/**
 * Created by maxence on 24/10/16.
 */
public class StringCalculator {
    public int get(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e)   {
            return 0;
        }
    }
}

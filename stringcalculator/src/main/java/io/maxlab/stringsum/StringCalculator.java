package io.maxlab.stringsum;

/**
 * Created by maxence on 24/10/16.
 */
public class StringCalculator {
    public int add(String numbers) {
        Integer result = 0;
        for (String number : numbers.split(",")) {
            try {
                result += Integer.valueOf(number);
            } catch (NumberFormatException ignore) {
            }
        }
        return result;
    }
}

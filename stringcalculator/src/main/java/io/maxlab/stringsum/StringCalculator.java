package io.maxlab.stringsum;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by maxence on 24/10/16.
 */
public class StringCalculator {
    public int add(String numbers) {
        Integer result = 0;
        for (String number : getNumbers(numbers)) {
            try {
                result += Integer.valueOf(number);
            } catch (NumberFormatException ignore) {
            }
        }
        return result;
    }

    private Collection<String> getNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .flatMap(s -> Arrays.stream(s.split("\n")))
                .collect(Collectors.toList());
    }
}

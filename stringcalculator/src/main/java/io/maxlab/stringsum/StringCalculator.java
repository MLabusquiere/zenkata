package io.maxlab.stringsum;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by maxence on 24/10/16.
 */
public class StringCalculator {

    private static final String DEFAULT_SEPARATOR = ",";

    public int add(String input) {
        String separator = getSeparator(input);
        Integer result = 0;
        for (String number : getNumbers(input,separator)) {
            try {
                result += Integer.valueOf(number);
            } catch (NumberFormatException ignore) {}
        }
        return result;
    }

    private String getSeparator(String input) {
        String firstLine = input.split("\n")[0];
        if (firstLine.length() == 1 && !isANumber(firstLine)) {
            return firstLine;
        }
        return DEFAULT_SEPARATOR;
    }

    private boolean isANumber(String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (NumberFormatException ignore) {
            return false;
        }
    }

    private Collection<String> getNumbers(String numbers, String separator) {
        return Arrays.stream(numbers.split("\n"))
                .flatMap(s -> Arrays.stream(s.split(separator)))
                .collect(Collectors.toList());
    }
}

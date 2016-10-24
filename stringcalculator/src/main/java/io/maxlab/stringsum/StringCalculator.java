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
        return getNumbers(input, getSeparator(input))
                .stream()
                .map(this::parseNumber)
                .collect(Collectors.summingInt(i -> i));
    }

    private Integer parseNumber(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException sendDefaultValue) {
            return 0;
        }
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

    private Collection<String> getNumbers(String input, String separator) {
        return Arrays.stream(input.split("\n"))
                .flatMap(s -> Arrays.stream(s.split(separator)))
                .collect(Collectors.toList());
    }
}

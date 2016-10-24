package io.maxlab.stringsum;

import io.maxlab.stringsum.exception.NegativeNotAllowed;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by maxence on 24/10/16.
 */
public class StringCalculator {

    private static final String DEFAULT_SEPARATOR = ",";

    public int add(String input) {
        String separator = getSeparator(input);
        throwExceptionIfNegativeNumber(input, separator);
        return  getNumbers(input, separator)
                .map(this::parseNumber)
                .collect(Collectors.summingInt(i -> i));
    }

    private void throwExceptionIfNegativeNumber(String input, String separator) throws NegativeNotAllowed {
        Predicate<String> isPositiveNumber = this::isPositiveNumber;
        Collection<String> negativesNumbers = getNumbers(input, separator).filter(isPositiveNumber.negate()).collect(Collectors.toList());
        if(!negativesNumbers.isEmpty()) {
            throw new NegativeNotAllowed(negativesNumbers);
        }
    }

    private String getSeparator(String input) {
        String firstLine = input.split("\n")[0];
        return firstLine.length() == 1 && ! isNumber(firstLine) ? firstLine : DEFAULT_SEPARATOR;
    }

    private boolean isPositiveNumber(String number) {
            return parseNumber(number) >= 0;
    }

    private boolean isNumber(String number) {
        try {
            Integer.valueOf(number);
            return true;
        } catch (NumberFormatException sendDefaultValue) {
            return false;
        }
    }

    private Integer parseNumber(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException sendDefaultValue) {
            return 0;
        }
    }

    private Stream<String> getNumbers(String input, String separator) {
        return Arrays.stream(input.split("\n"))
                .flatMap(s -> Arrays.stream(s.split(separator)));
    }
}

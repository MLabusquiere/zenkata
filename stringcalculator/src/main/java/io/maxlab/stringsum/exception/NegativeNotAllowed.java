package io.maxlab.stringsum.exception;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by maxence on 24/10/16.
 */
public class NegativeNotAllowed extends RuntimeException {
    public NegativeNotAllowed(Collection<String> negativesNumbers) {
        super(negativesNumbers.stream().collect(Collectors.joining(",", "The following integers :", "are negative(s)")));

    }
}

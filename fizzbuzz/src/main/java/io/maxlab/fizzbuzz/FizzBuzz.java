package io.maxlab.fizzbuzz;

/**
 * Created by maxence on 19/10/16.
 */
public class FizzBuzz {

    public String getFizzBuzz(int number) {
        StringBuilder builder = new StringBuilder();
        if(number % 3 == 0) {
            builder.append("fizz");
        }
        if(number % 5 == 0) {
            builder.append("buzz");
        }
        return builder.length() == 0 ? String.valueOf(number) : builder.toString();
    }
}

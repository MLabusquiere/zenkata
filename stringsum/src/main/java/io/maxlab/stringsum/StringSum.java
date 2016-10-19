package io.maxlab.stringsum;

/**
 * Created by maxence on 19/10/16.
 */
public class StringSum {

    public int sum(String num1, String num2) {
        return parse(num1) + parse (num2);
    }

    private int parse(String num) {
        try {
            return Integer.valueOf(num);
        } catch(NumberFormatException e)    {
            return 0;
        }
    }
}

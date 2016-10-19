package io.maxlab.stringsum;

/**
 * Created by maxence on 19/10/16.
 */
public class StringSum {

    public static final int DEFAULT_VALUE = 0;

    public int sum(String... nums) {
        int result = DEFAULT_VALUE;
        for (String num : nums) {
            result += parse(num);
        }
        return result;
    }

    private int parse(String num) {
        try {
            Integer res = Integer.valueOf(num.trim());
            return res < 0 ? DEFAULT_VALUE : res;
        } catch(NumberFormatException e)    {
            return DEFAULT_VALUE;
        }
    }
}

package io.maxlab.stringsum;

/**
 * Created by maxence on 19/10/16.
 */
public class StringSum {

    public int sum(String... nums) {
        int result = 0;
        for (String num : nums) {
            result += parse(num);
        }
        return result;
    }

    private int parse(String num) {
        try {
            Integer res = Integer.valueOf(num.trim());
            return res < 0 ? 0 : res;
        } catch(NumberFormatException e)    {
            return 0;
        }
    }
}

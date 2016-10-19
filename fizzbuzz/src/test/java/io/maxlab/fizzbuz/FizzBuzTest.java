package io.maxlab.fizzbuz;

import io.maxlab.FizzBuzz;
import io.maxlab.utils.Tuple;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by maxence on 19/10/16.
 */
public class FizzBuzTest {

    private static final Predicate<Tuple<Integer, String>> DIVISIBLE_BY_THREE = t -> t._left % 3 == 0;
    private static final Predicate<Tuple<Integer, String>> DIVISIBLE_BY_FIVE = t -> t._left % 5 == 0;
    private static final Consumer<Tuple<Integer,String>> ASSERT_FIZZ = t -> assertEquals("All number divised by 3 but not divisible by 5 are replaced by fizz", "fizz",t._right);
    private static final Consumer<Tuple<Integer,String>> ASSERT_BUZZ = t -> assertEquals("All number divised by 5 but not divisible by 3 are replaced by buzz", "buzz",t._right);
    private static final Consumer<Tuple<Integer,String>> ASSERT_FIZZBUZZ = t -> assertEquals("All number divised by 3 and by 5 are replaced by fizzbuzz", "fizzbuzz",t._right);
    //TODO may an assert
    private static final  Consumer<Tuple<Integer, String>> ASSERT_NUMBERS = t -> Integer.valueOf(t._right);

    @Test
    public void fizz_test() {
        generateNumbers()
                .filter(DIVISIBLE_BY_THREE.and(DIVISIBLE_BY_FIVE.negate()))
                .forEach(ASSERT_FIZZ);
    }

    @Test
    public void buzz_test() {
        generateNumbers()
                .filter(DIVISIBLE_BY_FIVE.and(DIVISIBLE_BY_THREE.negate()))
                .forEach(ASSERT_BUZZ);
    }


    @Test
    public void fizzbuzz_test() {
        generateNumbers()
                .filter(DIVISIBLE_BY_THREE.and(DIVISIBLE_BY_FIVE))
                .forEach(ASSERT_FIZZBUZZ);
    }

    @Test
    public void number_test() {
        generateNumbers()
                .filter((DIVISIBLE_BY_THREE.negate()).and(DIVISIBLE_BY_FIVE.negate()))
                .forEach(ASSERT_NUMBERS);
    }

    private Stream<Tuple<Integer, String>> generateNumbers() {
        final FizzBuzz fizzBuzz = new FizzBuzz();
        return IntStream.range(0, 100).mapToObj(Integer::valueOf).map(i -> Tuple.of(i, fizzBuzz.getFizzBuzz(i)));
    }
}

package thirdchapter;

import java.util.stream.Stream;

public class BinaryOperatorsLibrary {

    public void makeBinaryOperator() {
        int sum = Stream.of(5,7,2,5)
                .reduce(0, Integer::sum);
        // or
        int anotherSum = Stream.of(3,6,8,9)
                .mapToInt(Integer::valueOf)
                .sum();

        // max
        int max = Stream.of(6,4,2)
                .reduce(Integer.MIN_VALUE, Integer::max);

        String s = Stream.of("a", "b", "c")
                .reduce("", String::concat);

        // via lambda
        Stream.of("e", "a", "c")
                .reduce("", (x,y) -> x + y);

    }
}

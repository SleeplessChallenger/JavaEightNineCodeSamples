package thirdchapter;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceMethods {
    public void showReduceMethods() {
        // lambda
        int sum = IntStream.rangeClosed(10, 16)
                .reduce((x, y) -> x + y).orElse(0);

        // method reference
        int sumTwo = IntStream.rangeClosed(11, 17)
                .reduce(Integer::sum).orElse(0);

        // example of reduce with initial value
        int sumThree = IntStream.rangeClosed(12, 19)
                .reduce(0, (x, y) -> x + y * 2);

    }

    public void showReduceBinary() {
        int sumValue = Stream.of(1,5,3,6)
                .reduce(0, (x, y) -> (x + y));

        int sumValueReference = Stream.of(5,1,9,3)
                .reduce(0, Integer::sum);

        // find max
        int findMaxWithReduce = Stream.of(9, 2, 1, 5)
                .reduce(Integer.MIN_VALUE, Integer::max);

        int findMaxWithReduceNoReference = Stream.of(6,2,5)
                .reduce(Integer.MIN_VALUE, (x, y) ->Integer.max(x, y));
    }
}

package thirdchapter;

import java.util.Optional;
import java.util.stream.Stream;

public class FirstEleInAStream {
    public void firstEleSearch() {
        Optional<Integer> firstEven = Stream.of(3,6,3,5)
                .filter(n -> n % 2 == 0)
                .findFirst();

        Optional<Integer> firstEvenGT10 = Stream.of(3,1,5,6,3,6,7)
                .filter(n -> n > 10)
                .filter(n -> n % 2 == 0)
                .findFirst();

        Optional<Integer> firstParallel = Stream.of(3,1,4,1,5,9,2,6,5)
                .parallel()
                .filter(n -> n % 2 == 0)
                .findFirst();
    }

    public void exampleOfDelay() {
        Optional<Integer> any = Stream.of(3,1,5,6,4,3)
                .unordered()
                .parallel()
//                .map(this::delay) // method which will process data and has wait
                .findAny();
    }
}

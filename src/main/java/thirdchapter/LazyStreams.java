package thirdchapter;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class LazyStreams {
    public void lazyStream() {
        OptionalInt firstEvenDoubleDibBy3 = IntStream.range(100, 200)
                .map(n -> n * 2) // each value is processed one by one till findIfrst (if filter is passed) => short-circuiting
                .filter(n -> n % 3 == 0)
                .findFirst();
    }
}

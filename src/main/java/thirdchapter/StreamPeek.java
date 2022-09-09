package thirdchapter;

import java.util.stream.IntStream;

public class StreamPeek {
    // example with println
    public int sumDoublesDivisible(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .map(n -> {
                    System.out.println(n);
                    return n;
                })
                .map(n -> n * 2)
                .filter(n -> n % 3 == 0)
                .sum();
    }

    // use peek
    public int sumDoublesPeek(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .peek(n -> System.out.println(n))
                .map(n -> n * 2)
                .peek(n -> System.out.println(n))
                .filter(n -> n % 3 == 0)
                .peek(n -> System.out.println(n))
                .sum();
    }


}

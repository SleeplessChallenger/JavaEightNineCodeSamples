package ninthchapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamsExample {
    public void waysToCreateParallel() {
        boolean isParallel = Stream.of(3, 5, 6, 1, 9).isParallel();
        boolean isParallelTwo = Stream.iterate(1, n -> n + 1).isParallel();
        boolean isParallelThree = Stream.generate(Math::random).isParallel();
        boolean isParallelFour = Arrays.asList(5, 1, 9, 7).stream().isParallel();
    }

    public void createParallelStream() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        boolean isParallel = numbers.parallelStream().isParallel();
        boolean isParallelTwo = numbers.stream().parallel().isParallel();
    }

    // FIXME: doesn't work as expected!
    public void parallelSequentialStreams() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 5, 9);
        List<Integer> nums = numbers.parallelStream()
                .map(n -> n * 2)
                .peek(n -> System.out.printf("%s processing %d%n", Thread.currentThread().getName())) // stateful -> done for all numbers
                .sequential() // this get called after parallel => due to terminating nature of streams, they'll be sequential
                .sorted() // stateful -> done for all numbers
                .collect(Collectors.toList());
    }
}

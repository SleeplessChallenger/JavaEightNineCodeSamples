package ninthchapter;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamsRealWork {

    public static void main(String[] args) {
        sequentialStream();
        parallelStream();
    }

    public static void sequentialStream() {
          Instant before = Instant.now();
          int total = IntStream.of(3, 1, 6, 9, 4)
                  .map(ParallelStreamsRealWork::doubleInt)
                  .sum();
          Instant after = Instant.now();
          Duration duration = Duration.between(before, after);

          System.out.println("Total of doubles = " + total);
          System.out.println("time = " + duration.toMillis() + " ms");
    }

    public static void parallelStream() {
        Instant before = Instant.now();
        int total = IntStream.of(3, 1, 6, 9, 4)
                .parallel()
                .map(ParallelStreamsRealWork::doubleInt)
                .sum();
        Instant after = Instant.now();
        Duration duration = Duration.between(before, after);

        System.out.println("Total of doubles = " + total);
        System.out.println("time = " + duration.toMillis() + " ms");
    }

    private static int doubleInt(int n) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {}

        return n * 2;
    }

    // summation

    // ordinary loop
    public long iterativeSum(int N) {
        long result = 0;
        for (long i = 1L; i <= N; i++) {
            result += i;
        }
        return result;
    }

    // sequential stream
    public long sequentialStreamSum(int N) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(N)
                .reduce(0L, Long::sum);
    }

    // parallel stream
    // FIXME: very bad as uses boxing/unboxing
    public long parallelStreamSum(int N) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(N)
                .parallel()
                .reduce(0L, Long::sum);
    }

    // below are primitives examples
    public long sequentialLongStreamSum(int N) {
        return LongStream.rangeClosed(1, N)
                .sum();
    }

    public long parallelLongStreamSum(int N) {
        return LongStream.rangeClosed(1, N)
                .parallel()
                .sum();
    }

}

package tenthchapter;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsNewFeatures {
    public void nullableStream() {
        Stream<String> notNullStream = Stream.ofNullable("example");
        Stream<String> nullStream = Stream.ofNullable(null);

        long numOne = notNullStream.count(); // 1
        long numTwo = nullStream.count(); // 0
    }

    public void iterateNewSignature() {
//        static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f) - Java 8
//        static<T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next) - Java 9

        List<BigDecimal> eightJava = Stream.iterate(BigDecimal.ONE, bd -> bd.add(BigDecimal.ONE))
                .limit(10)
                .collect(Collectors.toList());

        List<BigDecimal> nineJava = Stream.iterate(BigDecimal.ONE,
                        bd -> bd.longValue() < 10L,
                        bd -> bd.add(BigDecimal.ONE))
                .collect(Collectors.toList());
    }

    public void takeDropWhile() {
        List<String> stringsWhile = Stream.of("this is a nice string")
                .takeWhile(s -> !s.equals("is")) // traverse till !=
                .collect(Collectors.toList()); // TODO: takeWhile is short-circuiting

        List<String> stringsDrop = Stream.of("this is a nice string")
                .dropWhile(s -> !s.equals("is")) // don't add till ==
                .collect(Collectors.toList());

        // example with Random and takeWhile
        Random random = new Random();
        List<Integer> result = random.ints(10, 60, 100)
                .boxed()
                .sorted(Comparator.reverseOrder()) // we applied boxed() as Comparator can't work with primitives
                .takeWhile(n -> n > 90)
                .collect(Collectors.toList());

        List<Integer> resultDrop = random.ints(11, 43, 90)
                .sorted()
                .dropWhile(n -> n < 90)
                .boxed()
                .collect(Collectors.toList());
    }
}

package thirdchapter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public void showStream() {
        //
        String names = Stream.of("Tom", "Jane", "Andrew")
                .collect(Collectors.joining(", "));

        System.out.println(names);

        //
        names = Arrays.stream(new String[]{"Tom", "John"})
                .collect(Collectors.joining(", "));

        Stream.iterate(LocalDate.now(), ld -> ld.plusDays(1L))
                .limit(10)
                .forEach(System.out::println);

//        long count = Stream.generate(Math::random)
//                .limit(10)
//                .forEach(System.out::println);

        List<String> bradyBunch = Arrays.asList("Greg", "Peter");
        bradyBunch.stream()
                .collect(Collectors.joining(","));
        System.out.println(bradyBunch);
    }

    // iterate
    List<BigDecimal> nums = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
            .limit(10)
            .collect(Collectors.toList());

    public void primitiveArray() {
        List<Integer> intArray = IntStream.range(10, 15)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> anotherIntArray = IntStream.rangeClosed(12, 16)
                .boxed()
                .collect(Collectors.toList());
    }

}

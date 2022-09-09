package thirdchapter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatenatingStreamsExample {
    public void concatenateStreamExample() {
        Stream<String> first = Stream.of("a", "b", "c").parallel();
        Stream<String> second = Stream.of("X", "Y", "Z");
        Stream<String> third = Stream.of("g", "l", "c");

        List<String> strings = Stream.concat(Stream.concat(first, second), third)
                .collect(Collectors.toList());

        List<String> stringList = Arrays.asList("a", "b", "c", "X", "Y", "Z", "g", "l", "c");
        // stringList == strings

        // use reduce
        List<String> stringsWithReduce = Stream.of(first, second, third)
                .reduce(Stream.empty(), Stream::concat) // identity is n empty Stream whereas concat is to unite. So, plain reduce like with addition
                .collect(Collectors.toList());

        // use flatMap
        List<String> mapStrings = Stream.of(first, second, third)
                .flatMap(Function.identity())
                .collect(Collectors.toList());
    }
}

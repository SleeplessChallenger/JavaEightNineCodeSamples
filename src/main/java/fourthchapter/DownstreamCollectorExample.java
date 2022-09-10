package fourthchapter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownstreamCollectorExample {
    List<String> strings = Arrays.asList("this", "is", "a", "long", "string");

    private void makeListOfWords() {
        Map<Boolean, List<String>> lengthMap = strings.stream().collect(
                Collectors.partitioningBy(s -> s.length() % 2 == 0)
        );
        lengthMap.forEach((key, value) -> System.out.printf("%5s: %s%n", key, value));
    }

    private void countListOfWords() {
        Map<Boolean, Long> lengthOfWords = strings.stream().collect(
                Collectors.partitioningBy(s -> s.length() % 2 == 0, Collectors.counting())
        );
    }
}

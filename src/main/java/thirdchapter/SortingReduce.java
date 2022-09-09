package thirdchapter;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingReduce {
    public void sortingReduce() {
        List<String> strings = List.of(
                "first", "second", "third"
        );

        BigDecimal total = Stream
                .iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(15)
                .reduce(BigDecimal.ZERO, (acc, val) -> acc.add(val));

        strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}

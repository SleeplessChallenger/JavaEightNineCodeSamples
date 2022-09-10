package fourthchapter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningAndGrouping {
    List<String> strings = Arrays.asList("this", "is", "just", "example");

    public void groupingExample() {
        Map<Boolean, List<String>> lengthMap = strings.stream()
                .collect(Collectors.partitioningBy(s -> s.length() % 2 == 0));

        Map<Boolean, List<String>> lengthMapTwo = strings.stream()
                .collect(Collectors.groupingBy(s -> s.length() % 2 == 0));
    }
}

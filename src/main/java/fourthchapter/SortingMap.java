package fourthchapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingMap {
    public void countStrings(Path dictionary) {
        try (Stream<String> lines = Files.lines(dictionary)) {
            Map<Integer, Long> allLines = lines.filter(s -> s.length() > 20)
                    .collect(Collectors.groupingBy(
                            String::length, Collectors.counting()
                    ));
//                    .forEach((len, num) -> System.out.printf("%d: %d%n", len, num));
            allLines.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .forEach(e -> System.out.printf("Length %d: %2d words %n", e.getKey(), e.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

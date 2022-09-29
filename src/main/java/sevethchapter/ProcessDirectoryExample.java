package sevethchapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// lines - read content of the file
// list - read the content of the directory
// walk - dfs traversal of the whole directory
// find - similar to `walk` but requires you to provide Predicate

public class ProcessDirectoryExample {
    // java.nio.file.Files
    // java.io.BufferedReader
    public static void main(String[] args) {
        readFiles();
    }

    public static void readFiles() {
        // showing words
        try (Stream<String> lines = Files.lines(Paths.get("/usr/share/dict/web2"))) {
            lines.filter(s -> s.length() > 20)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .limit(10)
                    .forEach(w -> System.out.printf("%s (%d)%n", w, w.length()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<String> lines = Files.lines(Paths.get("/usr/share/dict/web2"))) { lines.filter(s -> s.length() > 20)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(10)
                .forEach(w -> System.out.printf("%s (%d)%n", w, w.length()));
        } catch (IOException e) { e.printStackTrace();
        }


        // counting words
        try (Stream<String> lines = Files.lines(Paths.get("/usr/share/dict/web2"))) {
            lines.filter(s -> s.length() > 20)
                    .collect(Collectors.groupingBy(String::length, Collectors.counting()))
                    .forEach((len, num) -> System.out.println(len + ": " + num));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // comparing by key (+ you can do so by value)
        try (Stream<String> lines = Files.lines(Paths.get("/usr/share/dict/web2"))) {
            Map<Integer, Long> mapOfWords = lines.filter(word -> word.length() > 20)
                    .collect(Collectors.groupingBy(String::length, Collectors.counting()));

            mapOfWords.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .forEach(e -> System.out.printf("Length %d: %d words%n", e.getKey(), e.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // With BufferedReader
//        try (Stream<String> lines = new BufferedReader(new FileReader("/usr/share/dict/words").lines())) {
//
//        }
    }
}

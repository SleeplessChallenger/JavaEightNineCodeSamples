package sevethchapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SearchDirWithFind {
    public static void main(String[] args) {
        searchDirectory();
    }

    public static void searchDirectory() {
        try (Stream<Path> paths = Files.find(Paths.get("src/main/java"), Integer.MAX_VALUE,
                // BiPredicate<Path, BasicFileAttributes> matcher
                (path, attributes) -> // attributes is just a meta-info of the current file/folder as `path` is a traversal incarnation
                !attributes.isDirectory() && path.toString().contains("CreateOptional.java"))) {
            paths.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

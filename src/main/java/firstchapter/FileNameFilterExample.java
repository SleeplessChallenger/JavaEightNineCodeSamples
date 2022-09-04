package firstchapter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FileNameFilterExample {
    public static void main(String args) {
        File directory = new File("./src/main/java");
        String[] names = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        FilenameFilter f = (File dir, String name) -> name.endsWith(".class");
        String[] anotherNames = directory.list(f);

        // if more than one line required: block lambda
        String[] superNames = directory.list((File dir, String name) -> {
            return name.endsWith(".json");
        });
    }
}

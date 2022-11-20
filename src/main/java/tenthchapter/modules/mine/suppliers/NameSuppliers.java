package tenthchapter.suppliers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class NameSuppliers implements Supplier<Stream<String>> {
    private final Path namesPath = Paths.get("server/src/main/resources/names.txt");

    @Override
    public Stream<String> get() {
        try {
            return Files.lines(namesPath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

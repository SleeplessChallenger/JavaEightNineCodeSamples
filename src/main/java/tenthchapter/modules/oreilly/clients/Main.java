package tenthchapter.modules.oreilly.clients;

import tenthchapter.suppliers.NameSuppliers;

import java.io.IOException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        NameSuppliers nameSuppliers = new NameSuppliers();

        try (Stream<String> lines = nameSuppliers.get()) { // try-with-resources auto-closes stream
            lines.forEach(line -> System.out.printf("Hello, %s!%n", line));
        }
    }
}

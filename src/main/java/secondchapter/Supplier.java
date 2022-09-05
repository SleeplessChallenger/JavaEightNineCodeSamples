package secondchapter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Supplier {
    public void showSupplier() {
        Logger logger = Logger.getLogger("...");

        // anonymous class
        DoubleSupplier doubleSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };

        // lambda
        DoubleSupplier randomSupplier = () -> Math.random();

        // method reference
        DoubleSupplier anotherRandomSupplier = Math::random;

        //
        List<String> names = Arrays.asList("Tom", "Jerry", "Jane");

        Optional<String> name = names.stream()
                .filter(n -> n.startsWith("T"))
                .findFirst();

        System.out.println(name);
        System.out.println(name.orElse("None"));
        System.out.println(
                name.orElseGet(() -> String.format(
                "No result has been found in %s", name.stream().collect(Collectors.joining(", "))
                ))
        );

    }

}

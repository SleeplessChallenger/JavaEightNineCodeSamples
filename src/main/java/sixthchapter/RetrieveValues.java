package sixthchapter;

import java.util.Optional;
import java.util.stream.Stream;

public class RetrieveValues {
    public static void main(String[] args) {
        Optional<String> firstEven = Stream.of("five", "even", "length", "string", "values")
                .filter(s -> s.length() % 2 == 0)
                .findFirst();

        System.out.println(
                firstEven.orElse("No even length strings were found!")
        );
        System.out.println(
                firstEven.orElseGet(() -> "No even length strings were found!")
        );

    }

    public void retrieveValuesFromOptional() {
        Optional<String> firstEven = Stream.of("five", "even", "length", "string", "values")
                .filter(s -> s.length() % 2 == 0)
                .findFirst();

        System.out.println(firstEven.get()); // Bad practice! Don't do like this
        System.out.println(
                firstEven.isPresent() ? firstEven.get() : "No even length strings were found!"
        );
        // orElseGet - deferred execution. orElse - will always be created. BUT NOT EXECUTED!!!
        System.out.println(
                firstEven.orElse("No even length strings were found!")
        );
        System.out.println(
                firstEven.orElseGet(() -> "No even length strings were found!")
        );

        firstEven.orElseThrow(NoSuchFieldError::new);

        firstEven.ifPresent(val -> System.out.println("Found an even-length string"));

        firstEven = Stream.of("five", "even", "length", "string", "values")
                .filter(s -> s.length() % 2 != 0)
                .findFirst();
    }
}

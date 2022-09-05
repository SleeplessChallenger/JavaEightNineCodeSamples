package secondchapter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {
    public static final Predicate<String> LENGTH_FIVE = s -> s.length() == 5;
    public static final Predicate<String> STARTS_WITH = s -> s.startsWith("s");

    List<String> names = List.of(
            "Jacky", "Tommy", "Andrew"
    );

    public void showPredicate() {

        names.stream()
                .filter(n -> n.length() == 4)
                .collect(Collectors.joining(", "));
    }

    public String findCustomPredicate(Predicate<String> condition, String... names) {
        return Arrays.stream(names)
                .filter(condition)
                .collect(Collectors.joining(", "));
    }

    public void customPredicate() {
        findCustomPredicate(LENGTH_FIVE.and(STARTS_WITH), "Tom", "Anthony");
    }
}

package fifthchapter;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ClosureComposition {

    // example with Function: andThen(), compose()
    public void showComposeAndThen() {
        Function<Integer, Integer> add = x -> x + 2;
        Function<Integer, Integer> mult = x -> x * 2;

        Function<Integer, Integer> multAndAdd = add.compose(mult); // Function inside
        Function<Integer, Integer> addAndMult = add.andThen(mult); // Function inside

        multAndAdd.apply(4);
        addAndMult.apply(8);

        // example
        Function<String, Integer> parseAndThenAdd = add.compose(Integer::parseInt);
        parseAndThenAdd.apply("32");

        // second example
        Function<Integer, String> plus2String = add.andThen(Object::toString);
        plus2String.apply(41);
    }

    // example with Consumer composition: andThen()
    public void showConsumerAndThen() {
        Logger log = Logger.getLogger("...");
        Consumer<String> printer = System.out::println;
        Consumer<String> logger = log::info;

        Consumer<String> printThenLog = printer.andThen(logger);

        Stream.of("this", "is", "example").forEach(printThenLog);
    }

    // example with Predicate: and(), or(), negate()
    public void showPredicateAndThen() {
        IntPredicate perfect = ClosureComposition::isPerfect;
        IntPredicate triangular = ClosureComposition::isTriangular;
        IntPredicate both = triangular.and(perfect);

        IntStream.rangeClosed(1, 9)
//                .filter(both)
                .filter((x) -> isPerfect(x) && isTriangular(x))
                .forEach(System.out::println);
    }

    private static boolean isPerfect(int x) {
        return Math.sqrt(x) % 1 == 0;
    }

    private static boolean isTriangular(int x) {
        double val = (Math.sqrt(8 * x + 1) - 1) / 2;
        return val % 1 == 0;
    }
}

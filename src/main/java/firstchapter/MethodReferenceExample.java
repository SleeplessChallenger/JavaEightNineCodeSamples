package firstchapter;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferenceExample {
    public static void main(String args) {
        // lambda
        Stream.of(3,1,4,6,7,4)
                .forEach(x -> System.out.println(x));

        // method reference
        Stream.of(5,2,8,9)
                .forEach(System.out::println);

        // Consumer: assigning to a functional interface
        Consumer<Integer> printer = System.out::println;
        Stream.of(4,8,1,7,4)
                .forEach(printer);

        // example with generate
        Stream.generate(() -> Math.random())
                .limit(10)
                .forEach((num) -> System.out.println(num));

        // example with reference on static method
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        // first is target and others are arguments
        List<String> strings = Arrays.asList("these", "are", "just", "numbers");
        // using lambda
        List<String> sortedStrings = strings.stream()
                .sorted((x,y) -> x.compareTo(y))
                .collect(Collectors.toList());

        // using method reference
        List<String> sortedStringsReference = strings.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        // class and instance method
        Stream.of("This", "is", "another", "bunch", "of", "Strings")
                .map(String::length)
                .forEach(System.out::println);

        // same without method reference
        Stream.of("This", "is", "without", "method", "reference")
                .map((s) -> s.length())
                .forEach((s) -> System.out.println(s));
    }
}

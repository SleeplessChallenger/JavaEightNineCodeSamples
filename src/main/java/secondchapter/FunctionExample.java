package secondchapter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample {
    public void showExample() {
        List<String> names = Arrays.asList(
                "Tom", "Andrew", "Alex"
        );

        // anonymous function
        List<Integer> nameLengths = names.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                })
                .collect(Collectors.toList());

        // lambda
        nameLengths = names.stream()
                .map((n) -> n.length())
                .collect(Collectors.toList());

        // method reference
        nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());

        int[] result = names.stream()
                .mapToInt(String::length)
                .toArray();
    }
}

package thirdchapter;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class ReductionMethods {

    public void showReduction() {
        String[] strings = "this is a nice string".split(" ");
        long count = Arrays.stream(strings)
                .map(String::length)
                .count();

        // can't sum list, hence use what is below
        List<Integer> totalLength = Arrays.stream(strings)
                .map(String::length)
                .collect(Collectors.toList());

        int totalAllLists = Arrays.stream(strings)
                .mapToInt(String::length)
                .sum();

        OptionalDouble averageLists = Arrays.stream(strings)
                .mapToInt(String::length)
                .average();

        OptionalInt max = Arrays.stream(strings)
                .mapToInt(String::length)
                .max();

        OptionalInt min = Arrays.stream(strings)
                .mapToInt(String::length)
                .min();
    }
}

package thirdchapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class ReduceWithSeparateMethod {
    // first
    public void makeReduce() {
        String result = Stream.of("second", "first")
                .reduce("", (b, a) -> makeHelper(b, a));

        String anotherResult = Stream.of("second", "first")
                .reduce("", this::makeHelper);
    }

    public String makeHelper(String a, String b) {
        if (a.isEmpty()) {
            return b;
        }
        return b + "-" + a;
    }

    // second
    public void produceBiFunction() {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("1", "2", "3");

        List<String> list3 = makeCalculation(list1, list2, (x, y) -> x + y);
    }

    public void produceBiFunctionWithReference() {
        List<Integer> list1 = Arrays.asList(4, 7, 1);
        List<Integer> list2 = Arrays.asList(7, 2, 9);

        List<Boolean> list3 = makeCalculation(list1, list2, this::compareTwoFigures);

    }

    private boolean compareTwoFigures(Integer a, Integer b) {
        return a < b;
    }

    private <T, U, R> List<R> makeCalculation(
            List<T> list1, List<U> list2, BiFunction<T, U, R> combiner
    ) {
        List<R> list3 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            list3.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return list3;
    }

    // composing BiFunction
    private <T, U, R> BiFunction<T, U, R> asBiFunction(BiFunction<T, U, R> function) {
        return function;
    }

    private void useBiFunction() {
        List<Double> list1 = Arrays.asList(1.0d, 2.1d, 3.3d);
        List<Double> list2 = Arrays.asList(0.1d, 0.2d, 4d);

         makeCalculation(list1, list2, asBiFunction(
                 Double::compareTo
         ).andThen(i -> i > 0));
    }
}

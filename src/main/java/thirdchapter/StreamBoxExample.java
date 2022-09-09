package thirdchapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBoxExample {
    public void primitiveShowExample() {
        // code below doesn't compile
//        List<Integer> ints = IntStream.of(3,1,5,7,8)
//                .collect(Collectors.toList());

        // code below is a correct example
        List<Integer> ints = IntStream.of(3, 7, 1, 5)
                .boxed()
                .collect(Collectors.toList());
        int r = Stream.of(4,2,5)
                .mapToInt(Integer::valueOf)
                .sum();

        List<Integer> anotherInts = IntStream.of(8, 1, 2, 5)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());

        List<Integer> alsoAnotherInts = IntStream.of(6, 3, 2, 1)
                .collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);

        Stream.of(3,5,6)
                .reduce(Integer::sum);
    }

    public void anotherPrimitiveExample() {
        int[] ints = IntStream.of(3, 1, 5, 7, 9).toArray();
    }
}

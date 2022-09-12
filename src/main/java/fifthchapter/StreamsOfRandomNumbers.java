package fifthchapter;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamsOfRandomNumbers {
    public void showRandomNumbers() {
        Random r = new Random();

        r.ints(5)
                .sorted()
                .forEach(System.out::println);

        r.doubles(5, 0, 0.5)
                .sorted()
                .forEach(System.out::println);

        List<Long> longs = r.longs(5)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> listOfInts = r.ints(5, 10, 20)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
    }
}

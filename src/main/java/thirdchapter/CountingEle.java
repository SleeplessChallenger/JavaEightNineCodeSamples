package thirdchapter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingEle {

    public void countElements() {
        long countedEle = Stream.of(4,6,3,1)
                .mapToInt(Integer::intValue)
                .count();

        long countEleTwo = Stream.of(6,1,8,3).count();
    }

    public void countWithDownStreamCollector() {
        long count = Stream.of(5,2,8,5,1,9)
                .collect(Collectors.counting());

        String string = new String("also another string");
        Map<Boolean, Long> numberLengthMap = Arrays.asList(string).stream()
                .collect(Collectors.partitioningBy(
                        s -> s.length() % 2 == 0,
                        Collectors.counting()
                ));
    }
}

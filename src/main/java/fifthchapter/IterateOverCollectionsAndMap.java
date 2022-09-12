package fifthchapter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class IterateOverCollectionsAndMap {
    List<Integer> integers = Arrays.asList(3, 1, 4, 7, 2);
    Map<Long, String> map = new HashMap<>();

    // here `forEach()` takes Consumer
    public void traverseOverArrays() {
        // first
        integers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        // second
        integers.forEach((x) -> System.out.println(x));
        // third
        integers.forEach(System.out::println);
    }

    // here `forEach()` takes BiConsumer
    public void traverseHashMap() {
        this.map.put(1L, "First");
        this.map.put(3L, "Second");

        this.map.forEach((num, agent) ->
                System.out.printf("So, the number is %d %s%n", num, agent));
    }
}

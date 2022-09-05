package secondchapter;

import java.util.Arrays;
import java.util.List;

public class Consumer {
    public void forEachExample() {
        List<String> strings = Arrays.asList("this", "is", "a", "list");

        // Anonymous inner class implementation
        strings.forEach(new java.util.function.Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // expression lambda
        strings.forEach(s -> System.out.println(s));

        // method reference
        strings.forEach(System.out::println);
    }
}

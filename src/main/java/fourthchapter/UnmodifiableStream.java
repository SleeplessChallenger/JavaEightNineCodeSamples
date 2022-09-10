package fourthchapter;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class UnmodifiableStream {
    public void createUnmodifiableStream() {
        Map<String, Integer> map = Collections.unmodifiableMap(
                new HashMap<String, Integer>() {{
                    put("first", 1);
                    put("second", 2);
                    put("third", 3);
                }}
        );
    }

    @SafeVarargs
    public final <T> List<T> createUnmodifiableList(T... elements) {
        return Arrays.stream(elements)
                .collect(Collectors.collectingAndThen(toList(), Collections::unmodifiableList));
    }
}

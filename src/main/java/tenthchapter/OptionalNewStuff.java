package tenthchapter;

import java.util.*;
import java.util.stream.Collectors;

public class OptionalNewStuff {
    private final Map<Integer, Integer> cache = new HashMap<>();

    public void useOptional(Integer... ids) {
        List<Integer> foundIds = Arrays.stream(ids)
                .map(this::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        // same, but as Java 9 allows
        List<Integer> newFoundIds = Arrays.stream(ids)
                .map(this::findById)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        // use `or`
        findById(5)
                .or(() -> findBySourceId(43))
                .or(() -> Optional.of(32));

        // use ifPresentOfElse
        findBySourceId(32).
                ifPresentOrElse(System.out::println, () -> System.out.println("Here it is!"));
    }

    private Optional<Integer> findById(int id) {
        return Optional.ofNullable(cache.get(id));
    }

    private Optional<Integer> findBySourceId(int sourceId) {
        return Optional.ofNullable(cache.get(sourceId));
    }

}

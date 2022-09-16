package sixthchapter;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateOptional {

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();
        Optional<AtomicInteger> opt = Optional.ofNullable(counter);

        System.out.println(opt);

        counter.incrementAndGet();
        System.out.println(opt);

        opt.get().incrementAndGet();
        System.out.println(opt);

        opt = Optional.ofNullable(new AtomicInteger());
        System.out.println(opt);

        Optional<Object> currOptional = Optional.empty();
    }

    public static <T> Optional<T> createOptionalTheHardWay(T value) {
        // former approach is more verbose whilst the latter is better
//        return value == null ? Optional.empty() : Optional.of(value);
        return Optional.ofNullable(value);
    }

    public static OptionalInt createPrimitive() {
        return OptionalInt.of(4);
    }
}

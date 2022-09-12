package fifthchapter;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// we defined interface with Exception
@FunctionalInterface
interface FunctionWithException<T, R, E extends Exception> {
    R apply(T t) throws E;
}

public class GenericExceptionWrapper {


    private <T, R, E extends Exception> Function<T, R> wrapper(FunctionWithException<T, R, E> fe) {
        // inside `fe` we have URLEncoder. But how it appears in `arg`?
        return arg -> {
            try {
                return fe.apply(arg);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public List<String> encodeValuesWithWrapper(String... values) {
        return Arrays.stream(values)
                .map(wrapper(s -> URLEncoder.encode(s, "UTF-8")))
                .collect(Collectors.toList());
    }
}

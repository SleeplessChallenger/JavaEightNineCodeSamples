package fifthchapter;

import java.util.List;
import java.util.stream.Collectors;

public class ExceptionHandling {

    // ugly way
    public List<Integer> div(List<Integer> values, Integer factor) {
        return values.stream()
                .map(n -> {
                    try {
                        return n / factor;
                    } catch (ArithmeticException e) {
                        e.printStackTrace();
                        // just stub
                        return 0;
                    }
                })
                .collect(Collectors.toList());
    }

    // more concise way
    public List<Integer> divBetter(List<Integer> values, Integer factor) {
        return values.stream()
                .map(n -> divide(n, factor))
                .collect(Collectors.toList());
    }

    private Integer divide(Integer value, Integer factor) {
        try {
            return value / factor;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            // just stub
            return 0;
        }
    }

}

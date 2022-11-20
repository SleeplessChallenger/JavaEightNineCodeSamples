package tenthchapter;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public interface JavaPrivateMethodsInterface {
    default int SumNumbers(int... nums) {
        return add(n -> n % 2 == 0, nums);
    }

    default int addOdds(int... nums) {
        return add(n -> n % 2 != 0, nums);
    }

    private int add(IntPredicate predicate, int... nums) {
        return IntStream.of(nums)
                .filter(predicate)
                .sum();
    }
}

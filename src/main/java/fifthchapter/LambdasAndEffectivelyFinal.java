package fifthchapter;

import java.util.Arrays;
import java.util.List;

public class LambdasAndEffectivelyFinal {
    List<Integer> nums = Arrays.asList(3, 1, 4, 5, 9);

    public void showLambda() {
        // first example
        int total = 0;
        for (int n : nums) {
            total += n;
        }

        // second example: won't compile
//        total = 0;
//        nums.forEach(n -> total += n);

        // third example: using Stream API
        total = nums.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}

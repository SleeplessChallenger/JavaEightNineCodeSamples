package thirdchapter;

import java.util.stream.IntStream;

public class MatchesExample {

    public void makeMatch(int num) {
        int limit = (int) (Math.sqrt(num) + 1);
        boolean res = num == 2 || num > 1 && IntStream.range(2, limit)
                .noneMatch(divisor -> num % divisor == 0);

        boolean resOne = num == 2 || num > 1 && IntStream.range(2, limit)
                .anyMatch(divisor -> num % divisor == 0);

        boolean resTwo = num == 2 || num > 1 && IntStream.range(2, limit)
                .allMatch(divisor -> num % divisor == 0);
    }
}

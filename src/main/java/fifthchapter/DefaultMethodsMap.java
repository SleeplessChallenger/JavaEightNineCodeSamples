package fifthchapter;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DefaultMethodsMap {
    private final Map<Long, BigInteger> cache = new HashMap<>();

    // inefficient
    long fib(long i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fib(i - 1) + fib(i - 2);
    }

    // efficient
    public BigInteger fibEfficient(long i) {
        if (i == 0) return BigInteger.ZERO;
        if (i == 1) return BigInteger.ONE;

        return cache.computeIfAbsent(i, n -> fibEfficient(n - 2).add(fibEfficient(n - 1)));
    }

    public Map<String, Integer> countWords(String passage, String... strings) {
        Map<String, Integer> wordCounts = new HashMap<>();

        Arrays.stream(strings).forEach(s -> wordCounts.put(s, 0));

        Arrays.stream(passage.split(" ")).forEach(word -> wordCounts.computeIfPresent(
                word, (key, val) -> val + 1
        ));

        return wordCounts;
    }

    public void replaceValues() {
        Map<String, Integer> hashMap = new HashMap<>(Map.of(
                "A", 5,
                "B", 7
        ));
        hashMap.replace("A", 54);
        hashMap.replace("B", 7, 23);
    }

    public Map<String, Integer> fullWordCounts(String passage) {
        Map<String, Integer> wordCounts = new HashMap<>();
        String testString = passage.toLowerCase().replaceAll("\\W", " ");

        Arrays.stream(testString.split("\\s+")).forEach(word -> wordCounts.merge(word, 1, Integer::sum));
        // key, default value if key mot present, BinaryOperator for key if present

        // below is just a count for SPECIFIC words
        Map<String, Integer> counts = countWords(passage, "NSA", "agent", "joke");
        counts.forEach((word, count) -> System.out.println(word + "=" + count));

        return wordCounts;
    }
}

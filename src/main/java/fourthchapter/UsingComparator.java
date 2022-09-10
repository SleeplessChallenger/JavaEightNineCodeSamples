package fourthchapter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsingComparator {
    private List<String> sampleStrings = Arrays.asList("this", "is", "a", "list", "of");

    private static class Golfer {
        private String first;
        private String last;
        private int score;

        public Golfer(String first, String last, int score) {
            this.first = first;
            this.last = last;
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public String getFirst() {
            return first;
        }

        public String getLast() {
            return last;
        }
    }

    public void defaultSort() {
        Collections.sort(sampleStrings);
    }

    public void defaultSortUsingStreams() {
        sampleStrings.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // two below are the same
    public List<String> compareByLength() {
        return sampleStrings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
    }

    public List<String> compareByLengthWay() {
        return sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
    //

    public List<String> lengthSortThenAlphaSort() {
        return sampleStrings.stream()
                .sorted(Comparator.comparing(String::length) // (x, y) -> x.length() - y.length()
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    // Golfer stuff
    private List<Golfer> golfers = Arrays.asList(
            new Golfer("Jack", "Nick", 68),
            new Golfer("Tom", "Brown", 98),
            new Golfer("Andrew", "Johnson", 42)
    );

    public List<Golfer> sortByScoreThenLast() {
        return golfers.stream()
                .sorted(Comparator.comparingInt(Golfer::getScore)
                        .thenComparing(Golfer::getLast)
                        .thenComparing(Golfer::getFirst))
                .collect(Collectors.toList());
    }
}

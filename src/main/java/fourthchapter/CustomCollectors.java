//package fourthchapter;
//
//import thirdchapter.Collector;
//
//import java.util.Collections;
//import java.util.SortedSet;
//import java.util.TreeSet;
//import java.util.stream.Stream;
//
//public class CustomCollectors {
//    // supplier, accumulator, combiner, finisher, characteristics
//
//     // TODO: below is an example which is correct in the book, but somehow buggy here
//    public SortedSet<String> createCustomSet(String... strings) {
//        Collector<String, ?, SortedSet<String>> intoSet =
//                Collector.of(TreeSet<String>::new, // supplier
//                        SortedSet::add, // accumulator
//                        (left, right) -> { // combiner
//                            left.addAll(right);
//                            return left;
//                        },
//                        Collections::unmodifiableSortedSet // finisher
//                );
//
//        return Stream.of(strings)
//                .filter(s -> s.length() % 2 == 0)
//                .collect(intoSet);
//
//    }
//}

package tenthchapter;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsFactory {

    private static class Holder {
        private int x;

        public Holder(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public void setX(int newX) {
            this.x = newX;
        }
    }

    public void showCollectionsFactory() {
        List<Integer> allInts = List.of(4, 6, 8);
        Set<String> allStrings = Set.of("fd", "fc");

        // alas, if inside are mutable objects -> can be changed
        List<Holder> allHolders = List.of(new Holder(43), new Holder(12));
        allHolders.get(0).setX(98);

        // Maps example
        Map<String, String> simpleMap = Map.of(
                "Java", "Classic",
                "Kotlin", "Stylish",
                "Scala", "functional"
        );
        Map<String, String> complexMap = Map.ofEntries(
                Map.entry("Java", "Classic"),
                Map.entry("Kotlin", "Stylish"),
                Map.entry("Scala", "Cool")
        );

//        complexMap.forEach((k, v) ->
//                simpleMap.keySet().contains(k) && simpleMap.values().contains(v)
//        );
    }

}

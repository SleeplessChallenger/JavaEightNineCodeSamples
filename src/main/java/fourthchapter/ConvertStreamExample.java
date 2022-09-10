package fourthchapter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertStreamExample {

    private static class Actor {
        private String name;
        private String role;

        public Actor(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }
    }

    public void makeCollection() {
        // 2 default data structures
        List<String> superHeroes = Stream.of("mr. A", "mr. B", "mr. C")
                .collect(Collectors.toList());
        Set<String> villains = Stream.of("mr. Z", "mr. N", "mr. M")
                .collect(Collectors.toSet());

        // custom data structure: use toCollection
        List<String> actors = Stream.of("P", "A", "C")
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public void convertToArray() {
        // two examples of `toArray()`: first is concrete type and second is general
        String[] wannabes = Stream.of("waffler", "avenger", "psychologist")
                .toArray(String[]::new);
        Object[] objectWannabes = Stream.of("waffler two", "avenger two")
                .toArray();
    }

    public void convertToMap() {
        List<Actor> allActors = List.of(new Actor("Tom", "Main"), new Actor("Jil", "second"));
        Map<String, String> actorSet = allActors.stream()
                .collect(Collectors.toMap(Actor::getName, Actor::getRole));
        actorSet.forEach((key, value) ->
                System.out.printf("%s played %s %n", key, value));
    }
}

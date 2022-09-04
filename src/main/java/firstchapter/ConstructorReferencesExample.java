package firstchapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructorReferencesExample {

    private class Person {
        private String name;
        private String names;

        public Person(String name) {
            this.name = name;
        }

        public Person(String... name) {
            this.names = Arrays.stream(name)
                    .collect(Collectors.joining(" "));
        }
    }

    private class ManyPeople {
        String names;

        public ManyPeople(String... people) {
            this.names = Arrays.stream(people)
                    .collect(Collectors.joining(":"));
        }
    }

    public void personCreator(String args) {
        List<String> allNames = Arrays.asList(
                "Tony", "Peter", "Andrew", "John"
        );

        // First part
        // plain lambda
        List<Person> people = allNames.stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());

        // constructor reference
        List<Person> peopleAlso = allNames.stream()
                .map(Person::new)
                .collect(Collectors.toList());

        // second part
        List<String> names = List.of(
                "Jack Tom Andy"
        );
        allNames.stream()
                .map(n -> n.split(" "))
                .map(Person::new)
                .collect(Collectors.toList());

        Person[] allPeople = allNames.stream()
                .map(Person::new)
                .toArray(Person[]::new);
    }
}

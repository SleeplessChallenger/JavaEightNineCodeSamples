package appendix;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomComparatorExample {
    private static class Employee {
        private int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    List<Employee> allEmployees = Arrays.asList(
            new Employee(21, "A"),
            new Employee(54, "B"),
            new Employee(10, "C")
    );

    public void compareEmployees() {
        // at first two less idiomatic approaches
        Employee maxId = allEmployees.stream()
                .max(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return o1.getId() - o2.getId();
                    }
                }).orElse(new Employee(1, "Top"));

        Employee maxName = allEmployees.stream()
                .max(new Comparator<Object>() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return o1.toString().compareTo(o2.toString());
                    }
                }).orElse(new Employee(2, "Next Top"));

        // next, two more idiomatic ways

        Employee idiomaticMaxId = allEmployees.stream()
                .max(Comparator.comparingInt(Employee::getId))
                .orElse(new Employee(1, "Top"));

        Employee idiomaticMaxName = allEmployees.stream()
                .max(Comparator.comparing(Objects::toString))
                .orElse(new Employee(2, "Also Top"));
    }

    public void mapWithGenerics() {
        Map<Integer, Employee> employeesMap = allEmployees.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));

        employeesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // as in our Map key is
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ".." + entry.getValue());
                });

        employeesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getName)))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ".." + entry.getValue());
                });
    }

}

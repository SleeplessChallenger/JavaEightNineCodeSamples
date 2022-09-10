package fourthchapter;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class FindMaxMinValues {
    public static class Employee {
        private String name;
        private Integer salary;

        public Employee(String name, Integer salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public Integer getSalary() {
            return salary;
        }
    }

    List<Employee> employees = Arrays.asList(
            new Employee("A", 250_000),
            new Employee("B", 300_000),
            new Employee("C", 210_000)
    );
    Employee defaultEmployee = new Employee("Q", 0);

    public void useCustomOperator() {
        // first way: find salary
        Optional<Integer> maxSalaryOne = employees.stream()
                .map(Employee::getSalary)
                .reduce(Integer::max);

        // with mapToInt
        OptionalInt maxSalaryOneSecondWay = employees.stream()
                .mapToInt(Employee::getSalary)
                .max();

        // second way: find employee by salary
        Optional<Employee> maxSalaryTwo = employees.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(Employee::getSalary)));

        // if used plain lambda
        employees.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(employee -> employee.getSalary())));

        // third way: max on the stream
        Optional<Employee> maxSalaryThree = employees.stream()
                .max(Comparator.comparingInt(Employee::getSalary));

        // fourth way: using Collectors
        Optional<Employee> optionalEmpSalary = employees.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));

        // way to use downstream collector (why bother using Collectors for max)
        Map<String, Optional<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        Collectors.maxBy(
                                Comparator.comparingInt(Employee::getSalary)
                        )
                ));
    }
}

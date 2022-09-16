package sixthchapter;

import fourthchapter.FindMaxMinValues;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MappingOptionals {
    public static class Employee {
        private int currId;

        public Employee(int currId) {
            this.currId = currId;
        }
    }

    public Optional<Employee> findEmployeeById(int id) {
        return Optional.ofNullable(new Employee(32)); // just stub
    }

    public List<Employee> findEmployeesByIds(List<Integer> ids) {
        return ids.stream()
                .map(this::findEmployeeById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<Employee> findEmployeesByIdsWithOptionalMap(List<Integer> ids) {
        return ids.stream()
                .map(this::findEmployeeById)// Stream of many Optional
                .flatMap(optional -> // here `optional` is an element from previous map. We have list of Optional => apply map() on each
                        optional.map(Stream::of) // Stream of each Optional of single Stream of Employee
                                .orElseGet(Stream::empty)) // flatMap keeps only non-empty Optional
                .collect(Collectors.toList());
    }
}

package tenthchapter;

import java.util.*;
import java.util.stream.Collectors;

public class DownstreamNewMethods {
    private static class Developer {
        private String name;

        public Developer(String name) {
            this.name = name;
        }
    }

    private static class Task {
        private String taskName;
        private long budget;
        private List<Developer> allDevs = new ArrayList<>();

        public Task(String taskName, long budget) {
            this.taskName = taskName;
            this.budget = budget;
        }

        public long getBudget() {
            return budget;
        }

        public String getTaskName() {
            return taskName;
        }

        public List<Developer> getAllDevs() {
            return allDevs;
        }
    }

    public void showNewMethods() {
        Developer first = new Developer("A");
        Developer second = new Developer("B");
        Developer third = new Developer("C");

        Task firstTask = new Task("J", 12);
        Task secondTask = new Task("D", 43);
        Task thirdTask = new Task("Z", 9);

        firstTask.allDevs.add(first);
        firstTask.allDevs.add(third);

        secondTask.allDevs.add(second);
        secondTask.allDevs.add(third);

        thirdTask.allDevs.add(first);
        thirdTask.allDevs.add(second);

        List<Task> allTasks = Arrays.asList(firstTask, secondTask, thirdTask);

        Map<Long, List<Task>> taskMap = allTasks.stream()
                .collect(Collectors.groupingBy(Task::getBudget));

        // Java 8 filter
        taskMap = allTasks.stream()
                .filter(task -> task.getBudget() > 10)
                .collect(Collectors.groupingBy(Task::getBudget));

        // Java 9 filtering. Difference is that all keys will be present, even if some values are missing
        taskMap = allTasks.stream()
                .collect(Collectors.groupingBy(
                                Task::getBudget,
                        Collectors.filtering(task -> task.getBudget() > 50, Collectors.toList())
                        )
                );

        // flattening

        // first
        Map<String, List<Task>> taskByName = allTasks.stream()
                .collect(Collectors.groupingBy(Task::getTaskName));

        // second
        Map<String, Set<List<Developer>>> taskByNameTwo = allTasks.stream()
                .collect(Collectors.groupingBy(Task::getTaskName,
                        Collectors.mapping(Task::getAllDevs, Collectors.toSet())));

        // third
        Map<String, Set<Developer>> taskByNameThree = allTasks.stream()
                .collect(Collectors.groupingBy(Task::getTaskName,
                        Collectors.flatMapping(task -> task.getAllDevs().stream(), Collectors.toSet())));
        // TODO: argument of flatMapping is a stream()
    }
}

package thirdchapter;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class SummaryStatsExample {

    class Team {
        private int id;
        private String name;
        private double salary;

        public Team(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }
    }

    public static void main(String[] args) {
        DoubleSummaryStatistics doubleSummaryStatistics = DoubleStream.generate(Math::random)
                .limit(1_000_000)
                .summaryStatistics();
        System.out.println(doubleSummaryStatistics);
    }

    public void countTeams() {
        List<Team> teams = List.of(new Team(1, "aa", 87.0), new Team(2, "ab", 54.3));

        // `accept` - adds value to exisitng object and `combine` adds them together
        DoubleSummaryStatistics doubleSummaryStatistics = teams.stream()
                .mapToDouble(Team::getSalary)
                .collect(DoubleSummaryStatistics::new,
                        DoubleSummaryStatistics::accept,
                        DoubleSummaryStatistics::combine);

        DoubleSummaryStatistics teamStats = teams.stream()
                .collect(Collectors.summarizingDouble(Team::getSalary));
    }
}

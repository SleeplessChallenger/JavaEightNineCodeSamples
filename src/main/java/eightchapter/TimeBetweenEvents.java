package eightchapter;

import java.time.*;
import java.time.temporal.ChronoUnit;

// between || until on temporal classes (ChronoUnit)
// between Period
// Duration - for seconds and nanoseconds
public class TimeBetweenEvents {
    public void makeCalculationUsingTemporal() {
        // TODO: using `between`
        LocalDate electionDay = LocalDate.of(2020, Month.NOVEMBER, 3);
        LocalDate today = LocalDate.now();
        System.out.printf("%d day(s) to go... %n", ChronoUnit.DAYS.between(today, electionDay));
    }

    public void makeCalculationResultingPeriod() {
        // TODO: using `until`
        LocalDate electionDay = LocalDate.of(2020, Month.NOVEMBER, 3);
        LocalDate today = LocalDate.now();

        Period until = today.until(electionDay);
        Period alsoUntil = Period.between(today, electionDay);

        int years = until.getYears();
        int months = until.getMonths();
        int days = until.getDays();
    }

    public void showCasingDurationClass(Instant start, Instant end) {
        double res = Duration.between(start, end).toMillis() / 1000.0;

    }
}

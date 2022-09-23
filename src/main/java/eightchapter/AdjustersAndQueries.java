package eightchapter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class AdjustersAndQueries {

    // using TemporalAdjuster
    public void existingAdjusters() throws Exception {
        LocalDateTime start = LocalDateTime.of(2017, Month.FEBRUARY, 2, 11, 30);
        LocalDateTime end = start.with(TemporalAdjusters.firstDayOfNextMonth());
        "2017-03-01T11:30".equals(end.toString());

        end = start.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        "2017-02-09T11:30".equals(end.toString());

        end = start.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
        "2017-02-02T11:30".equals(end.toString());
    }
}

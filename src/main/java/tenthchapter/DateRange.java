package tenthchapter;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class DateRange {

    // Java 8 approach
    public List<LocalDate> getDaysForRange(LocalDate start, LocalDate end) {
//        Period period = start.until(end);
        return LongStream.range(0, ChronoUnit.DAYS.between(start, end)) // correct way to create range. Instead of naive above
                .mapToObj(start::plusDays)
                .collect(Collectors.toList());
    }

    // Java 9 approach
    public void getDaysAlsoJavaNine(LocalDate start, LocalDate end) {
        List<LocalDate> allDatesOne = start.datesUntil(end)
                .collect(Collectors.toList());
        List<LocalDate> allDatesTwo = start.datesUntil(end, Period.ofYears(3))
                .collect(Collectors.toList());
    }
}

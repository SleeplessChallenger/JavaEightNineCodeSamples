package eightchapter;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// TODO: Period is to make overall change: `2017 02 05` -> `2019 06 09`
// TODO: Period == TemporalAmount
// TODO: `LocalDateTime plus(long amountToAdd, TemporalUnit unit)`, `LocalDateTime plus(TemporalAmount amountToAdd)`
// TODO: `LocalDateTime with(TemporalField field, long newValue)`, `LocalDateTime with(TemporalAdjuster adjuster)`

// LocalDate, LocalTime, LocalDateTime, ZonedDateTime are all immutable
public class CreatingDatsTimesFromExistingInstances {

    // LocalDate plusDays(long daysToAdd)
    // LocalDate plusWeeks(long weeksToAdd)
    // LocalDate plusMonths(long monthsToAdd)
    // LocalDate plusYears(long yearsToAdd)
    public static void plusDates() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.of(2017, Month.FEBRUARY, 2);

        LocalDate end = start.plusDays(5);

        assert "2017-02-07".equals(end.format(formatter));

        LocalDate anotherEnd = start.plusMonths(2);

        assert "2017-04-02".equals(anotherEnd.format(formatter));
    }

    // LocalTime plusNanos(long nanosToAdd)
    // LocalTime plusSeconds(long secondsToAdd)
    // LocalTime plusMinutes(long minutesToAdd)
    // LocalTime plusHours(long hoursToAdd)
    public static void plusTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;

        LocalTime start = LocalTime.of(11, 30, 0, 0);
        LocalTime end = start.plusNanos(1_000_000);

        assert "11:30::00.001".equals(end.format(dateTimeFormatter));

    }

    public static void additionalMethods() {
        Period period = Period.of(2, 3, 4);
        LocalDateTime start = LocalDateTime.of(2017, Month.FEBRUARY, 2, 11, 30);
        LocalDateTime end = start.plus(period);

        "2019-05-06T11:30:00".equals(end.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        end = start.plus(3, ChronoUnit.HALF_DAYS);
    }

    // LocalDateTime withNano(int nanoOfSeconds)
    // LocalDateTime withSecond(int second)
    // LocalDateTime withMinute(int minute)
    // LocalDateTime withHour(int hour)
    // LocalDateTime withDayOfMonth(int dayOfMonth)
    // LocalDateTime withDayOfYear(int dayOfYear)
    // LocalDateTime withMonth(int month)
    // LocalDateTime withYear(int year)
    public static void withExamples() {
        LocalDateTime start = LocalDateTime.of(2017, Month.FEBRUARY, 2, 11, 30);
        LocalDateTime end = start.withMinute(45); // it swaps for provided value

        "2017-02-02T11:45:00".equals(end.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        end.withHour(16);
        "2017-02-02T16:30:00".equals(end.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}

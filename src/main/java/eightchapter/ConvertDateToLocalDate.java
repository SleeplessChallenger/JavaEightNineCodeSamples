package eightchapter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;

// convert from .Date & .Calendar to java.time
public class ConvertDateToLocalDate {
    // TODO: first major approach is to use Instant

    // 1. convert to Instant -> Instant
    // 2. apply atZone -> ZonedDateTime
    // 3. extract LocalDate -> LocalDate
    public LocalDate convertFromUtilDateUsingInstant(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    // TODO: (not an approach from Date to Date/Time, but mainly from sql-related classes to Date/Time)
    //  use java.sql.Date and java.sql.Timestamp

    // 2.1
    public LocalDate convertToLocalDate(java.sql.Date date) {
        return date.toLocalDate();
    }

    public java.sql.Date convertFromLocalDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }

    // 2.2
    public LocalDateTime convertToLocalDateTime(java.sql.Timestamp date) {
        return date.toLocalDateTime();
    }

    public java.sql.Timestamp convertFromLocalDateTime(LocalDateTime date) {
        return java.sql.Timestamp.valueOf(date);
    }

    // TODO: real second major approach: input is Date, convert to sql.Date, extract LocalDate
    public LocalDate convertFromDateToLocalDate(Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate();
    }

    // continue: if using Calendar
    public ZonedDateTime convertToZonedDateTime(Calendar calendar) {
        return ZonedDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
    }

    public LocalDateTime convertFromCalendarUsingGetters(Calendar calendar) {
        return LocalDateTime.of(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND));
    }
 }

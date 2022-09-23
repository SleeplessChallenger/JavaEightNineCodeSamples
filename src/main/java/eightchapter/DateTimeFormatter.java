package eightchapter;

import java.time.*;
import java.time.format.FormatStyle;
import java.util.Locale;

// 1. create formatter 2. __.format(ourFormatter)
public class DateTimeFormatter {
    public void makeFormatting() {
        // first
        LocalDateTime now = LocalDateTime.now();
        String text = now.format(java.time.format.DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime dateTime = LocalDateTime.parse(text);

        // second
        LocalDate date = LocalDate.of(2017, Month.MARCH, 13);
        System.out.println("Full : "
                + date.format(java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))
        );
        System.out.println("Full : "
            + date.format(java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.FRANCE))
        );
    }

    public void ownPatternCreation() {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                LocalDate.of(1969, Month.JULY, 20),
                LocalTime.of(20, 10),
                ZoneId.of("UTC")
        );
        java.time.format.DateTimeFormatter dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(
                "uuuu/MMMM/dd hh:mm:ss a zzz GG"
        );
        zonedDateTime.format(dateTimeFormatter);
    }
}

package eightchapter;

import javax.sound.midi.SysexMessage;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;
import java.util.Date;

public class UnusualTimeZones {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        ZonedDateTime current = instant.atZone(ZoneId.systemDefault());
        System.out.printf("Current time is %S%n%n", current);

        System.out.printf("%10s %20s %13s%n", "Offset", "ZoneId", "Time");

        ZoneId.getAvailableZoneIds().stream()
                .map(ZoneId::of)
                .filter(zoneId -> {
                    ZoneOffset offset = instant.atZone(zoneId).getOffset(); // take `instant` from above and get offset from it
                    return offset.getTotalSeconds() % (60 * 60) != 0; // still we get only Ids as it is filter, hence it only assesses
                })
                .sorted(Comparator.comparingInt(zoneId ->
                        instant.atZone(zoneId).getOffset().getTotalSeconds()))
                .forEach(zoneId -> {
                    ZonedDateTime zdt = current.withZoneSameInstant(zoneId);
                    System.out.printf("%10s %25s %10s%n", zdt.getOffset(), zoneId,
                            zdt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
                });
    }
}

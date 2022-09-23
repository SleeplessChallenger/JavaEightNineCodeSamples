package eightchapter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FindRegionNamesFromOffsets {
    public static List<String> getRegionNamesForOffset(ZoneOffset offset) {
        LocalDateTime now = LocalDateTime.now();
        return ZoneId.getAvailableZoneIds().stream()
                .map(ZoneId::of)
                .filter(zoneId -> now.atZone(zoneId).getOffset().equals(offset))
                .map(ZoneId::toString)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> getRegionNamesForZoneId(ZoneId zoneId) {
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zdt = now.atZone(zoneId);
        ZoneOffset offset = zdt.getOffset();

        return getRegionNamesForOffset(offset);
    }

    public static List<String> getRegionNamesForSystemDefault() {
        ZonedDateTime zdtNow = ZonedDateTime.now();
        ZoneId zoneId = zdtNow.getZone();
        return getRegionNamesForZoneId(zoneId);
    }

    public static List<String> getRegionNamesForOffset(int hours, int minutes) {
        ZoneOffset offset = ZoneOffset.ofHoursMinutes(hours, minutes);
        return getRegionNamesForOffset(offset);
    }
}

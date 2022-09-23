package eightchapter;

import java.time.*;
import java.util.Set;
/*
of static
from static
parse static

format Instance
get Instance
is Instance
with Instance
plus, minus
to Instance
at Instance
*/

// Date-Time package
public class BasicClasses {
    public static void main(String[] args) {
//        useTimePackage();
//        useTimePackageOfFeature();
//        showAllZones();
        monthMethods();
    }

    public static void useTimePackage() {
        System.out.println("Instant.now(): " + Instant.now());
        System.out.println("LocalDate.now(): " + LocalDate.now());
        System.out.println("LocalTime.now(): " + LocalTime.now());
        System.out.println("LocalDateTime.now(): " + LocalDateTime.now());
        System.out.println("ZonedDateTime.now(): " + ZonedDateTime.now());
    }

    public static void useTimePackageOfFeature() {
        System.out.println("New method");
        LocalDate localDate = LocalDate.of(1969, Month.JULY, 20);
        LocalTime localTime = LocalTime.of(20, 18);
        System.out.println("Date " + localDate);
        System.out.println("Local Time " + localTime);

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);
    }

    public static void showAllZones() {
        Set<String> regionNames = ZoneId.getAvailableZoneIds();
        System.out.println("There are " + regionNames.size() + " region names");
    }

    public void applyingZonedDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(
                2017, Month.JULY, 4, 13, 20, 10
        );
        ZonedDateTime nyc = localDateTime.atZone(ZoneId.of("America/New_York"));

        ZonedDateTime london = nyc.withZoneSameInstant(ZoneId.of("Europe/London"));
    }

    // 2 Enums in the class: Month and DayOfWeek
    public static void monthMethods() {
        System.out.println("Days in Feb: " + Month.FEBRUARY.length(true)); // true means leap year
        System.out.println(Month.AUGUST.firstDayOfYear(true));
        System.out.println(Month.of(1));
        System.out.println(Month.JULY.minus(2));
        System.out.println(Month.AUGUST.plus(3));
        Month newMonth = Month.JANUARY.plus(4);
    }
}

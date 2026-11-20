package datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculatesDateTime {
    public static void main(String[]args) {
        LocalDate d04 = LocalDate.parse("2026-11-19");
        LocalDateTime d05 = LocalDateTime.parse("2026-11-19T20:52");
        Instant d06 = Instant.parse("2026-11-19T23:52:01Z");

        LocalDate pastWeekLocalDate = d04.minusDays(7);
        LocalDate nextWeekLocalDate = d04.plusDays(7);

        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
        System.out.println("");

        LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = d05.plusDays(7).plusHours(2);

        System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
        System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);
        System.out.println("");

        Instant pastWeekInstant = d06.minus(10, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(10, ChronoUnit.DAYS).plus(1, ChronoUnit.HOURS);

        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);
        System.out.println("");

        // Duration between two dates

        Duration t1 = Duration.between(pastWeekInstant, nextWeekInstant);
        Duration t2 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay()); // Needed to convert
        Duration t3 = Duration.between(pastWeekLocalDateTime, d05);
        Duration t4 = Duration.between(nextWeekInstant, pastWeekInstant);



        System.out.println("Duration(DAYS) Between (pastWeekInstant) and (nextWeekInstant) = " + t1.toDays());
        System.out.println("Duration(DAYS) Between (pastWeekLocalDate) and (nextWeekLocalDate) = " + t2.toDays());
        System.out.println("Duration(DAYS) Between (pastWeekLocalDateTime) and (nextWeekLocalDateTime) = " + t3.toDays());
        System.out.println("Duration(DAYS) Between (nextWeekInstant) and (pastWeekInstant) = " + t4.toDays());

        Duration t5 = Duration.between(pastWeekLocalDate, d04); // Exception bc, Duration need the time to count the
        // duration time between the gap of time
    }
}

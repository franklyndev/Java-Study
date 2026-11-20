package datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ConvertGlobalToLocal {
    public static void main(String[]args) {
        // Converter data-hora global para local
        LocalDate d04 = LocalDate.parse("2026-11-18");
        LocalDateTime d05 = LocalDateTime.parse("2026-11-18T20:52");
        Instant d06 = Instant.parse("2026-11-18T23:52:01Z");

        // Para converter uma data-hora Global para Local é necessário informar de qual localidade vai ser considerado
        // como timezone(fuso-horário)

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault()); // Global to Local instance
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal")); // Global to Local instance

        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault()); // Global to Local instance
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal")); // Global to Local instance


        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3 + " No Brasil");
        System.out.println("r4 = " + r4 + " Em Portugal");
        System.out.println("");

        // Como obter (dia, mes, ano, hora)

        System.out.println("d04 dia = " + d04.getDayOfMonth());
        System.out.println("d04 dia = " + d04.getMonthValue());
        System.out.println("d04 dia = " + d04.getYear());
        System.out.println("");

        System.out.println("d05 dia = " + d05.getHour());
        System.out.println("d05 dia = " + d05.getMinute());

    }
}

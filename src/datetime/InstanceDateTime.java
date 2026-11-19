package datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[]args) {
        // Documentacao DateTimeFormatter
        // https://docs-oracle-com.translate.goog/javase/8/docs/api/java/time/format/DateTimeFormatter.html?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt&_x_tr_pto=tc

        // TODO: Instaciar data-hora (LOCAL)
        // LocalDate é um método estático
        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();

        System.out.println("d01 = " + d01);
        System.out.println("d02 = " + d02);

        // TODO: Instaciar data-hora (GLOBAL)
        Instant d03 = Instant.now();

        System.out.println("d03 = " + d03); // (GMT +0) Horário de Londres

        // TODO: Converter texto ISO 8601 em Data-hora
        // (Local)
        LocalDate d04 = LocalDate.parse("2026-11-17");
        LocalDateTime d05 = LocalDateTime.parse("2026-11-17T11:14:40");
        // (Global)
        Instant d06 = Instant.parse("2026-11-17T11:14:40Z");
        Instant d07 = Instant.parse("2026-11-17T11:14:40-03:00");

        System.out.println("d04 = " + d04);
        System.out.println("d05 = " + d05);
        System.out.println("d06 = " + d06);
        System.out.println("d07 = " + d07);

        // Formatar e converter data
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d08 = LocalDate.parse("20/11/2026", fmt1);
        LocalDateTime d09 = LocalDateTime.parse("20/11/2026 15:00", fmt2);
        // Poderia tbm fazer direto sem precisar instaciar objeto
        LocalDateTime d10 = LocalDateTime.parse("20/11/2026 15:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        System.out.println("d08 = " + d08);
        System.out.println("d09 = " + d09);
        System.out.println("d10 = " + d10);

        // Convertendo dia, mes, ano [horario] isoladamente

        LocalDate d11 = LocalDate.of(2026, 11, 14);
        LocalDateTime d12 = LocalDateTime.of(2026, 11, 14, 11, 40);

        System.out.println("d11 = " + d11);
        System.out.println("d12 = " + d12);
    }
}

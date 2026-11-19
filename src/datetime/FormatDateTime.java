package datetime;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FormatDateTime {
    public static void main(String[]args) {
        LocalDate d04 = LocalDate.parse("2026-11-18");
        LocalDateTime d05 = LocalDateTime.parse("2026-11-18T17:50");
        Instant d06 = Instant.parse("2026-11-18T03:00:01Z"); // Horário de LONDRES, pq sempre considera o horário
        // de LONDRES como ponto inicial

        // https://docs-oracle-com.translate.goog/javase/8/docs/api/java/time/format/DateTimeFormatter.html?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt&_x_tr_pto=tc

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME; // Imprime o objeto ISO como texto no formato original
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT; // Imprime o objeto INSTANT ISO como texto no formato original


        System.out.println("d04 = " + d04.format(fmt1));
        System.out.println("d04 = " + fmt1.format(d04)); // Chamando a partir do molde do Formatter
        System.out.println("d04 = " + d04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); // Passando a expressao da
        // formataçao completa diretamente como argumento
        System.out.println("");

        System.out.println("d05 = " + d05.format(fmt2));
        System.out.println("d05 = " + d05.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("d05 = " + fmt2.format(d05));

        System.out.println("");

        System.out.println("d06 = " + fmt3.format(d06)); // Para voce formatar um objeto que a data tem fuso-horário,
        // é necessário voce passar um fuso-horário, porque se nao passar irá ocorrer uma excessao(Exception)

        System.out.println("d06 = " + fmt5.format(d06)); // Imprime o objeto INSTANT ISO como texto no formato original

        System.out.println("d06 = " + fmt4.format(d06)); // Exception bc fmt4 doesnt especify timezone, it is local

        System.out.println("d06 = " + fmt2.format(d06)); // Exception bc fmt2 doesnt especify timezone


//        System.out.println("d06 = " + fmt2.format(d06));
    }
}

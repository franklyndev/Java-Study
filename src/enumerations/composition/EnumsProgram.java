package enumerations.composition;

import enumerations.composition.entities.Order;
import enumerations.composition.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnumsProgram {
    public static void main(String[]args){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime d01 = LocalDateTime.now();

        // Enums serve to padronize processes and prevent against errors in the code

        Order order = new Order(1080, fmt.format(d01), OrderStatus.PENDING_PAYMENT);

        System.out.println(order);

        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(os1);
        System.out.println(os2);

    }
}

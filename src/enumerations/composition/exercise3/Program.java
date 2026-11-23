package enumerations.composition.exercise3;

import enumerations.composition.exercise3.entities3.Client;
import enumerations.composition.exercise3.entities3.Order;
import enumerations.composition.exercise3.entities3.OrderItem;
import enumerations.composition.exercise3.entities3.Product;
import enumerations.composition.exercise3.enums3.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import static enumerations.composition.exercise2.Program.line;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime moment;
        Order order;
        OrderItem orderItem;
        Product product;
        Client client;

        System.out.println(line() + " CLIENT DATA " + line());

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth Date (dd/mm/yyyy): ");
        LocalDate birthDate = LocalDate.parse(sc.nextLine(), fmt);

        System.out.println(line() + " ORDER DATA " + line());

        System.out.print("Status (PENDING_PAYMENT, PROCESSING, SHIPPED, DELIVERED): ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine().toUpperCase());

        System.out.print("How many items to this order: ");
        int itemsQuantity = sc.nextInt();

        client = new Client(name, email, birthDate);
        moment = LocalDateTime.now();
        order = new Order(moment, status, client);

        for (int i = 1; i <= itemsQuantity; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();


            product = new Product(productName, price);
            orderItem = new OrderItem(quantity, price, product);
            order.addItem(orderItem);
        }

        System.out.println(line() + "ORDER SUMMARY" + line());
        System.out.println(order);
    }
}

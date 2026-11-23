package enumerations.composition.exercise3.entities3;

import enumerations.composition.exercise3.enums3.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime moment;
    private OrderStatus status;
    // Association
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public DateTimeFormatter getFmt() {
        return fmt;
    }

    public void setFmt(DateTimeFormatter fmt) {
        this.fmt = fmt;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        double sum = 0;
        for(OrderItem i : items) {
            sum += i.subTotal();
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: " + moment.format(fmt) + "\n");
        sb.append("Order status: " + status + "\n");
         sb.append("Client: " + client.toString() + "\n");
        sb.append("Order Items: " + "\n");
        for(OrderItem i : items) {
            sb.append(i + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f",total()));
        return sb.toString();
    }

}

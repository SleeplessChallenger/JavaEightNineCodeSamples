package thirdchapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapAndFlatMapExample {
    private static class Customer {
        private String name;
        private List<Order> orders = new ArrayList<>();

        public Customer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public Customer addOrder(Order order) {
            orders.add(order);
            return this;
        }
    }

    private static class Order {
        private int id;

        public Order(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public static void main(String[] args) {
        Customer sherbian = new Customer("Sherbian");
        Customer ivanova = new Customer("Ivanova");
        Customer garibaldi = new Customer("Garibaldi");

        sherbian.addOrder(new Order(1))
                .addOrder(new Order(2));

        ivanova.addOrder(new Order(4));

        List<Customer> customers = Arrays.asList(sherbian, ivanova, garibaldi);

        // using plain map
        customers.stream()
                .map(Customer::getName)
                .forEach(System.out::println);

        // using plain map for orders
        customers.stream()
                .map(Customer::getOrders)
                .forEach(System.out::println);

        customers.stream()
                .map(customer -> customer.getOrders().stream())
                .forEach(System.out::println);

        // using flatMap
        customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .forEach(o -> System.out.println(
                        o.getId()
                ));
    }
}

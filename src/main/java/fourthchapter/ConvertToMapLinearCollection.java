package fourthchapter;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertToMapLinearCollection {
    private static class Book {
        private int id;
        private String name;
        private double price;

        public Book(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public double getPrice() {
            return price;
        }
    }

    private List<Book> allBooks = List.of(
            new Book(21, "a", 4.5),
            new Book(12, "b", 9.12)
    );

    public void convertBooks() {
        Map<String, Book> firstBooks = allBooks.stream()
                .collect(Collectors.toMap(Book::getName, b -> b));
        Map<String, Book> secondBooks = allBooks.stream()
                .collect(Collectors.toMap(Book::getName, Function.identity()));
    }

}

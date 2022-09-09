package thirdchapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexReduce {

    public class Book {
        private Integer id;
        private String title;

        public Book(int i, String good) {
            super();
        }

        public Integer getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }
    }

    public void createMap() {
        List<Book> books = List.of(new Book(32, "Good"), new Book(54, "Average"));

        HashMap<Integer, String> allBooks = books.stream()
                .reduce(new HashMap<Integer, String>(),
                        (map, book) -> {
                            map.put(book.getId(), book.getTitle());
                            return map;
                        },
                        (map1, map2) -> {
                            map1.putAll(map2);
                            return map1;
                        });
    }
}

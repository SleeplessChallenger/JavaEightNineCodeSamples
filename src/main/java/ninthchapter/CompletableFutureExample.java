package ninthchapter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

// `CompletableFuture` is a child of `Future` => methods from it are available here as well
// .completedFuture(), .complete(), .completeExceptionally()
public class CompletableFutureExample {
    private final Map<Integer, Product> cache = new HashMap<>();

    private static class Product {
        private final int id;
        private final String name;

        public Product(int newId, String newName) {
            this.id = newId;
            this.name = newName;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public CompletableFuture<Product> getProduct(int id) {
        try {
            Product product = getLocal(id);
            if (product != null) {
                return CompletableFuture.completedFuture(product);
            } else {
                CompletableFuture<Product> future = new CompletableFuture<>();
                Product p = getRemote(id);
                cache.put(id, p);
                future.complete(p);
                return future;

                // same as above, but runs asynchronously
                return CompletableFuture.supplyAsync(() -> {
                    Product p = getRemote(id);
                    cache.put(id, p);
                    return p;
                });
            }
        } catch (Exception e) {
            CompletableFuture<Product> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    private Product getLocal(int id) {
        return cache.get(id);
    }

    private Product getRemote(int id) {
        try {
            Thread.sleep(100);
            if (id == 598) {
                throw new RuntimeException("Bad request!");
            }
        } catch (InterruptedException ignored) {
        }

        return new Product(id, "stub");
    }
}

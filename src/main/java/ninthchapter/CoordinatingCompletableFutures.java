package ninthchapter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoordinatingCompletableFutures {

    private String sleepThenReturnString() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        return "54";
    }

//    private void processSleepMethod() {
//        CompletableFuture.supplyAsync(() -> this::sleepThenReturnString)
//                .thenApply(Integer::parseInt)
//                .thenApply(x -> 2 * x)
//                .thenAccept(System.out::println)
//                .join();
//
//        System.out.println("Running...");
//    }
//
//    private void processSleepWithExecutor() {
//        ExecutorService service = Executors.newFixedThreadPool(4);
//
//        CompletableFuture.supplyAsync(() -> this::sleepThenReturnString, service)
//                .thenApply(Integer::parseInt)
//                .thenApply(x -> 2 * x)
//                .thenAccept(System.out::println)
//                .join();
//
//        System.out.println("Running...");
//    }

    // example of addition
    private void composeTwoFigures() throws Exception {
        int x = 2;
        int y = 3;
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> x) // gives 2
                .thenCompose(n -> CompletableFuture.supplyAsync(() -> n + y)); // accepts 2 and puts it inside next supplier
    }

    private void combineTwoFigures() throws Exception {
        int x = 2;
        int y = 3;
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> x)
                .thenCombine(CompletableFuture.supplyAsync(() -> y),
                        (n1, n2) -> n1 + n2); // == Integer::sum
    }

    // using handle method
    private CompletableFuture<Integer> getIntegerCompletableFuture(String num) {
        return CompletableFuture.supplyAsync(() -> Integer.parseInt(num))
                .handle((val, exc) -> val != null ? val : 0);
    }

    public void handleWithException() throws Exception {
        String num = "abc";
        CompletableFuture<Integer> value = getIntegerCompletableFuture(num);

        String realNum = "53";
        CompletableFuture<Integer> realValue = getIntegerCompletableFuture(realNum);
    }
}

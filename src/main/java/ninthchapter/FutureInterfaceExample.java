package ninthchapter;

import java.util.concurrent.*;

public class FutureInterfaceExample {

    // General future
    public void showingFuture() {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(new Callable<String>() { // `submit()` starts the task and returns ready/not-ready result
            @Override
            public String call() throws Exception {
                Thread.sleep(100);
                return "Some nice string!";
            }
        });

        Future<String> futureWithLambda = service.submit(() -> {
            Thread.sleep(10);
            return "Another nice string!";
        });

        while (!future.isDone()) { // FIXME: not the best practice, hence better using methods in `CompletableFuture`
            System.out.println("Waiting...");
        }

//        future.cancel(true);

        System.out.println("Processing...");
        getIfNotCancelled(future);
    }

    public void getIfNotCancelled(Future<String> future) {
        try {
            if (!future.isCancelled()) {
                System.out.println(future.get());
            } else {
                System.out.println("Cancelled...");
            }
         } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

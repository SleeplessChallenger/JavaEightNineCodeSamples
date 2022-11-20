package ninthchapter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

// 2 Options if default doesn't work:
//      - use system property
//      - create your own ForkJoinPool
public class ChangingPoolSize {

    // or via `-D` parameter
    public void setNumberProgrammatically() {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        long total = LongStream.rangeClosed(1, 3_000_000)
                .parallel()
                .sum();
        int poolSize = ForkJoinPool.commonPool().getPoolSize();
        System.out.println("Pool size: " + poolSize);
    }

    public void customForkJoinPool() {
        long total;
        int poolSize;

        ForkJoinPool pool = new ForkJoinPool(15); // create our own ForkJoinPool
        ForkJoinTask<Long> task = pool.submit(
                () -> LongStream.rangeClosed(1, 3_000_000)
                        .parallel()
                        .sum());
        try {
            total = task.get(); // execute the job
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }

        poolSize = pool.getPoolSize();
        System.out.println("Pool size: " + poolSize);
    }
}

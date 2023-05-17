package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableBefore8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Integer>> results = new ArrayList<>();
        for ( int i = 0; i < 3; i++) {
            int temp = i;
            results.add(pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(1000);
                    return temp * 2;
                }
            }));
        }
        for (Future result : results) {
            System.out.println(result.get());
        }


        pool.shutdown();


    }
}

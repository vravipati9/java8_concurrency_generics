package java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CallableIn8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Integer> list = Arrays.asList(1, 2, 3);

        /*
         * --------------------
         *      first approach
         * --------------------
         */
        /*
        List<Future<Integer>> results = new ArrayList<>();
        list.forEach(integer -> results.add(pool.submit(() -> {
            Thread.sleep(1000);
            return integer * 2;
        })));
        for (Future result : results) {
            System.out.println(result.get());
        }
        */

        /*
         * --------------------
         *      second approach
         * --------------------
         */
        Function<Integer, Future<Integer>> task = (Integer integer) -> pool.submit(() -> {
            Thread.sleep(1000);
            return integer * 2;
        });

        List<Future<Integer>> results  = list.stream()
                .map(task)
                .collect(Collectors.toList());

        for (Future result : results) {
            System.out.println(result.get());
        }


        pool.shutdown();


    }
}

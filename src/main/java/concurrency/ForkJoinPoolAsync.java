package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/*
 * Use ForkJoinPool submit() when you need response from the calling method and execute asynchronously
 */
public class ForkJoinPoolAsync {
	public static int compute() {
		System.out.println("Starting..");
		System.out.println(Thread.currentThread());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 10;
	}
	public static void main(String a[]) throws InterruptedException, ExecutionException {
		ForkJoinPool pool = ForkJoinPool.commonPool();
		System.out.println("Start");
	
		ForkJoinTask<Integer> result = pool.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return compute();
			}
		});
		System.out.println("Do other work");
		System.out.println(result.get());
		System.out.println("Done");
	}
}

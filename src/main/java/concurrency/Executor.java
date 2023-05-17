package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor {
	public static  void main(String a[]) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 20; i++ ) {
			int index = i;
			executorService.submit(() -> task(index));
		}

		executorService.shutdown();
		executorService.awaitTermination(10, TimeUnit.SECONDS);
		long end = System.currentTimeMillis();
		System.out.println("Time takens(s): " + (end - start) / 1000);
	}
	

	private static void task(int id) {
		sleep(3000);
	}
	private static void sleep(int ms) {
		try { Thread.sleep(ms); } catch(Exception ex) {}
	}
}

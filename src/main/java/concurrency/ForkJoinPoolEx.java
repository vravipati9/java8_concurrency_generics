package concurrency;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolEx {
	public static void main(String a[]) throws Exception{
		System.out.println(Runtime.getRuntime().availableProcessors());
//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		long start = Timeit.getCurrentTime();
//		for (int i = 0; i < 20; i++ ) {
//			int index = i;
//			executorService.submit(() -> task(index));
//		}
//		long end = Timeit.getCurrentTime();
//
//		executorService.shutdown();
//		executorService.awaitTermination(10, TimeUnit.SECONDS);
//		System.out.println("Time takens(s): " + (end - start)/1.0e9);

		ForkJoinPool pool = ForkJoinPool.commonPool();
		System.out.println(pool);
		sleep(1000);
		for (int i = 0; i < 20; i++ ) {
			int index = i;
			pool.submit(() -> task(index));
		}
		System.out.println("Pooled task count::"+pool.getRunningThreadCount());
		
		int count = 0;
		while(count++ < 30) {
			System.out.println(pool);
			sleep(1000);
		}
	}
	//active - running state and in blocked state
	//running - actual running state
	private static void task(int id) {
		//System.out.println("task " + id +" entered "+Thread.currentThread());
		sleep(3000);
		//System.out.println("task " + id +" existing "+Thread.currentThread());

	}
	private static void sleep(int ms) {
		try { Thread.sleep(ms); } catch(Exception ex) {}
	}
}

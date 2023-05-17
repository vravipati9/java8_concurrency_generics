package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/*
 * Use invoke() when you need response from the calling method
 * Drawback of this code is as it waits for response when you call invoke() method
 * We can use invoke for divide and conquer problems. We can write divide/conquer inside invoke method task
 */
public class ForkJoinPoolSync {
	public static int compute() {
		System.out.println("Starting..");
		System.out.println(Thread.currentThread());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 10;
	}
	public static void main(String a[]) {
		ForkJoinPool pool = ForkJoinPool.commonPool();
		System.out.println("Start");
	
		ForkJoinTask<Integer> forkJoinTask1 = ForkJoinTask.adapt(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return compute();
			}
		});
		//Using Lambda's
		//ForkJoinTask<Integer> forkJoinTask = ForkJoinTask.adapt(() -> compute());
		
		ForkJoinTask<Integer> forkJoinTask = ForkJoinTask.adapt(ForkJoinPoolSync::compute);
		
		// For void tasks we can ForkJoinTask as below
		// ForkJoinPool<?> pool = ForkJoinTask.adapt(Sample::voidMetho);
		
		Integer result = pool.invoke(forkJoinTask); 
		System.out.println(result);
		System.out.println("Done");
	}
}

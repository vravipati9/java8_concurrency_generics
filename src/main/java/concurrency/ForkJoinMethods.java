package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/*
 * Use ForkJoinPool submit() when you need response from the calling method and execute asynchronously
 */
public class ForkJoinMethods {
	public static int compute(int number) {
		System.out.println(number + ":" +Thread.currentThread());
		if (number == 1) 
			return 1;
		else {
			int part1 = number / 2;
			int part2 = number / 2;
			
			return compute(part1) + compute(part2);
		}
	}
	
	public static void main(String a[]) throws InterruptedException, ExecutionException {
		System.out.println("Start");
		compute(4);
		ForkJoinPool pool = ForkJoinPool.commonPool();

		System.out.println("Done");
	}
}

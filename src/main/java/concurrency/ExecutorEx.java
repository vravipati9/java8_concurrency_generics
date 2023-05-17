package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorEx {
	private static ExecutorService pool;
	public static void main(String...strings) throws InterruptedException, ExecutionException {
		System.out.println(isPrime(7));
		System.out.println("test");
		System.out.println("No of Primes::"+computeInRange(1, 10));
		
		 pool = Executors.newFixedThreadPool(10);
		 System.out.println(splitAndCompute(1, 100000));
		 pool.shutdown();
		 pool.awaitTermination(1, TimeUnit.MINUTES);
		
	}
	public static boolean isPrime(int number) {
		boolean divisible = false;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				divisible = true;
				break;
			}
		}
		return number > 1 && !divisible;
	}
	
	public static long computeInRange(int low, int high) {
		int count = 0;
		
		for (int i = low; i < high; i++) {
			if (isPrime(i)) count++;
		}
		return count;
	}
	
	public static long splitAndCompute(int lower, int upper) throws InterruptedException, ExecutionException {
		System.out.println("Starting split and Compute:" +lower +", "+upper);
		int diff = upper - lower;
		if (diff < 100) {
			return computeInRange(lower, upper);
		} else {
			int middle = lower + upper / 2;
			Future<Long> task1 = pool.submit(() -> computeInRange(lower, middle));
			Future<Long> task2 = pool.submit(() -> computeInRange(middle+ 1, upper));
			
			ThreadPoolExecutor threadPool = (ThreadPoolExecutor) pool;
			System.out.println("Current Active Thread count"+ threadPool.getActiveCount());
			long result = task1.get() + task2.get();
			System.out.println("Finished splitAndCompute:");
			return result;
		}
	}
	
	
}

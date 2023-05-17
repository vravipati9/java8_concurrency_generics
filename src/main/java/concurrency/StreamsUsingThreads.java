package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class StreamsUsingThreads {

	public static void main(String[] args) throws InterruptedException {
		StreamsUsingThreads obj = new StreamsUsingThreads();
		obj.countLengthUsingThreads();
		obj.usingParallelStream();
	}
	private void countNumbersUsingThreads() throws InterruptedException {
		AtomicLong count = new AtomicLong(0);
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		for(Integer i : list) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//count.set(count.get() + i);
					count.addAndGet(i);
				}
			});
		}

		System.out.println("Waiting...");

		executor.shutdown();
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
		System.out.println("Total::"+count.get());
		System.out.println("Done");
	}
	
	private void usingParallelStream() {
		List<String> names = Arrays.asList(
				"Sara", "Sam", "Joe", "Jack", "Bill", "Bruce", "Bob");
		System.out.println(
		names.stream()
			.mapToInt(String::length)
			.sum()); 
	}

	private void countLengthUsingThreads() throws InterruptedException {
		
		List<String> names = Arrays.asList(
				"Sara", "Sam", "Joe", "Jack", "Bill", "Bruce", "Bob");
		ExecutorService threadPool = Executors.newFixedThreadPool(10);

		AtomicLong count = new AtomicLong(0);
		for (String name : names) {
			//System.out.println(Thread.currentThread().getName());
			threadPool.submit(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					int	length = name.length();
					long get = count.get();
					//System.out.println(Thread.currentThread().getName() +", " +name + ", " + length);
					//count.compareAndSet(get, get + length);
					//count.set(count.get() + length);
					count.addAndGet(length);
				}
			});
		}
		System.out.println("Waiting..");
		threadPool.shutdown();
		threadPool.awaitTermination(10, TimeUnit.MINUTES);

		System.out.println("Final count"+count.get());
	}

}

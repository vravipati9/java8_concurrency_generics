package concurrency;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class ComputeLinksConcurrent implements ComputeLinks {
	private Set<String> visited = new HashSet<>();
	private ExecutorService executorService = null;
	private CountDownLatch latch = new CountDownLatch(1);
	private AtomicReference<Exception> exception = new AtomicReference<>();
	private AtomicLong count = new AtomicLong();
	
	/*
	 * Computation Intensive - (blocking factor is 0)
	 * Number of Threads = Number of cores / (1 - Blocking factor)
	 * 
	 * IO Intensive - (Blocking factor is 0 to 0.9)
	 * Number of Threads = Number of cores / (1 - .9), ex, BF = .9 and C = 2
	 * T = C / (1 - .9) = C / .1 = 10 * C = 20 threads
	 * 
	 * Steps: 
	 * 1) Create Executor and shut down
	 * 2) Schedule visit to link
	 * 3) CountDownLatch to know when the task has finished
	 * 4) Create Exception
	 * 5) create Atomiccount to monitor and call visitLink from schedular
	 */
	public long countLinks(String url) {
		
		//if (latch.getCount() != 0 )
			
		try {
			executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 10);
			System.out.println("Begin Schedule visit");
			scheduleVisitToLink(url);
			System.out.println("After Schedule visit");
			if (!latch.await(15, TimeUnit.MINUTES)) 
				throw new RuntimeException("Timeout");
			System.out.println("After countdown latch");
			if (exception.get() != null)
				throw new RuntimeException(exception.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
		return visited.size();
	}

	private void scheduleVisitToLink(String url) {
		//visited.add(url);
		count.incrementAndGet();
		executorService.submit(() -> visitLink(url));
	}

	private boolean shouldVisit(String link) {
		synchronized (visited) {
			return visited.add(link);
		}
	}
	private void visitLink(String url) {
		try {
			LinksFinder.getLinks(url)
			.stream()
			//.filter(link -> (!visited.contains(link)))
			//.map(link -> { visited.add(link); return link; })
			.filter(this::shouldVisit)
			.forEach(link -> scheduleVisitToLink(link));
			
			count.decrementAndGet();
			
			if (count.get() == 0) {
				latch.countDown();
			}
			
		} catch(Exception e) {
			exception.set(e);
			latch.countDown();
		} finally {
			
		}
			
			
	}
	
	
	
}
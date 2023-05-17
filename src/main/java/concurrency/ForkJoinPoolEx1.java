package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

/*
 * Use execute when you don't need to response and execute task asynchronously
 */
public class ForkJoinPoolEx1 {
	public static void task() {
		System.out.println("Executing...");
		System.out.println(Thread.currentThread());
		try { Thread.sleep(2000); } catch(Exception ex) {}
	}
	
	public static void main(String a[]) throws Exception {
		ForkJoinPool pool = ForkJoinPool.commonPool(); //Commonpool has n-1 threads, where n is no of cores
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				task();
			} 
		};
		
		Runnable runnable1 = () -> task();	//another way to get runnable using Lambda's
		Runnable runnable2 = ForkJoinPoolEx1::task;
		
		
		ForkJoinTask forkJoinTask = ForkJoinTask.adapt(runnable);
		System.out.println("Send");
		pool.execute(forkJoinTask);
		//pool.execute(ForkJoinPoolEx1::task);	//simple way to represent above statement 
		
		//Using ForkJoinPool
		//pool.execute(task);
		//pool.execute(ForkJoinPoolEx1::task);
		
		System.out.println("Done!!");
		//Once main thread completes execution, commonpool will not submit tasks. To avoid this, we have to
		//specify the wait time before it terminates. If we commented below code, pool will not submit task	
		pool.awaitTermination(10, TimeUnit.SECONDS);
	}
}

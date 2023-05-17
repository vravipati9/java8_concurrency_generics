package concurrency;

public class SynchronizeOverVolatile {

		private static volatile int count;
		private static boolean done = false;
		public static void main(String a[]) throws InterruptedException {
			
			new Thread(() -> runTillDone()).start();
			
			Thread.sleep(5000);
			System.out.println("changing done");
			setDone();
			
	}

	private static synchronized void runTillDone() {
		while(!getDone()) {
			count++;
		}
		System.out.println("Done");	
	}
	
	// Sleep() also crosses the memory barrier. Instead of synchronize, if we call Thread.sleep on runTillDone method, it works
	private static void setDone() {	// When we call synchorinize method, local thread memory update to Main memory, means both are in sync
		done = true;
	}
	
	private static synchronized boolean getDone() {
		return done;
	}

}

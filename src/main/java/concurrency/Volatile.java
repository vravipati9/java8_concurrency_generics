package concurrency;

public class Volatile {
	//private static int count;
	private static volatile int count;
	private static boolean done = false;
	public static void main(String a[]) throws InterruptedException {
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(!done) {
					count++;
				}
				System.out.println("Done");
			}
			
		}).start();
		
		Thread.sleep(5000);
		System.out.println("changing done");
		done = true;
		
	}
}

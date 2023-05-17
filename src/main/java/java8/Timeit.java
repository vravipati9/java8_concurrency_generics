package java8;

public class Timeit {
	public static void code(Runnable block) {
		long start = getCurrentTime();
		try {
			block.run();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			long end = getCurrentTime();
			System.out.println("Time takens(s): " + (end - start)/1.0e9);
		}
	}
	
	public static long getCurrentTime() {
		return System.nanoTime();
	}
}

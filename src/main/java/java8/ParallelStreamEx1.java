package java8;

import java.util.Arrays;
import java.util.List;


public class ParallelStreamEx1 {
	public static void main(String a[]) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		long start = System.nanoTime();
		/*System.out.println("<<< Using Stream >>>");
		Timeit.code(() ->
				integers.stream().filter(ParallelStreamEx1::isEven)
				.mapToInt(e -> compute(e))
				.forEach(System.out::println)
				);
		*/
		System.out.println("<<< Using Parallel Stream >>>");
		Timeit.code(() ->
				integers.parallelStream().filter(ParallelStreamEx1::isEven)
						.mapToInt(e -> compute(e))
						.forEach(ParallelStreamEx1::printIt)
		);

		System.out.println("<<< Using Parallel Stream Print in Order >>>");
		Timeit.code(() ->
				integers.parallelStream().filter(ParallelStreamEx1::isEven)
						.mapToInt(e -> compute(e))
						.forEachOrdered(ParallelStreamEx1::printIt)
		);
	}

	private static boolean isEven(int e) {
		System.out.println("filter " + e + ": "+Thread.currentThread());
		return  e % 2 == 0;
	}

	public static int compute(int number) {
		System.out.println("map " + number + ": "+Thread.currentThread());
		try { Thread.sleep(1000); } catch(Exception e) {}
		return number * 2;
	}

	private static void printIt(int number) {
		System.out.println("printIt: " +number +" : "+ Thread.currentThread());
		System.out.println(number);
	}

	public static void execute(Runnable runnable) {
		runnable.run();
	}
	
}

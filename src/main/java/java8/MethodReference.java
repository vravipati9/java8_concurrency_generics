package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReference {
	public static void main(String a[]) {
		/*Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello");
			}
		});*/
		
		//Thread t = new Thread(() -> printMessage());
		
		// Method reference can be used only when you receive something and passing that value without modification
		Thread t = new Thread(MethodReference::printMessage);
		t.start();
		
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		integers.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				
			};
		});
		// Parameter as an argument
		integers.forEach(System.out::print);
		System.out.println("-");
		// Parameter as an argument to static method
		integers.stream()
				//.map(e -> String.valueOf(e))
				//.map(String::valueOf)
				.map(e -> e.toString())		//parameter becomes target object
				.forEach(System.out::print);
		System.out.println("-");
		integers.stream()
				.map(e -> e.toString())		//parameter becomes target object
				.forEach(System.out::print);
		
		System.out.println("-");
		integers.stream()
				//.map(e -> String.valueOf(e))
				.map(String::valueOf)		
				.forEach(System.out::print);
		
		System.out.println(
		integers.stream()
				//.reduce(0, (total, e) -> Integer.sum(total, e)));
				  .reduce(0, Integer::sum));
	}
	static void printMessage() {
		System.out.println("hello!!!");
	}
	
}

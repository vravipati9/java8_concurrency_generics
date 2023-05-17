package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
With imperative programming, you tell the compiler what you want to happen, step by step.

With declarative programming, on the other hand, you write code that describes what you want,
but not necessarily how to get it (declare your desired results, but not the step-by-step):
 */

public class Imperative {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(12, 13, 14, 15, 16);
		//Imperitive
		for (Integer integer : numbers) {
			System.out.println(integer);
		}

		//declarative (higher level abstraction)
		numbers.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			};
		});
		
		// with Internal Iterator
		numbers.forEach((Integer t) -> System.out.println(t)); // numbers are of type Integer, 
		
		// type Inference for Function Interface of type Consumer
		numbers.forEach(t -> System.out.println(t));


	}

}

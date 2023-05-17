package generics;

import generics.model.Box;

import java.util.ArrayList;
import java.util.List;

public class BoxDemo<T> {
	public static void main(String[] args) {
		ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();

		BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
		BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);	// type inference, java compiler automatically infers the type parameter is Integer
		BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
		BoxDemo.outputBoxes(listOfIntegerBoxes);

		new MyClass<Integer>("");

	}

	public static <U> void addBox(U u, List<Box<U>> boxes) { 
		Box<U> box = new Box<>();
		box.set(u);
		boxes.add(box);
	}
	
	public static <U> void outputBoxes(List<Box<U>> boxes) { 
		int counter = 0;
		for (Box<U> box : boxes) {
			System.out.println("Box #" + counter + " contains [" +
		             box.get().toString() + "]");
			counter++;
		}
	}
	
	static void processStringList(List<String> stringList) {
	    // process stringList
	}


}

class MyClass<X> {
	<T> MyClass(T t) {
		// ...
	}
}

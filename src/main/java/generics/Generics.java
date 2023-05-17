package generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {
	public static void main(String...strings ) {
		Banana banana = new Banana();
		Orange orange = new Orange();
		
		useFruit(banana);
		useFruit(orange);
		
		List<Banana> basket1 = new ArrayList<>();
		basket1.add(banana);
		
		List<Fruit> basket2 = new ArrayList<>();
		copy(basket1, basket2);
		
		//useFruitBasket(basket1);
		System.out.println("********");
		useFruitBasket(basket2);
	}
	
	public static void useFruitBasket(List<Fruit> fruits) {
		System.out.println("received..."+fruits);
		//fruits.add(new Citrus());
	}
	
	public static void useFruit(Fruit fruit) {
		System.out.println("received..."+fruit);
	}
	
	public static <T> void copy(List<T> src, List<? super T> target) {
		target.addAll(src);
	}
}

class Fruit {}
class Banana extends Fruit {}
class Orange extends Fruit {}

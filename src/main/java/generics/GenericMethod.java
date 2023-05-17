package generics;

import java.util.ArrayList;
import java.util.Collection;

public class GenericMethod {

	//We can call this method with any kind of collection
	//whose element type is a supertype of the element type of the array
	public static void main(String[] args) {
		Object[] o = new Object[10];
		Collection<String> c = new ArrayList<String>();
		//fromArrayToCollection(o, c);	//Collection of Strings will store only strings not all objs
		
		Integer[] intArray = new Integer[10];
		Double[] doubleArray = new Double[10];
		Collection<Number> c1 = new ArrayList<Number>();
		fromArrayToCollection(intArray, c1);
	}

/*	static void fromArrayToCollection(Object[] a, Collection<?> c) {
		for (Object object : c) {
			c.add(object);	//compile time error 
		}
	}
*/
	static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
		for (T object : a) {
			c.add(object);	//compile time error 
		}
		System.out.println(c);
	}
}

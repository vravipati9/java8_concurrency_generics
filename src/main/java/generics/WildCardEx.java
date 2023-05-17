package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class WildCardEx {

	public static void main(String[] args) {
		process(new ArrayList<Foo>());
		process(new ArrayList<Bazz>());
		
		List<? extends Number> intList = new ArrayList<Integer>();
		List<? extends Number>  numList = intList; 
		
		
	}
	
	public static void wildCardNotAllowedForMethods() {
		//List<?> list = Collections.< ? >emptyList(); 
		//List< S > list = Collections.< S >emptyList();
	}
	
	public static void process(List<? extends Foo> list1) {
		/* ... */ 
		List<?> list; 
		list = Collections.<String>emptyList();
		list = Collections.<Runnable>emptyList();
		list = Collections.<TimeUnit>emptyList();
		list = Collections.<Comparable>emptyList();
		list = Collections.<Thread.State>emptyList();
		list = Collections.<int[]>emptyList();
		list = Collections.<Object[]>emptyList();
		list = Collections.<Callable<String>>emptyList();
		list = Collections.<Comparable<? super Long>>emptyList();
		list = Collections.<Class<? extends Number>>emptyList();
		list = Collections.<Map.Entry<?,?>>emptyList();
	}
	
	//public static void process(List<Buzz> list) {}
}

class Foo {}
class Bazz extends Foo {
	
}

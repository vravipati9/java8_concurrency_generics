package generics;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WildCardEx1 {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("ads");c.add(100);
		//printCollectionThrowsClassCastExp(c);	// we are passing String & Integer and Generic Method only accepts Strings
		
		Collection<Object> c2 = new ArrayList<Object>();	// We can add any class which is sub type of Object.
		c2.add("");	c2.add(12);
		
		Collection<?> c1 = new ArrayList<Number>();
		//c1.add();	We can not add anything in this. because it is unknown type.
		printCollectionWildCards(c1);

		System.out.println("* * * print objects of any type * * *");
		List<Integer> integerList = new ArrayList<>(); integerList.add(1);
		List<String> stringList = new ArrayList<>(); stringList.add("test");
		printList(integerList);
		printList(stringList);
	}
	
	static void printCollectionThrowsClassCastExp(Collection<String> c) {
	    for (String e : c) {
	        System.out.println(e);
	    }
	}
	static void printCollectionAceptsObjSubTypes(Collection<Object> c) {
	    for (Object e : c) {
	        System.out.println(e);
	    }
	}
	
	static void printCollectionWildCards(Collection<?> c) {
	    for (Object e : c) {
	        System.out.println(e);
	    }
	}

	static <T extends Object> void printList(List<T> list) {
		for (T object : list) {
			System.out.println(object);
		}
	}
}

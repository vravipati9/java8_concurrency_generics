package generics;

import java.util.ArrayList;
import java.util.List;

class A { 
	String getValue() { return "A"; }
}

class B extends A {
	String getValue() { return "B"; }
}

class C extends A { 
	String getValue() { return "C"; }
}

public class WildCardTest {

	public static void main(String[] args) {
		List<A> listA = new ArrayList<A>();
		List<B> listB = new ArrayList<B>();
		listA.add(new A());listA.add(new B());listA.add(new C());
		processElements(listA);
		List<Object> listObj = new ArrayList<Object>();
		insertElements(listA);
		insertElements(listObj);
		
		List<String> listString = new ArrayList<String>();
		//insertElementsOfObjects(listString);
		//arrayStoreException();
	}
	
	private static void processElements(List<? extends A> list) {
		for (A a : list) {
			System.out.println(a.getValue());
		}
	}
	
	private static void insertElements(List<? super A> list) {
		list.add(new A());
		list.add(new B());
		list.add(new C());
	}
	
	private static void insertElementsOfObjects(List<Object> list) {
	}
	
	private static void arrayStoreException() {
		A[] a = new A[10];
		B[] b = new B[3];
		C[] c = new C[3];
		A[] aReferB = new B[10];
		a[0] = new A(); a[1] = new B(); a[2] = new C();
		aReferB[0] = new B();
		aReferB[1] = new C();
	}

}

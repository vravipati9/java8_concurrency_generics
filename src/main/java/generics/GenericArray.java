package generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class GenericArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//List<String>[] lsa = new List<String>[10];	Not allowed
		//List<String>[] lsa = new List<?>[10];	Not allowed
		List<?>[] lsa = new List<?>[10];	//However, you can still use wildcard arrays.
		Object o = lsa;
		Object[] oa = (Object[])o;
		List<Integer> li = new ArrayList<>();
		li.add(5);
		oa[1] = li;
		Integer i = (Integer) lsa[1].get(0);
		String s = (String) lsa[1].get(0);	//ClassCastException
		System.out.println(i);
//        li.containsAll();
	}
}

class GenSet<E> {
    private E a[];

/*    public GenSet() {
        a = new E[INITIAL_ARRAY_LENGTH]; // error: generic array creation
    }
*/
    public GenSet() {
        a = (E[])new String[10]; // error: generic array creation
    }
}

class GenSet1<E extends Comparable<E>> {
    private E a[];

/*    public GenSet() {
        a = new E[INITIAL_ARRAY_LENGTH]; // error: generic array creation
    }
*/
    public GenSet1() {
        a = (E[])new Comparable[10]; // error: generic array creation
    }
}

/**
 * Checked: strong typing. GenSet knows explicitly what type of objects it contains (i.e. its constructor was explicitly called with a Class<E> argument,
 * and methods will throw an exception when they are passed arguments that are not of type E. See Collections.checkedCollection
*/
class GenSet2<E> {
    private E[] a;
    public GenSet2(Class<E> c, int s) {
        // Use Array native method to create array of a type only known at run time
        @SuppressWarnings("unchecked")
        final E[] a = (E[]) Array.newInstance(c, s);
        this.a = a;
    }

    E get(int i) {
        return a[i];
    }
}


/*
 * Unchecked: weak typing. No type checking is actually done on any of the objects passed as argument.
 */
class GenSet3<E> {
    private Object[] a;
    public GenSet3(int s) {
        a = new Object[s];
    }

    E get(int i) {
        return (E)a[i];
    }
}


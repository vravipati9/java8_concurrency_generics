package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/*
 * The automatic deduction of the type arguments of a generic method at compile time.
 */
public class TypeInference<T extends Comparable<T>> implements Comparable<T>{

	private final T theObject;
	
	public TypeInference(T theObject) {
		super();
		this.theObject = theObject;
	}
	
	public T getWrapper() {	return theObject;	}

	public static void main(String[] args) {
		TypeInference wrapper1 = new TypeInference("abc");
		TypeInference wrapper4 = new TypeInference(new Long(0L));
		
		LinkedList<Long> list = new LinkedList<Long>(); 
	    list.add(0L);  
	    list.add(1L); 
	    max(list);
	    List<Object> dest = new ArrayList<Object>(); 
	    List<Long>   source = new ArrayList<Long>(); 
	    //copy(dest, source);	source and destinations are of different types
	}
	
	@SuppressWarnings("unused")
	private static <T> void copy(List<T> dest, List<T> source) {
		for (int i=0; i<source.size(); i++) {
			dest.add(i, source.get(i));
		}
	}
	
	static private <T> void max(Collection<T> c) {
		for (T t : c) {
			
		}
	}

	@Override
	public int compareTo(T o) {
		return theObject.compareTo(o);
	}

}

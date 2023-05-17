package generics;

import java.util.List;

public class WildcardError {

    static void foo(List<?> i) {
    	fooHelper(i);
    	//i.set(0, i.get(0));
    }
    
    static <T> void fooHelper(List<T> i) {
    	i.set(0, i.get(0));
    }
    
    public static void main(String a[]) {
//    	List<Integer> l = new ArrayList<Integer>(); 
//    	foo(l);
    	Status s = Status.values()[1];
    	System.out.println(s);
    }
}

enum Status {
    CLOSED,
    OPEN,
    ONLINE,
    OFFLINE;

    public boolean isAvailable()
    {
      //The carrier is available if it is open. It is even more available if it is online.
      return this == OPEN || this == ONLINE;
    }
  }

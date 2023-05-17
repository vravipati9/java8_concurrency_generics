package generics;

import java.util.ArrayList;
import java.util.List;

/*
 * This class creates instance for generic parameter.
 */
public class InstanceForGenericType<T> {

		Class<T> c;
	//	public InstanceForGenericType() {
	//		T t = c.newInstance();
	//	}
	private Class<T> typeArgumentClass;
	public InstanceForGenericType(Class<T> typeArgumentClass) {
		this.typeArgumentClass = typeArgumentClass;
	}

	public void doSomethingThatRequiresNewT() throws Exception {
		T myNewT = typeArgumentClass.newInstance();
	}

	public static void main(String[] args) throws Exception {
		InstanceForGenericType<Dum1> d = new InstanceForGenericType<Dum1>(Dum1.class);
		InstanceForGenericType.<String>append(new ArrayList<String>(), String.class);
	}
	
	public static <E> void append(List<E> list, Class<E> cls) throws Exception {
	    E elem = cls.newInstance();   // OK
	    list.add(elem);
	    
	}
}

class Dum1 {}

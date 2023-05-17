package generics;

import generics.model.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PairGenericTest {

	public static void main(String[] args) {
		System.out.println("START");
		Pair<?, ?> pair = new Pair<String, Integer>("MAX", 20);
		printPair(pair);
		m1();
		Object[] objArray = new Object[1];
		objArray[0] = new Pair<String, String>("", "");
		Pair<String,String>[] arr = null; // fine
	}
	
	static private void printPair(Pair<?, ?> pair) {
		System.out.println("("+pair.getFirst()+","+pair.getSecond()+")");
	}
	
	static void m1() {
		List<Date> list = new ArrayList<Date>();
		list.add(new Date());
		m2(list);
	}
	
	static void m2(Object obj) {
		List<String> str = (List<String>) obj;
		m3(str);
	}
	
	static void m3(List<String> str) {
		String s = str.get(0);
		System.out.println(s);
	}
	
}

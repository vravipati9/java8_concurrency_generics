package generics;

import generics.model.Pair;

public class Util {
	
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		if (p1.getFirst().equals(p2.getFirst()) && p1.getSecond().equals(p2.getSecond())) {
			return true;
		} else return false;
	}
	
	public static void main(String a[]) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "apple");
		Pair<Integer, String> p2 = new Pair<Integer, String>(2, "pear");
		boolean result = Util.<Integer, String>compare(p1, p2);
		System.out.println(result);
	}
}


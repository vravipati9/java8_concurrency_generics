package generics;

import generics.model.UnaryPredicate;

import java.util.ArrayList;
import java.util.List;
public class PredicateTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(123);list.add(111);list.add(454);list.add(321);
		
		UnaryPredicate<Integer> predicate = new PalindromPredicate();
		int count = countElements(list, predicate);
		System.out.println(count);
	}
	
	private static <T> int countElements(List<T> list, UnaryPredicate<T> predicate) {
		int count = 0;
		for (T integer : list) {
			
			if ( predicate.test(integer)) {
				count++;
			}
		}
		return count;
	}
	
	public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p) {
		return 0;
	}
	


}

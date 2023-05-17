package generics;

import java.util.Arrays;
import java.util.List;
public class GenericMethodFindMax {

	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(1,3,7,2,6,8,5,4,9);
		Integer mx = findMax(l, 2, 9);
		System.out.println(mx);
	}
	private static <T extends Comparable<T>> T findMax(List<T> l, int beginIndex, int endIndex) {
		List<T> subList = l.subList(beginIndex, endIndex);
		boolean firstElement = true;
		T max = null;
		for (T t : subList) {
			if (firstElement) {
				max = t;
				firstElement = false;
			}
			if (t.compareTo(max) > 0) {
				max = t;
			}
		}
		return max;
	}
}
